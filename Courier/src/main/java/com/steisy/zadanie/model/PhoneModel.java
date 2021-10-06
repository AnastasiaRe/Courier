package com.steisy.zadanie.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "phone")
public class PhoneModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//Идентификатор записи

    @Column(name = "zadanie_id")
    private int zadanieId;//Идентификатор задания

    private String status;//Статус задания

    private String comment;//Комментарий к заданию
}
