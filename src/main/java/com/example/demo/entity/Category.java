package com.example.demo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@ToString
public class Category {
    @Id
    private String id;

    private String cno;

    private String title;
}
