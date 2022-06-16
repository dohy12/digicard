package com.example.demo.repository;

import com.example.demo.entity.Card;
import com.example.demo.repository.search.SearchCardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CardRepository extends JpaRepository<Card, String>, SearchCardRepository {

}
