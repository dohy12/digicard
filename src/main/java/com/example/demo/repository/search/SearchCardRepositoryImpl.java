package com.example.demo.repository.search;

import com.example.demo.dto.CardSearchDTO;
import com.example.demo.entity.Card;
import com.example.demo.entity.QCard;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class SearchCardRepositoryImpl implements SearchCardRepository{
    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Card> searchCard(CardSearchDTO searchDTO, Pageable pageable){
        String keyword = searchDTO.getKeyword();
        String kind = searchDTO.getKind();
        String color = searchDTO.getColor();
        String level = searchDTO.getLevel();
        String category = searchDTO.getCategory();

        QCard qCard = QCard.card;

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        BooleanExpression expression = qCard.id.isNotNull();

        booleanBuilder.and(expression);

        //키워드 검색
        BooleanBuilder conditionBuilder = new BooleanBuilder();
        if (keyword != null && !keyword.equals("")){
            conditionBuilder.or(qCard.name.contains(keyword));
            conditionBuilder.or(qCard.id.contains(keyword));
            conditionBuilder.or(qCard.keyword.contains(keyword));
        }
        booleanBuilder.and(conditionBuilder);

        //카드 종류 검색
        if (kind != null && !kind.equals("")){
            booleanBuilder.and((new BooleanBuilder()).or(qCard.kind.eq(kind)));
        }

        //카드 색 검색

        if (color != null && !color.equals("")){
            conditionBuilder = new BooleanBuilder();
            conditionBuilder.or(qCard.color.eq(color));
            conditionBuilder.or(qCard.color2.eq(color));
            booleanBuilder.and(conditionBuilder);
        }

        //카드 레벨 검색
        if (level != null && !level.equals("")){
            booleanBuilder.and((new BooleanBuilder()).or(qCard.level.eq(level)));
        }

        //카드 카테고리 검색
        if (category !=null && !category.equals("")){
            booleanBuilder.and((new BooleanBuilder()).or(qCard.category.eq(category)));
        }

        List<Card> result = queryFactory.select(qCard)
                .from(qCard)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .where(booleanBuilder)
                .fetch();

        Long count = queryFactory
                .select(qCard.count())
                .from(qCard)
                .where(booleanBuilder)
                .fetchOne();

        return new PageImpl<>(result,pageable,count);
    }
}
