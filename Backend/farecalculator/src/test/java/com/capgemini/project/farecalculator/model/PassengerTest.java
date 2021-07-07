package com.capgemini.project.farecalculator.model;

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
        Passenger passenger = new Passenger();

        Passenger passenger1 = new Passenger();
        passenger1.setLastName("Doe");
        assertFalse(passenger.equals(passenger1));
    }

    @Test
    public void testEquals11() {
        Passenger passenger = new Passenger();

        Passenger passenger1 = new Passenger();
        passenger1.setFirstName("Jane");
        assertFalse(passenger.equals(passenger1));
    }

    @Test
    public void testEquals12() {
        Passenger passenger = new Passenger("42", "Jane", "42", "Doe", 1, "Gender", "Seat No");
        assertFalse(passenger.equals(new Passenger("42", "Jane", "Middle Name", "Doe", 1, "Gender", "Seat No")));
    }

    @Test
    public void testEquals13() {
        Passenger passenger = new Passenger("42", "Jane", null, "Doe", 1, "Gender", "Seat No");
        assertFalse(passenger.equals(new Passenger("42", "Jane", "Middle Name", "Doe", 1, "Gender", "Seat No")));
    }

    @Test
    public void testEquals14() {
        Passenger passenger = new Passenger("42", "Jane", "Middle Name", "Doe", 1, "42", "Seat No");
        assertFalse(passenger.equals(new Passenger("42", "Jane", "Middle Name", "Doe", 1, "Gender", "Seat No")));
    }

    @Test
    public void testEquals15() {
        Passenger passenger = new Passenger("42", "Jane", "Middle Name", "Doe", 1, null, "Seat No");
        assertFalse(passenger.equals(new Passenger("42", "Jane", "Middle Name", "Doe", 1, "Gender", "Seat No")));
    }

    @Test
    public void testEquals16() {
        Passenger passenger = new Passenger("42", "Jane", "Middle Name", "Doe", 1, "Gender", "42");
        assertFalse(passenger.equals(new Passenger("42", "Jane", "Middle Name", "Doe", 1, "Gender", "Seat No")));
    }

    @Test
    public void testEquals17() {
        Passenger passenger = new Passenger("42", "Jane", "Middle Name", "Doe", 1, "Gender", null);
        assertFalse(passenger.equals(new Passenger("42", "Jane", "Middle Name", "Doe", 1, "Gender", "Seat No")));
    }

    @Test
    public void testEquals2() {
        Passenger passenger = new Passenger();
        assertTrue(passenger.equals(new Passenger()));
    }

    @Test
    public void testEquals3() {
        Passenger passenger = new Passenger();
        assertFalse(passenger.equals(new Passenger("42", "Jane", "Middle Name", "Doe", 1, "Gender", "Seat No")));
    }

    @Test
    public void testEquals4() {
        Passenger passenger = new Passenger("42", "Jane", "Middle Name", "Doe", 1, "Gender", "Seat No");
        assertFalse(passenger.equals(new Passenger()));
    }

    @Test
    public void testEquals5() {
        Passenger passenger = new Passenger("42", "Jane", "Middle Name", "Doe", 1, "Gender", "Seat No");
        assertTrue(passenger.equals(new Passenger("42", "Jane", "Middle Name", "Doe", 1, "Gender", "Seat No")));
    }

    @Test
    public void testEquals6() {
        Passenger passenger = new Passenger();
        assertFalse(passenger.equals(new Passenger("42", "Jane", "Middle Name", "Doe", null, "Gender", "Seat No")));
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
        passenger.setId("42");
        assertFalse(passenger.equals(new Passenger()));
    }

    @Test
    public void testEquals9() {
        Passenger passenger = new Passenger();
        passenger.setFirstName("Jane");
        assertFalse(passenger.equals(new Passenger()));
    }

    @Test
    public void testHashCode() {
        assertEquals(64204658, (new Passenger()).hashCode());
        assertEquals(-313664201, (new Passenger("42", "Jane", "Middle Name", "Doe", 1, "Gender", "Seat No")).hashCode());
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
    public void testSetId() {
        Passenger passenger = new Passenger();
        passenger.setId("42");
        assertEquals("42", passenger.getId());
    }

    @Test
    public void testSetLastName() {
        Passenger passenger = new Passenger();
        passenger.setLastName("Doe");
        assertEquals("Doe", passenger.getLastName());
    }

    @Test
    public void testSetMiddleName() {
        Passenger passenger = new Passenger();
        passenger.setMiddleName("Middle Name");
        assertEquals("Middle Name", passenger.getMiddleName());
    }

    @Test
    public void testSetSeatNo() {
        Passenger passenger = new Passenger();
        passenger.setSeatNo("Seat No");
        assertEquals("Seat No", passenger.getSeatNo());
    }
}

