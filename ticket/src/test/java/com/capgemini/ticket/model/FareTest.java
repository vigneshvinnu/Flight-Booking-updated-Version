package com.capgemini.ticket.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class FareTest {
    @Test
    public void testCanEqual() {
        assertFalse((new Fare(10, "Bookingid", 10.0)).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        Fare fare = new Fare(10, "Bookingid", 10.0);
        assertTrue(fare.canEqual(new Fare(10, "Bookingid", 10.0)));
    }

    @Test
    public void testEquals() {
        assertFalse((new Fare(10, "Bookingid", 10.0)).equals("42"));
    }

    @Test
    public void testEquals2() {
        Fare fare = new Fare(10, "Bookingid", 10.0);
        assertTrue(fare.equals(new Fare(10, "Bookingid", 10.0)));
    }

    @Test
    public void testEquals3() {
        Fare fare = new Fare(10, "Bookingid", 10.0);
        assertFalse(fare.equals(new Fare()));
    }

    @Test
    public void testEquals4() {
        Fare fare = new Fare(10, null, 10.0);
        assertFalse(fare.equals(new Fare(10, "Bookingid", 10.0)));
    }

    @Test
    public void testEquals5() {
        Fare fare = new Fare(10, "com.capgemini.ticket.model.Fare", 10.0);
        assertFalse(fare.equals(new Fare(10, "Bookingid", 10.0)));
    }

    @Test
    public void testEquals6() {
        Fare fare = new Fare(10, "Bookingid", 0.5);
        assertFalse(fare.equals(new Fare(10, "Bookingid", 10.0)));
    }

    @Test
    public void testEquals7() {
        Fare fare = new Fare();
        assertTrue(fare.equals(new Fare()));
    }

    @Test
    public void testHashCode() {
        assertEquals(-1191432879, (new Fare(10, "Bookingid", 10.0)).hashCode());
        assertEquals(-934303128, (new Fare(10, null, 10.0)).hashCode());
    }

    @Test
    public void testSetBookingfare() {
        Fare fare = new Fare(10, "Bookingid", 10.0);
        fare.setBookingfare(10.0);
        assertEquals(10.0, fare.getBookingfare());
    }

    @Test
    public void testSetBookingid() {
        Fare fare = new Fare(10, "Bookingid", 10.0);
        fare.setBookingid("Bookingid");
        assertEquals("Bookingid", fare.getBookingid());
    }

    @Test
    public void testSetFarenum() {
        Fare fare = new Fare(10, "Bookingid", 10.0);
        fare.setFarenum(10);
        assertEquals(10, fare.getFarenum());
    }
}

