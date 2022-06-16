package com.example.demo.repository;

import com.example.demo.dto.CardSearchDTO;
import com.example.demo.entity.Card;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class CardRepositoryTests {
    @Autowired
    private CardRepository cardRepository;

    @Test
    public void insertTest(){
        IntStream.rangeClosed(1,10).forEach(i->{
            Card card = Card.builder()
                    .id("card_no"+i)
                    .name("card_name"+i).build();
            System.out.println(card);

            cardRepository.save(card);
        });
    }

    @Test
    public void selectTest(){
        CardSearchDTO searchDTO = CardSearchDTO.builder()
                .keyword("아구몬")
                .level("7")
                .build();

        Page<Card> page = cardRepository.searchCard(searchDTO,PageRequest.of(0,12));
        System.out.println(page.getContent());
        System.out.println(page.getTotalPages());
    }
}
