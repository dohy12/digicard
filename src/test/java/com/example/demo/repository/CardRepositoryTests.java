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
}
