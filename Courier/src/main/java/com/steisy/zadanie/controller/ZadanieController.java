package com.steisy.zadanie.controller;

import com.steisy.zadanie.model.CouriersModel;
import com.steisy.zadanie.model.PhoneModel;
import com.steisy.zadanie.model.ZadanieModel;
import com.steisy.zadanie.service.ZadanieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/zadanie", produces = MediaType.APPLICATION_JSON_VALUE)
public class ZadanieController {

    @Autowired
    private ZadanieService zadanieService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CouriersModel create(@RequestBody CouriersModel couriersModel){
        return zadanieService.create(couriersModel);
    }

    @PostMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestParam int id) {
        zadanieService.delete(id);
    }

    @PostMapping("/save")
    public ZadanieModel save(@RequestParam int id) {
        return  zadanieService.save(id);
    }

    @PostMapping("/all")
    public List<ZadanieModel> getAll(@RequestParam String status) {
        return zadanieService.getAll(status);
    }

    @PostMapping("/savePhone")
    @ResponseStatus(HttpStatus.CREATED)
    public PhoneModel savePhone(@RequestParam int id, @RequestParam String status, @RequestParam String comment){
        return zadanieService.savePhone(id, status, comment);
    }

}
