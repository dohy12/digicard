package com.example.demo.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CardSearchDTO {
    private String keyword;
    private String kind;
    private String color;
    private String level;
    private String category;

    public String getLink(){
        String rs = "";
        if (keyword != null) rs += "&keyword=" +keyword;
        if (kind != null) rs += "&kind=" + kind;
        if (color != null) rs += "&color=" + color;
        if (level != null) rs += "&level=" + level;
        if (category != null) rs += "&category=" + category;
        return rs;
    }
}
