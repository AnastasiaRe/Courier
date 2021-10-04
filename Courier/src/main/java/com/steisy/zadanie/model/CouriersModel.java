package com.steisy.zadanie.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "couriers")
public class CouriersModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String courier;

    private int number;

    @Column(name = "date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateTime;

    private String status;
}
