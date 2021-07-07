package com.capgemini.ticket.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FlightsTest {
    @Test
    public void testSetArrivalDate() {
        Flights flights = new Flights();
        flights.setArrivalDate("2020-03-01");
        assertEquals("2020-03-01", flights.getArrivalDate());
    }

    @Test
    public void testSetArrivalTime() {
        Flights flights = new Flights();
        flights.setArrivalTime("Arrival Time");
        assertEquals("Arrival Time", flights.getArrivalTime());
    }

    @Test
    public void testSetDepartureDate() {
        Flights flights = new Flights();
        flights.setDepartureDate("2020-03-01");
        assertEquals("2020-03-01", flights.getDepartureDate());
    }

    @Test
    public void testSetDepartureTime() {
        Flights flights = new Flights();
        flights.setDepartureTime("Departure Time");
        assertEquals("Departure Time", flights.getDepartureTime());
    }

    @Test
    public void testSetFlightId() {
        Flights flights = new Flights();
        flights.setFlightId("42");
        assertEquals("42", flights.getFlightId());
    }

    @Test
    public void testSetFlightLandingStation() {
        Flights flights = new Flights();
        flights.setFlightLandingStation("Flight Landing Station");
        assertEquals("Flight Landing Station", flights.getFlightLandingStation());
    }

    @Test
    public void testSetFlightTakeOffStation() {
        Flights flights = new Flights();
        flights.setFlightTakeOffStation("Flight Take Off Station");
        assertEquals("Flight Take Off Station", flights.getFlightTakeOffStation());
    }

    @Test
    public void testSetPrice() {
        Flights flights = new Flights();
        flights.setPrice(1);
        assertEquals(1, flights.getPrice());
    }
}

