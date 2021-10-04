package com.steisy.zadanie.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "phone")
public class PhoneModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "zadanie_id")
    private int zadanieId;

    private String status;

    private String comment;
}
