package com.steisy.zadanie.repository;

import com.steisy.zadanie.model.CouriersModel;
import com.steisy.zadanie.model.PhoneModel;
import com.steisy.zadanie.model.ZadanieModel;
import org.springframework.web.bind.annotation.PostMapping;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface IZadanieRepository {

    /**
     * Сохраняет курьера
     *
     * @param couriersModel курьер
     * @return сохраненного курьера
     */
    CouriersModel create(CouriersModel couriersModel);


    /**
     * Удаляет курьера
     *
     * @param id идентификатор курьера
     */
    void delete(int id);


    /**
     * Добавляет новое задание
     *
     * @param id идентификатор курьера
     * @return курьера
     */
    ZadanieModel save(int id);

    /**
     * возвращает список заданий
     *
     * @return список заданий
     */
    List<ZadanieModel> getAll(String status);

    /**
     * Добавляет в таблицу phone результат прозвона и при необходимости меняет статус в таблице zadanie
     *
     * @param id id задания
     * @param status статус задания
     * @param comment комментарий
     * @return результат прозвона
     */
    PhoneModel savePhone(int id, String status, String comment);
}
