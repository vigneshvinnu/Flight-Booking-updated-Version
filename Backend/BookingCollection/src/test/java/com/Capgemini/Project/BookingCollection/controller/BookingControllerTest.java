package com.Capgemini.Project.BookingCollection.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

import com.Capgemini.Project.BookingCollection.model.Booking;
import com.Capgemini.Project.BookingCollection.model.Passenger;
import com.Capgemini.Project.BookingCollection.service.BookingService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {BookingController.class})
@ExtendWith(SpringExtension.class)
public class BookingControllerTest {
    @Autowired
    private BookingController bookingController;

    @MockBean
    private BookingService bookingService;

    @Test
    public void testGetBookingsByUserId() throws Exception {
        when(this.bookingService.getBookingsByUserId(anyString())).thenReturn(new ArrayList<Booking>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/book/getBookingsByUserId/{userid}",
                "value");
        MockMvcBuilders.standaloneSetup(this.bookingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testGetBookingsByUserId2() throws Exception {
        when(this.bookingService.getBookingsByUserId(anyString())).thenReturn(new ArrayList<Booking>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/book/getBookingsByUserId/{userid}", "value");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.bookingController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testGetAllBookings() throws Exception {
        when(this.bookingService.getAllBookings()).thenReturn(new ArrayList<Booking>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/book/allBookings");
        MockMvcBuilders.standaloneSetup(this.bookingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testGetAllBookings2() throws Exception {
        when(this.bookingService.getAllBookings()).thenReturn(new ArrayList<Booking>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/book/allBookings");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.bookingController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testGetBooking() throws Exception {
        Booking booking = new Booking();
        booking.setBookingAmount(10.0);
        booking.setUserid("Userid");
        booking.setBookingid(1);
        booking.setFlightId("42");
        booking.setPassengerNames(new ArrayList<Passenger>());
        Optional<Booking> ofResult = Optional.<Booking>of(booking);
        when(this.bookingService.getBooking(anyInt())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/book/getBooking/{bookingId}",
                123456789);
        MockMvcBuilders.standaloneSetup(this.bookingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString(
                                "{\"bookingid\":1,\"passengerNames\":[],\"userid\":\"Userid\",\"flightId\":\"42\",\"bookingAmount\":10.0}")));
    }

    @Test
    public void testAddBooking() throws Exception {
        Booking booking = new Booking();
        booking.setBookingAmount(10.0);
        booking.setUserid("Userid");
        booking.setBookingid(1);
        booking.setFlightId("42");
        booking.setPassengerNames(new ArrayList<Passenger>());
        when(this.bookingService.addBooking((Booking) any())).thenReturn(booking);

        Booking booking1 = new Booking();
        booking1.setBookingAmount(10.0);
        booking1.setUserid("Userid");
        booking1.setBookingid(1);
        booking1.setFlightId("42");
        booking1.setPassengerNames(new ArrayList<Passenger>());
        String content = (new ObjectMapper()).writeValueAsString(booking1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/book/addBooking")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.bookingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString(
                                "{\"bookingid\":1,\"passengerNames\":[],\"userid\":\"Userid\",\"flightId\":\"42\",\"bookingAmount\":10.0}")));
    }

    @Test
    public void testUpdateBooking() throws Exception {
        when(this.bookingService.updateBooking((Booking) any(), anyInt())).thenReturn("foo");

        Booking booking = new Booking();
        booking.setBookingAmount(10.0);
        booking.setUserid("Userid");
        booking.setBookingid(1);
        booking.setFlightId("42");
        booking.setPassengerNames(new ArrayList<Passenger>());
        String content = (new ObjectMapper()).writeValueAsString(booking);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/book/updateBooking/{bookingid}", 123456789)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.bookingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("foo")));
    }

    @Test
    public void testDeleteBooking() throws Exception {
        when(this.bookingService.deleteBooking(anyInt())).thenReturn("foo");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/book/deleteBooking/{bookingId}",
                123456789);
        MockMvcBuilders.standaloneSetup(this.bookingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("foo")));
    }

    @Test
    public void testDeleteBooking2() throws Exception {
        when(this.bookingService.deleteBooking(anyInt())).thenReturn("foo");
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/book/deleteBooking/{bookingId}",
                123456789);
        deleteResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.bookingController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("foo")));
    }
}

