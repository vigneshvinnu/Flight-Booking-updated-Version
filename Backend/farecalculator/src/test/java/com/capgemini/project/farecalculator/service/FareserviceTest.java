package com.capgemini.project.farecalculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.capgemini.project.farecalculator.exception.NotFoundException;
import com.capgemini.project.farecalculator.model.Booking;
import com.capgemini.project.farecalculator.model.Fare;
import com.capgemini.project.farecalculator.model.Passenger;
import com.capgemini.project.farecalculator.repository.Farerepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@ContextConfiguration(classes = {ReferenceNumberGenerator.class, RestTemplate.class, Fareservice.class})
@ExtendWith(SpringExtension.class)
public class FareserviceTest {
    @MockBean
    private Farerepository farerepository;

    @Autowired
    private Fareservice fareservice;

    @MockBean
    private ReferenceNumberGenerator referenceNumberGenerator;

    @MockBean
    private RestTemplate restTemplate;

    @Test
    public void testSaveOrUpdate() throws RestClientException {
        when(this.restTemplate.getForObject(anyString(), (Class<Object>) any(), (Object[]) any()))
                .thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.fareservice.saveOrUpdate(new Fare(10, 1, 10.0)));
        verify(this.restTemplate).getForObject(anyString(), (Class<Object>) any(), (Object[]) any());
    }

    @Test
    public void testSaveOrUpdate2() throws RestClientException {
        when(this.restTemplate.getForObject(anyString(), (Class<Object>) any(), (Object[]) any()))
                .thenReturn(new Booking(1, new ArrayList<Passenger>(), "Userid", "42", 10.0));
        when(this.referenceNumberGenerator.getReferenceNumber(anyString())).thenReturn(1);

        Fare fare = new Fare();
        fare.setBookingfare(10.0);
        fare.setBookingid(1);
        fare.setFarenum(10);
        when(this.farerepository.save((Fare) any())).thenReturn(fare);
        Fare fare1 = new Fare(10, 1, 10.0);
        assertSame(fare, this.fareservice.saveOrUpdate(fare1));
        verify(this.farerepository).save((Fare) any());
        verify(this.referenceNumberGenerator).getReferenceNumber(anyString());
        verify(this.restTemplate).getForObject(anyString(), (Class<Object>) any(), (Object[]) any());
        assertEquals(0.0, fare1.getBookingfare());
        assertEquals(1, fare1.getFarenum());
    }

    @Test
    public void testSaveOrUpdate3() throws RestClientException {
        when(this.restTemplate.getForObject(anyString(), (Class<Object>) any(), (Object[]) any())).thenReturn(null);
        when(this.referenceNumberGenerator.getReferenceNumber(anyString())).thenReturn(1);

        Fare fare = new Fare();
        fare.setBookingfare(10.0);
        fare.setBookingid(1);
        fare.setFarenum(10);
        when(this.farerepository.save((Fare) any())).thenReturn(fare);
        Fare fare1 = mock(Fare.class);
        when(fare1.getBookingid()).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.fareservice.saveOrUpdate(fare1));
        verify(fare1).getBookingid();
    }

    @Test
    public void testSaveOrUpdate4() throws RestClientException {
        when(this.restTemplate.getForObject(anyString(), (Class<Object>) any(), (Object[]) any()))
                .thenReturn(new Booking(1, new ArrayList<Passenger>(), "Userid", "42", 10.0));
        when(this.referenceNumberGenerator.getReferenceNumber(anyString())).thenReturn(1);

        Fare fare = new Fare();
        fare.setBookingfare(10.0);
        fare.setBookingid(1);
        fare.setFarenum(10);
        when(this.farerepository.save((Fare) any())).thenReturn(fare);
        Fare fare1 = mock(Fare.class);
        doNothing().when(fare1).setFarenum(anyInt());
        doNothing().when(fare1).setBookingfare(anyDouble());
        when(fare1.getBookingid()).thenReturn(1);
        assertSame(fare, this.fareservice.saveOrUpdate(fare1));
        verify(fare1).setBookingfare(anyDouble());
        verify(fare1).getBookingid();
        verify(fare1).setFarenum(anyInt());
        verify(this.farerepository).save((Fare) any());
        verify(this.referenceNumberGenerator).getReferenceNumber(anyString());
        verify(this.restTemplate).getForObject(anyString(), (Class<Object>) any(), (Object[]) any());
    }

    @Test
    public void testGetAll() {
        when(this.farerepository.findAll()).thenReturn(new ArrayList<Fare>());
        assertThrows(NotFoundException.class, () -> this.fareservice.getAll());
        verify(this.farerepository).findAll();
    }

    @Test
    public void testGetAll2() {
        Fare fare = new Fare();
        fare.setBookingfare(10.0);
        fare.setBookingid(1);
        fare.setFarenum(10);

        ArrayList<Fare> fareList = new ArrayList<Fare>();
        fareList.add(fare);
        when(this.farerepository.findAll()).thenReturn(fareList);
        List<Fare> actualAll = this.fareservice.getAll();
        assertSame(fareList, actualAll);
        assertEquals(1, actualAll.size());
        verify(this.farerepository).findAll();
    }

    @Test
    public void testGetByFarenum() {
        Fare fare = new Fare();
        fare.setBookingfare(10.0);
        fare.setBookingid(1);
        fare.setFarenum(10);
        Optional<Fare> ofResult = Optional.<Fare>of(fare);
        when(this.farerepository.findById((Integer) any())).thenReturn(ofResult);
        assertSame(ofResult, this.fareservice.getByFarenum(10));
        verify(this.farerepository).findById((Integer) any());
    }

    @Test
    public void testGetByFarenum2() {
        when(this.farerepository.findById((Integer) any())).thenReturn(Optional.<Fare>empty());
        assertThrows(NotFoundException.class, () -> this.fareservice.getByFarenum(10));
        verify(this.farerepository).findById((Integer) any());
    }
}

