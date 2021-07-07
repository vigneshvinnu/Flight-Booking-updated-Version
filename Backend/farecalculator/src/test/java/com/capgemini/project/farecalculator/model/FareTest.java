package com.capgemini.project.farecalculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class FareTest {
    @Test
    public void testCanEqual() {
        assertFalse((new Fare(10, 1, 10.0)).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        Fare fare = new Fare(10, 1, 10.0);

        Fare fare1 = new Fare();
        fare1.setBookingfare(10.0);
        fare1.setBookingid(1);
        fare1.setFarenum(10);
        assertTrue(fare.canEqual(fare1));
    }

    @Test
    public void testEquals() {
        assertFalse((new Fare(10, 1, 10.0)).equals("42"));
    }

    @Test
    public void testEquals2() {
        Fare fare = new Fare(10, 1, 10.0);

        Fare fare1 = new Fare();
        fare1.setBookingfare(10.0);
        fare1.setBookingid(1);
        fare1.setFarenum(10);
        assertTrue(fare.equals(fare1));
    }

    @Test
    public void testEquals3() {
        Fare fare = new Fare(10, 1, 10.0);
        assertFalse(fare.equals(new Fare()));
    }

    @Test
    public void testEquals4() {
        Fare fare = new Fare(10, 0, 10.0);

        Fare fare1 = new Fare();
        fare1.setBookingfare(10.0);
        fare1.setBookingid(1);
        fare1.setFarenum(10);
        assertFalse(fare.equals(fare1));
    }

    @Test
    public void testEquals5() {
        Fare fare = new Fare(10, 1, 0.5);

        Fare fare1 = new Fare();
        fare1.setBookingfare(10.0);
        fare1.setBookingid(1);
        fare1.setFarenum(10);
        assertFalse(fare.equals(fare1));
    }

    @Test
    public void testHashCode() {
        assertEquals(1076341368, (new Fare(10, 1, 10.0)).hashCode());
    }

    @Test
    public void testSetBookingfare() {
        Fare fare = new Fare(10, 1, 10.0);
        fare.setBookingfare(10.0);
        assertEquals(10.0, fare.getBookingfare());
    }

    @Test
    public void testSetBookingid() {
        Fare fare = new Fare(10, 1, 10.0);
        fare.setBookingid(1);
        assertEquals(1, fare.getBookingid());
    }

    @Test
    public void testSetFarenum() {
        Fare fare = new Fare(10, 1, 10.0);
        fare.setFarenum(10);
        assertEquals(10, fare.getFarenum());
    }
}

