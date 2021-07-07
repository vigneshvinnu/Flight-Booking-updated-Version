package com.capgemini.project.farecalculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class BookingTest {
    @Test
    public void testCanEqual() {
        assertFalse((new Booking()).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        Booking booking = new Booking();
        assertTrue(booking.canEqual(new Booking()));
    }

    @Test
    public void testEquals() {
        assertFalse((new Booking()).equals("42"));
    }

    @Test
    public void testEquals10() {
        Booking booking = new Booking(1, new ArrayList<Passenger>(), "42", "42", 10.0);
        assertFalse(booking.equals(new Booking(1, new ArrayList<Passenger>(), "Userid", "42", 10.0)));
    }

    @Test
    public void testEquals11() {
        Booking booking = new Booking(1, new ArrayList<Passenger>(), "Userid", "42", 10.0);
        booking.setPassengerNames(null);
        assertFalse(booking.equals(new Booking(1, new ArrayList<Passenger>(), "Userid", "42", 10.0)));
    }

    @Test
    public void testEquals2() {
        Booking booking = new Booking();
        assertTrue(booking.equals(new Booking()));
    }

    @Test
    public void testEquals3() {
        Booking booking = new Booking();
        assertFalse(booking.equals(new Booking(1, new ArrayList<Passenger>(), "Userid", "42", 10.0)));
    }

    @Test
    public void testEquals4() {
        Booking booking = new Booking(1, new ArrayList<Passenger>(), "Userid", "42", 10.0);
        assertTrue(booking.equals(new Booking(1, new ArrayList<Passenger>(), "Userid", "42", 10.0)));
    }

    @Test
    public void testEquals5() {
        Booking booking = new Booking();
        assertFalse(booking.equals(new Booking(0, new ArrayList<Passenger>(), "Userid", "42", 10.0)));
    }

    @Test
    public void testEquals6() {
        Booking booking = new Booking();
        booking.setFlightId("42");
        assertFalse(booking.equals(new Booking()));
    }

    @Test
    public void testEquals7() {
        Booking booking = new Booking();

        Booking booking1 = new Booking();
        booking1.setFlightId("42");
        assertFalse(booking.equals(booking1));
    }

    @Test
    public void testEquals8() {
        ArrayList<Passenger> passengerList = new ArrayList<Passenger>();
        passengerList.add(new Passenger());
        Booking booking = new Booking(1, passengerList, "Userid", "42", 10.0);
        assertFalse(booking.equals(new Booking(1, new ArrayList<Passenger>(), "Userid", "42", 10.0)));
    }

    @Test
    public void testEquals9() {
        Booking booking = new Booking(1, new ArrayList<Passenger>(), null, "42", 10.0);
        assertFalse(booking.equals(new Booking(1, new ArrayList<Passenger>(), "Userid", "42", 10.0)));
    }

    @Test
    public void testHashCode() {
        assertEquals(715076562, (new Booking()).hashCode());
        assertEquals(-1426533195, (new Booking(1, new ArrayList<Passenger>(), "Userid", "42", 10.0)).hashCode());
    }

    @Test
    public void testSetBookingAmount() {
        Booking booking = new Booking();
        booking.setBookingAmount(10.0);
        assertEquals(10.0, booking.getBookingAmount());
    }

    @Test
    public void testSetBookingid() {
        Booking booking = new Booking();
        booking.setBookingid(1);
        assertEquals(1, booking.getBookingid());
    }

    @Test
    public void testSetFlightId() {
        Booking booking = new Booking();
        booking.setFlightId("42");
        assertEquals("42", booking.getFlightId());
    }

    @Test
    public void testSetPassengerNames() {
        Booking booking = new Booking();
        booking.setPassengerNames(new ArrayList<Passenger>());
        assertEquals("Booking(bookingid=0, passengerNames=[], userid=null, flightId=null, bookingAmount=0.0)",
                booking.toString());
    }

    @Test
    public void testSetUserid() {
        Booking booking = new Booking();
        booking.setUserid("Userid");
        assertEquals("Userid", booking.getUserid());
    }
}

