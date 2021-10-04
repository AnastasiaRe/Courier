package com.steisy.zadanie.service;

import com.steisy.zadanie.model.CouriersModel;
import com.steisy.zadanie.model.PhoneModel;
import com.steisy.zadanie.model.ZadanieModel;
import com.steisy.zadanie.repository.ZadanieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZadanieService {

    @Autowired
    private ZadanieRepository zadanieRepository;



    public CouriersModel create(CouriersModel couriersModel){
        return zadanieRepository.create(couriersModel);
    }

    public void delete(int id) {
        zadanieRepository.delete(id);
    }

    public ZadanieModel save(int id) {
        return zadanieRepository.save(id);
    }

    public List<ZadanieModel> getAll(String status) {
        return zadanieRepository.getAll(status);
    }

    public PhoneModel savePhone(int id, String status, String comment){
        return zadanieRepository.savePhone(id, status, comment);
    }

}
