package com.Capgemini.Project.BookingCollection.service;

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

import com.Capgemini.Project.BookingCollection.exception.NotFoundException;
import com.Capgemini.Project.BookingCollection.model.Booking;
import com.Capgemini.Project.BookingCollection.model.Flights;
import com.Capgemini.Project.BookingCollection.model.Passenger;
import com.Capgemini.Project.BookingCollection.repository.BookingRepository;

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

@ContextConfiguration(classes = {RestTemplate.class, ReferenceNumberGenerator.class, BookingService.class})
@ExtendWith(SpringExtension.class)

public class BookingServiceTest {
    @MockBean
    private BookingRepository bookingRepository;

    @Autowired
    private BookingService bookingService;

    @MockBean
    private ReferenceNumberGenerator referenceNumberGenerator;

    @MockBean
    private RestTemplate restTemplate;

    @Test
    public void testAddBooking() throws RestClientException {
        when(this.restTemplate.getForObject(anyString(), (Class<Object>) any(), (Object[]) any()))
                .thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.bookingService.addBooking(new Booking()));
        verify(this.restTemplate).getForObject(anyString(), (Class<Object>) any(), (Object[]) any());
    }

    @Test
    public void testAddBooking2() throws RestClientException {
        Booking booking = new Booking();
        booking.setBookingAmount(10.0);
        booking.setUserid("Userid");
        booking.setBookingid(1);
        booking.setFlightId("42");
        booking.setPassengerNames(new ArrayList<Passenger>());
        when(this.bookingRepository.save((Booking) any())).thenReturn(booking);
        when(this.referenceNumberGenerator.getReferenceNumber(anyString())).thenReturn(1);
        when(this.restTemplate.getForObject(anyString(), (Class<Object>) any(), (Object[]) any()))
                .thenReturn(new Flights());
        Booking booking1 = new Booking();
        assertSame(booking, this.bookingService.addBooking(booking1));
        verify(this.bookingRepository).save((Booking) any());
        verify(this.referenceNumberGenerator).getReferenceNumber(anyString());
        verify(this.restTemplate).getForObject(anyString(), (Class<Object>) any(), (Object[]) any());
        assertEquals(0.0, booking1.getBookingAmount());
        assertEquals(1, booking1.getBookingid());
    }

    @Test
    public void testAddBooking3() throws RestClientException {
        Booking booking = new Booking();
        booking.setBookingAmount(10.0);
        booking.setUserid("Userid");
        booking.setBookingid(1);
        booking.setFlightId("42");
        booking.setPassengerNames(new ArrayList<Passenger>());
        when(this.bookingRepository.save((Booking) any())).thenReturn(booking);
        when(this.referenceNumberGenerator.getReferenceNumber(anyString())).thenReturn(1);
        when(this.restTemplate.getForObject(anyString(), (Class<Object>) any(), (Object[]) any())).thenReturn(null);
        Booking booking1 = mock(Booking.class);
        when(booking1.getFlightId()).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.bookingService.addBooking(booking1));
        verify(booking1).getFlightId();
    }

    @Test
    public void testAddBooking4() throws RestClientException {
        Booking booking = new Booking();
        booking.setBookingAmount(10.0);
        booking.setUserid("Userid");
        booking.setBookingid(1);
        booking.setFlightId("42");
        booking.setPassengerNames(new ArrayList<Passenger>());
        when(this.bookingRepository.save((Booking) any())).thenReturn(booking);
        when(this.referenceNumberGenerator.getReferenceNumber(anyString())).thenReturn(1);
        when(this.restTemplate.getForObject(anyString(), (Class<Object>) any(), (Object[]) any()))
                .thenReturn(new Flights());
        Booking booking1 = mock(Booking.class);
        doNothing().when(booking1).setBookingid(anyInt());
        doNothing().when(booking1).setBookingAmount(anyDouble());
        when(booking1.getFlightId()).thenReturn("foo");
        assertSame(booking, this.bookingService.addBooking(booking1));
        verify(booking1).setBookingAmount(anyDouble());
        verify(booking1).setBookingid(anyInt());
        verify(booking1).getFlightId();
        verify(this.bookingRepository).save((Booking) any());
        verify(this.referenceNumberGenerator).getReferenceNumber(anyString());
        verify(this.restTemplate).getForObject(anyString(), (Class<Object>) any(), (Object[]) any());
    }

    @Test
    public void testGetBookingsList() {
        when(this.bookingRepository.findAll()).thenReturn(new ArrayList<Booking>());
        assertThrows(NotFoundException.class, () -> this.bookingService.getBookingsList());
        verify(this.bookingRepository).findAll();
    }

    @Test
    public void testGetBookingsList2() {
        Booking booking = new Booking();
        booking.setBookingAmount(10.0);
        booking.setUserid("No Bookings Available");
        booking.setBookingid(1);
        booking.setFlightId("42");
        booking.setPassengerNames(new ArrayList<Passenger>());

        ArrayList<Booking> bookingList = new ArrayList<Booking>();
        bookingList.add(booking);
        when(this.bookingRepository.findAll()).thenReturn(bookingList);
        assertEquals(1, this.bookingService.getBookingsList().size());
        verify(this.bookingRepository).findAll();
        assertSame(bookingList, this.bookingService.getAllBookings());
    }

    @Test
    public void testGetBookingsList3() {
        Booking booking = new Booking();
        booking.setBookingAmount(10.0);
        booking.setUserid("No Bookings Available");
        booking.setBookingid(1);
        booking.setFlightId("42");
        booking.setPassengerNames(new ArrayList<Passenger>());

        Booking booking1 = new Booking();
        booking1.setBookingAmount(10.0);
        booking1.setUserid("Userid");
        booking1.setBookingid(1);
        booking1.setFlightId("42");
        booking1.setPassengerNames(new ArrayList<Passenger>());

        ArrayList<Booking> bookingList = new ArrayList<Booking>();
        bookingList.add(booking1);
        bookingList.add(booking);
        when(this.bookingRepository.findAll()).thenReturn(bookingList);
        assertEquals(2, this.bookingService.getBookingsList().size());
        verify(this.bookingRepository).findAll();
        assertSame(bookingList, this.bookingService.getAllBookings());
    }

    @Test
    public void testUpdateBooking() {
        Booking booking = new Booking();
        booking.setBookingAmount(10.0);
        booking.setUserid("Userid");
        booking.setBookingid(1);
        booking.setFlightId("42");
        booking.setPassengerNames(new ArrayList<Passenger>());
        Optional<Booking> ofResult = Optional.<Booking>of(booking);

        Booking booking1 = new Booking();
        booking1.setBookingAmount(10.0);
        booking1.setUserid("Userid");
        booking1.setBookingid(1);
        booking1.setFlightId("42");
        booking1.setPassengerNames(new ArrayList<Passenger>());
        when(this.bookingRepository.save((Booking) any())).thenReturn(booking1);
        doNothing().when(this.bookingRepository).deleteById((Integer) any());
        when(this.bookingRepository.findById((Integer) any())).thenReturn(ofResult);
        assertEquals("Booking Updated with: 0", this.bookingService.updateBooking(new Booking(), 1));
        verify(this.bookingRepository).deleteById((Integer) any());
        verify(this.bookingRepository).save((Booking) any());
        verify(this.bookingRepository).findById((Integer) any());
    }

    @Test
    public void testUpdateBooking2() {
        Booking booking = new Booking();
        booking.setBookingAmount(10.0);
        booking.setUserid("Userid");
        booking.setBookingid(1);
        booking.setFlightId("42");
        booking.setPassengerNames(new ArrayList<Passenger>());
        when(this.bookingRepository.save((Booking) any())).thenReturn(booking);
        doNothing().when(this.bookingRepository).deleteById((Integer) any());
        when(this.bookingRepository.findById((Integer) any())).thenReturn(Optional.<Booking>empty());
        assertThrows(NotFoundException.class, () -> this.bookingService.updateBooking(new Booking(), 1));
        verify(this.bookingRepository).findById((Integer) any());
    }

    @Test
    public void testDeleteBooking() {
        doNothing().when(this.bookingRepository).deleteById((Integer) any());
        when(this.bookingRepository.existsById((Integer) any())).thenReturn(true);
        assertEquals("Booking Deleted with booking Id : 1", this.bookingService.deleteBooking(1));
        verify(this.bookingRepository).deleteById((Integer) any());
        verify(this.bookingRepository).existsById((Integer) any());
    }

    @Test
    public void testDeleteBooking2() {
        doNothing().when(this.bookingRepository).deleteById((Integer) any());
        when(this.bookingRepository.existsById((Integer) any())).thenReturn(false);
        assertThrows(NotFoundException.class, () -> this.bookingService.deleteBooking(1));
        verify(this.bookingRepository).existsById((Integer) any());
    }

    @Test
    public void testGetBooking() {
        Booking booking = new Booking();
        booking.setBookingAmount(10.0);
        booking.setUserid("Userid");
        booking.setBookingid(1);
        booking.setFlightId("42");
        booking.setPassengerNames(new ArrayList<Passenger>());
        Optional<Booking> ofResult = Optional.<Booking>of(booking);
        when(this.bookingRepository.findById((Integer) any())).thenReturn(ofResult);
        assertSame(ofResult, this.bookingService.getBooking(123));
        verify(this.bookingRepository).findById((Integer) any());
    }

    @Test
    public void testGetBooking2() {
        when(this.bookingRepository.findById((Integer) any())).thenReturn(Optional.<Booking>empty());
        assertThrows(NotFoundException.class, () -> this.bookingService.getBooking(123));
        verify(this.bookingRepository).findById((Integer) any());
    }

    @Test
    public void testGetAllBookings() {
        when(this.bookingRepository.findAll()).thenReturn(new ArrayList<Booking>());
        assertThrows(NotFoundException.class, () -> this.bookingService.getAllBookings());
        verify(this.bookingRepository).findAll();
    }

    @Test
    public void testGetAllBookings2() {
        Booking booking = new Booking();
        booking.setBookingAmount(10.0);
        booking.setUserid("No Booking available");
        booking.setBookingid(1);
        booking.setFlightId("42");
        booking.setPassengerNames(new ArrayList<Passenger>());

        ArrayList<Booking> bookingList = new ArrayList<Booking>();
        bookingList.add(booking);
        when(this.bookingRepository.findAll()).thenReturn(bookingList);
        List<Booking> actualAllBookings = this.bookingService.getAllBookings();
        assertSame(bookingList, actualAllBookings);
        assertEquals(1, actualAllBookings.size());
        verify(this.bookingRepository).findAll();
    }

    @Test
    public void testGetBookingsByUserId() {
        when(this.bookingRepository.findByUserid(anyString())).thenReturn(new ArrayList<Booking>());
        assertThrows(NotFoundException.class, () -> this.bookingService.getBookingsByUserId("Userid"));
        verify(this.bookingRepository).findByUserid(anyString());
    }

    @Test
    public void testGetBookingsByUserId2() {
        Booking booking = new Booking();
        booking.setBookingAmount(10.0);
        booking.setUserid("Userid");
        booking.setBookingid(1);
        booking.setFlightId("42");
        booking.setPassengerNames(new ArrayList<Passenger>());

        ArrayList<Booking> bookingList = new ArrayList<Booking>();
        bookingList.add(booking);
        when(this.bookingRepository.findByUserid(anyString())).thenReturn(bookingList);
        List<Booking> actualBookingsByUserId = this.bookingService.getBookingsByUserId("Userid");
        assertSame(bookingList, actualBookingsByUserId);
        assertEquals(1, actualBookingsByUserId.size());
        verify(this.bookingRepository).findByUserid(anyString());
    }
}

