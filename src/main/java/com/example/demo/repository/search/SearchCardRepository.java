package com.example.demo.repository.search;

import com.example.demo.dto.CardSearchDTO;
import com.example.demo.entity.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SearchCardRepository {
    Page<Card> searchCard(CardSearchDTO searchDTO, Pageable pageable);
}
