package com.capgemini.ticket.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class TicketTest {
    @Test
    public void testSetTicketId() {
        Ticket ticket = new Ticket();
        ticket.setTicketId(123);
        assertEquals(123, ticket.getTicketId());
    }

    @Test
    public void testSetFarenum() {
        Ticket ticket = new Ticket();
        ticket.setFarenum(10);
        assertEquals(10, ticket.getFarenum());
    }

    @Test
    public void testSetFlightId() {
        Ticket ticket = new Ticket();
        ticket.setFlightId("42");
        assertEquals("42", ticket.getFlightId());
    }

    @Test
    public void testSetFlightTakeOffStation() {
        Ticket ticket = new Ticket();
        ticket.setFlightTakeOffStation("Flight Take Off Station");
        assertEquals("Flight Take Off Station", ticket.getFlightTakeOffStation());
    }

    @Test
    public void testSetDepartureDate() {
        Ticket ticket = new Ticket();
        ticket.setDepartureDate("2020-03-01");
        assertEquals("2020-03-01", ticket.getDepartureDate());
    }

    @Test
    public void testSetDepartureTime() {
        Ticket ticket = new Ticket();
        ticket.setDepartureTime("Departure Time");
        assertEquals("Departure Time", ticket.getDepartureTime());
    }

    @Test
    public void testSetFlightLandingStation() {
        Ticket ticket = new Ticket();
        ticket.setFlightLandingStation("Flight Landing Station");
        assertEquals("Flight Landing Station", ticket.getFlightLandingStation());
    }

    @Test
    public void testSetArrivalDate() {
        Ticket ticket = new Ticket();
        ticket.setArrivalDate("2020-03-01");
        assertEquals("2020-03-01", ticket.getArrivalDate());
    }

    @Test
    public void testSetArrivalTime() {
        Ticket ticket = new Ticket();
        ticket.setArrivalTime("Arrival Time");
        assertEquals("Arrival Time", ticket.getArrivalTime());
    }

    @Test
    public void testSetPrice() {
        Ticket ticket = new Ticket();
        ticket.setPrice(1);
        assertEquals(1, ticket.getPrice());
    }

    @Test
    public void testSetPassengerList() {
        Ticket ticket = new Ticket();
        ticket.setPassengerList(new ArrayList<Passenger>());
        assertEquals("Ticket(ticketId=0, farenum=0, flightId=null, flightTakeOffStation=null, departureDate=null,"
                + " departureTime=null, flightLandingStation=null, arrivalDate=null, arrivalTime=null, price=0,"
                + " passengerList=[], ticketAmount=0.0)", ticket.toString());
    }

    @Test
    public void testSetTicketAmount() {
        Ticket ticket = new Ticket();
        ticket.setTicketAmount(10.0);
        assertEquals(10.0, ticket.getTicketAmount());
    }
}

