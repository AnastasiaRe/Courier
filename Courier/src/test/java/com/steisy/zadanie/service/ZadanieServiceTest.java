package com.steisy.zadanie.service;

import com.steisy.zadanie.model.CouriersModel;
import com.steisy.zadanie.model.PhoneModel;
import com.steisy.zadanie.model.ZadanieModel;
import com.steisy.zadanie.repository.ZadanieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class ZadanieServiceTest {

    @InjectMocks
    private ZadanieService zadanieService;

    @Mock
    private ZadanieRepository zadanieRepository;

    @Test
    void create() {
        CouriersModel expected = new CouriersModel();
        expected.setId(1);
        expected.setCourier("Ben");
        expected.setDateTime(LocalDateTime.now());
        expected.setNumber(2);
        expected.setStatus("Выполняется");
        Mockito.when(zadanieRepository.create(Mockito.any())).thenReturn(expected);
        CouriersModel actual = zadanieService.create(expected);
        assertEquals(expected, actual);
    }

    @Test
    void delete() {
        Mockito.doNothing().when(zadanieRepository).delete(Mockito.anyInt());
        zadanieRepository.delete(1);
        Mockito.verify(zadanieRepository, Mockito.times(1)).delete(Mockito.anyInt());
    }

    @Test
    void save() {
        ZadanieModel expected = new ZadanieModel();
        expected.setId(1);
        expected.setNumber(2);
        expected.setDateTime(LocalDateTime.now());
        expected.setStatus("Не выполнено");
        Mockito.when(zadanieRepository.save(Mockito.anyInt())).thenReturn(expected);
        ZadanieModel actual = zadanieService.save(1);
        assertEquals(expected, actual);
    }

    @Test
    void getAll() {
        ZadanieModel zadanieModel = new ZadanieModel();
        zadanieModel.setId(1);
        zadanieModel.setNumber(2);
        zadanieModel.setDateTime(LocalDateTime.now());
        zadanieModel.setStatus("Не выполнено");
        List<ZadanieModel> expected = Collections.singletonList(zadanieModel);
        Mockito.when(zadanieRepository.getAll(Mockito.anyString())).thenReturn(expected);
        List<ZadanieModel> actual = zadanieService.getAll("");
        assertEquals(expected, actual);
    }

    @Test
    void savePhone() {
        PhoneModel expected = new PhoneModel();
        expected.setId(1);
        expected.setZadanieId(2);
        expected.setStatus("Не выполнено");
        expected.setComment("Ок");
        Mockito.when(zadanieRepository.savePhone(Mockito.anyInt(), Mockito.anyString(), Mockito.anyString())).thenReturn(expected);
        PhoneModel actual = zadanieService.savePhone(1, "Не выполнено", "Ок");
        assertEquals(expected, actual);
    }
}
