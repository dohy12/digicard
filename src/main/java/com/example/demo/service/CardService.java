package com.example.demo.service;

import com.example.demo.dto.CardDTO;
import com.example.demo.dto.CardSearchDTO;
import com.example.demo.dto.PageResultDTO;
import com.example.demo.entity.Card;
import com.example.demo.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@RequiredArgsConstructor
@Service
public class CardService {
    private final CardRepository cardRepository;

    public CardDTO entityToDTO(Card card){
        CardDTO cardDTO = new CardDTO(card);
        return cardDTO;
    }

    public PageResultDTO<CardDTO, Card> searchCard(CardSearchDTO searchDTO, int page){
        Page<Card> cardPage = cardRepository.searchCard(searchDTO, PageRequest.of(page,20));
        Function<Card, CardDTO> fn = (Card card) -> {return entityToDTO(card);};
        return new PageResultDTO<CardDTO, Card>(cardPage, fn);
    }
}
