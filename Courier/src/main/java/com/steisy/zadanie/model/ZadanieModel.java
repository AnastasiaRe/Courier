package com.steisy.zadanie.model;

import lombok.Data;
import javax.persistence.*;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "zadanie")
public class ZadanieModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//Идентификатор задания

    private int number;//Номер задания

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_time")
    private LocalDateTime dateTime;//Дата и время добавления задания

    private String status;//Статус задания
}
