package com.steisy.zadanie.repository;

import com.steisy.zadanie.model.CouriersModel;
import com.steisy.zadanie.model.PhoneModel;
import com.steisy.zadanie.model.ZadanieModel;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ZadanieRepository implements IZadanieRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public CouriersModel create(CouriersModel couriersModel) {
        couriersModel.setDateTime(LocalDateTime.now());
        entityManager.persist(couriersModel);
        return couriersModel;
    }

    public void delete(int id) {
        CouriersModel couriersModel = entityManager.find(CouriersModel.class, id);
        if (couriersModel != null) {
            entityManager.remove(couriersModel);
        }
    }

    public ZadanieModel save(int id) {
        CouriersModel original = entityManager.find(CouriersModel.class, id);
        ZadanieModel model = new ZadanieModel();
        if (original != null) {
            model.setNumber(original.getNumber());
            model.setDateTime(LocalDateTime.now());
            model.setStatus("Не выполнено");
            entityManager.persist(model);
        }
        return model;
    }

    public List<ZadanieModel> getAll(String status) {
        List<ZadanieModel> zadanieModels = new ArrayList<>();

        switch (status){
            case "number":
               zadanieModels = entityManager.createQuery("FROM ZadanieModel z ORDER BY z.number", ZadanieModel.class)
                        .getResultList();
                break;
            case "status":
                zadanieModels = entityManager.createQuery("FROM ZadanieModel z ORDER BY z.status ASC", ZadanieModel.class)
                        .getResultList();
                break;
            default:
              zadanieModels = entityManager.createNativeQuery("SELECT * FROM zadanie ORDER BY date_time BETWEEN '2021-09-13' AND '2021-09-19'", ZadanieModel.class)
                        .getResultList();
        }
        return zadanieModels;
    }

    public PhoneModel savePhone( int id, String status, String comment){
        ZadanieModel zadanieModel = entityManager.find(ZadanieModel.class, id);
        PhoneModel phone = new PhoneModel();
            phone.setZadanieId(zadanieModel.getId());
            phone.setStatus(status);
            phone.setComment(comment);
            entityManager.persist(phone);

        if (!zadanieModel.getStatus().equals(phone.getStatus())){
            zadanieModel.setStatus(phone.getStatus());
            entityManager.persist(zadanieModel);
            return phone;
        }
        return phone;
    }

}

