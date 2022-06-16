package com.example.demo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@ToString(exclude = {"effect1","effect2","effect3","keyword"})
public class Card {
    @Id
    private String id;
    private String name;
    private String kind;

    private String color;
    private String color2;

    private String level;

    private String effect1;
    private String effect2;
    private String effect3;

    private String keyword;

    private String category;

    private String img;
}
