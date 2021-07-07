package com.Capgemini.Project.BookingCollection.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PassengerTest {
    @Test
    public void testCanEqual() {
        assertFalse((new Passenger()).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        Passenger passenger = new Passenger();
        assertTrue(passenger.canEqual(new Passenger()));
    }

    @Test
    public void testEquals() {
        assertFalse((new Passenger()).equals("42"));
    }

    @Test
    public void testEquals10() {
        Passenger passenger = new Passenger("Jane", "Doe", 1, "Jane");
        assertFalse(passenger.equals(new Passenger("Jane", "Doe", 1, "Gender")));
    }

    @Test
    public void testEquals11() {
        Passenger passenger = new Passenger("Jane", "Doe", 1, null);
        assertFalse(passenger.equals(new Passenger("Jane", "Doe", 1, "Gender")));
    }

    @Test
    public void testEquals2() {
        Passenger passenger = new Passenger();
        assertTrue(passenger.equals(new Passenger()));
    }

    @Test
    public void testEquals3() {
        Passenger passenger = new Passenger();
        assertFalse(passenger.equals(new Passenger("Jane", "Doe", 1, "Gender")));
    }

    @Test
    public void testEquals4() {
        Passenger passenger = new Passenger("Jane", "Doe", 1, "Gender");
        assertFalse(passenger.equals(new Passenger()));
    }

    @Test
    public void testEquals5() {
        Passenger passenger = new Passenger("Jane", "Doe", 1, "Gender");
        assertTrue(passenger.equals(new Passenger("Jane", "Doe", 1, "Gender")));
    }

    @Test
    public void testEquals6() {
        Passenger passenger = new Passenger();
        assertFalse(passenger.equals(new Passenger("Jane", "Doe", null, "Gender")));
    }

    @Test
    public void testEquals7() {
        Passenger passenger = new Passenger();
        passenger.setLastName("Doe");
        assertFalse(passenger.equals(new Passenger()));
    }

    @Test
    public void testEquals8() {
        Passenger passenger = new Passenger();
        passenger.setFirstName("Jane");
        assertFalse(passenger.equals(new Passenger()));
    }

    @Test
    public void testEquals9() {
        Passenger passenger = new Passenger();

        Passenger passenger1 = new Passenger();
        passenger1.setLastName("Doe");
        assertFalse(passenger.equals(passenger1));
    }

    @Test
    public void testHashCode() {
        assertEquals(21100921, (new Passenger()).hashCode());
        assertEquals(1566467377, (new Passenger("Jane", "Doe", 1, "Gender")).hashCode());
    }

    @Test
    public void testSetAge() {
        Passenger passenger = new Passenger();
        passenger.setAge(1);
        assertEquals(1, passenger.getAge().intValue());
    }

    @Test
    public void testSetFirstName() {
        Passenger passenger = new Passenger();
        passenger.setFirstName("Jane");
        assertEquals("Jane", passenger.getFirstName());
    }

    @Test
    public void testSetGender() {
        Passenger passenger = new Passenger();
        passenger.setGender("Gender");
        assertEquals("Gender", passenger.getGender());
    }

    @Test
    public void testSetLastName() {
        Passenger passenger = new Passenger();
        passenger.setLastName("Doe");
        assertEquals("Doe", passenger.getLastName());
    }
}

