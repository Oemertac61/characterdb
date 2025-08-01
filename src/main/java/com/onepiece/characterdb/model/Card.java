package com.onepiece.characterdb.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cardType;    // Leader, Character, Event, Stage
    private String color;       // Rot, Blau, Grün etc.
    private String attribute;   // Slash, Wisdom, Strike etc.
    private int power;
    private int cost;

    @Column(length = 2000)
    private String effect;

    private String imageUrl;    // Pfad oder URL zum Kartenbild
}
