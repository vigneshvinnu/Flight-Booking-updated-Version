package com.Capgemini.Project.userandadminoperations.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FlightsTest {
    @Test
    public void testConstructor() {
        Flights actualFlights = new Flights("42", "Flight Take Off Station", "2020-03-01", "Departure Time",
                "Flight Landing Station", "2020-03-01", "Arrival Time", 1);
        assertEquals("2020-03-01", actualFlights.getArrivalDate());
        assertEquals(1, actualFlights.getPrice());
        assertEquals("Flight Take Off Station", actualFlights.getFlightTakeOffStation());
        assertEquals("Flight Landing Station", actualFlights.getFlightLandingStation());
        assertEquals("42", actualFlights.getFlightId());
        assertEquals("Departure Time", actualFlights.getDepartureTime());
        assertEquals("2020-03-01", actualFlights.getDepartureDate());
        assertEquals("Arrival Time", actualFlights.getArrivalTime());
    }
}

