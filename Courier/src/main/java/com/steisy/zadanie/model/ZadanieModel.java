package com.steisy.zadanie.model;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;


@Data
@Entity
@Table(name = "zadanie")
public class ZadanieModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int number;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_time")
    private LocalDateTime dateTime;



    private String status;
}
