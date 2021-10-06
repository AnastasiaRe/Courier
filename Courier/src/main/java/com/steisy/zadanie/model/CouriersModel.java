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
    private int id;//Идентификатор курьера

    private String courier;//Курьер

    private int number;//Номер задания

    @Column(name = "date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateTime;//Дата и время добавления задания

    private String status;//Статус задания
}
