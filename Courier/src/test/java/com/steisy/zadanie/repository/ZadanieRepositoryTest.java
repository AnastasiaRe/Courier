package com.steisy.zadanie.repository;

import com.steisy.zadanie.model.CouriersModel;
import com.steisy.zadanie.model.PhoneModel;
import com.steisy.zadanie.model.ZadanieModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
public class ZadanieRepositoryTest {

    @InjectMocks
    private ZadanieRepository zadanieRepository;

    @Mock
    private EntityManager entityManager;

    @Test
    void create() {
        CouriersModel expected = new CouriersModel();
        expected.setId(1);
        expected.setCourier("c");
        expected.setNumber(2);
        expected.setDateTime(LocalDateTime.now());
        expected.setStatus("a");
        Mockito.doNothing().when(entityManager).persist(Mockito.any());
        CouriersModel actual = zadanieRepository.create(expected);
        assertEquals(expected, actual);
    }

    @Test
    void delete() {
        CouriersModel expected = new CouriersModel();
        expected.setId(1);
        expected.setCourier("c");
        expected.setNumber(2);
        expected.setDateTime(LocalDateTime.now());
        expected.setStatus("a");
        Mockito.when(entityManager.find(eq(CouriersModel.class), Mockito.any())).thenReturn(expected);
        Mockito.doNothing().when(entityManager).remove(Mockito.any());
        zadanieRepository.delete(1);
        Mockito.verify(entityManager, Mockito.times(1)).find(eq(CouriersModel.class), Mockito.any());
        Mockito.verify(entityManager, Mockito.times(1)).remove(Mockito.any());
    }

    @Test
    void save() {
        LocalDateTime date = LocalDateTime.now();
        CouriersModel original = new CouriersModel();
        original.setId(1);
        original.setNumber(2);
        original.setDateTime(date);
        original.setStatus("Не выполнено");
        Mockito.when(entityManager.find(eq(CouriersModel.class), Mockito.any())).thenReturn(original);
        Mockito.doNothing().when(entityManager).persist(Mockito.any());
        ZadanieModel actual = zadanieRepository.save(1);
        assertEquals(2, actual.getNumber());
        assertEquals("Не выполнено", actual.getStatus());
        Mockito.verify(entityManager, Mockito.times(1)).find(eq(CouriersModel.class), Mockito.any());
        Mockito.verify(entityManager, Mockito.times(1)).persist(Mockito.any());
    }

    @Test
    void getAll() {
        ZadanieModel zadanieModel = new ZadanieModel();
        zadanieModel.setId(1);
        zadanieModel.setNumber(2);
        zadanieModel.setDateTime(LocalDateTime.now());
        zadanieModel.setStatus("Не выполнено");
        List<ZadanieModel> expected = new ArrayList<>();
        Mockito.when(entityManager.createQuery(eq("number")).getResultList()).thenReturn(expected);
        Mockito.when(entityManager.createQuery(eq("status")).getResultList()).thenReturn(expected);
        Mockito.when(entityManager.createNativeQuery(eq("")).getResultList()).thenReturn(expected);
        List<ZadanieModel> actual = zadanieRepository.getAll("");
        assertEquals(expected, actual);
    }

    @Test
    void savePhone(){
        ZadanieModel zadanieModel = new ZadanieModel();
        zadanieModel.setId(1);
        zadanieModel.setNumber(2);
        zadanieModel.setDateTime(LocalDateTime.now());
        zadanieModel.setStatus("Не выполнено");
        PhoneModel expected = new PhoneModel();
        expected.setZadanieId(1);
        expected.setStatus("Не выполнено");
        expected.setComment("Ок");
        Mockito.when(entityManager.find(eq(ZadanieModel.class), Mockito.any())).thenReturn(zadanieModel);
        Mockito.doNothing().when(entityManager).persist(expected);
        PhoneModel actual = zadanieRepository.savePhone(1, "Не выполнено", "Ок");
        assertEquals(1, actual.getZadanieId());
        assertEquals("Не выполнено", actual.getStatus());
        assertEquals("Ок", actual.getComment());
    }
}