package com.example.demo.dto;

import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private String cno;
    private String title;
}
