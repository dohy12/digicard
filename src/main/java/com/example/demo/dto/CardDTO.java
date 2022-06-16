package com.example.demo.dto;

import com.example.demo.entity.Card;
import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardDTO {
    private String id;
    private String name;
    private String kind;

    private String color;

    private String level;

    private String effect1;
    private String effect2;
    private String effect3;

    private String img;

    public CardDTO(Card card){
        this.id = card.getId();
        this.name = card.getName();
        this.kind = card.getKind();
        this.color = card.getColor();
        this.level = card.getLevel();
        this.effect1 = card.getEffect1();
        this.effect2 = card.getEffect2();
        this.effect3 = card.getEffect3();
        this.img = card.getImg();
    }
}
