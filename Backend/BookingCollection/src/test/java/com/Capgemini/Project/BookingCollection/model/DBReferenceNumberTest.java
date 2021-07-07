package com.Capgemini.Project.BookingCollection.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DBReferenceNumberTest {
    @Test
    public void testCanEqual() {
        assertFalse((new DBReferenceNumber("Bookingid", 1)).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        DBReferenceNumber dbReferenceNumber = new DBReferenceNumber("Bookingid", 1);

        DBReferenceNumber dbReferenceNumber1 = new DBReferenceNumber();
        dbReferenceNumber1.setBookingid("Bookingid");
        dbReferenceNumber1.setRefNo(0);
        assertTrue(dbReferenceNumber.canEqual(dbReferenceNumber1));
    }

    @Test
    public void testEquals() {
        assertFalse((new DBReferenceNumber("Bookingid", 1)).equals("42"));
    }

    @Test
    public void testEquals2() {
        DBReferenceNumber dbReferenceNumber = new DBReferenceNumber("Bookingid", 1);

        DBReferenceNumber dbReferenceNumber1 = new DBReferenceNumber();
        dbReferenceNumber1.setBookingid("Bookingid");
        dbReferenceNumber1.setRefNo(0);
        assertFalse(dbReferenceNumber.equals(dbReferenceNumber1));
    }

    @Test
    public void testEquals3() {
        DBReferenceNumber dbReferenceNumber = new DBReferenceNumber("Bookingid", 1);
        assertTrue(dbReferenceNumber.equals(new DBReferenceNumber("Bookingid", 1)));
    }

    @Test
    public void testEquals4() {
        DBReferenceNumber dbReferenceNumber = new DBReferenceNumber(null, 1);
        assertFalse(dbReferenceNumber.equals(new DBReferenceNumber("Bookingid", 1)));
    }

    @Test
    public void testEquals5() {
        DBReferenceNumber dbReferenceNumber = new DBReferenceNumber(
                "com.Capgemini.Project.BookingCollection.model.DBReferenceNumber", 1);
        assertFalse(dbReferenceNumber.equals(new DBReferenceNumber("Bookingid", 1)));
    }

    @Test
    public void testEquals6() {
        DBReferenceNumber dbReferenceNumber = new DBReferenceNumber(null, 1);
        assertTrue(dbReferenceNumber.equals(new DBReferenceNumber(null, 1)));
    }

    @Test
    public void testHashCode() {
        assertEquals(-257126168, (new DBReferenceNumber("Bookingid", 1)).hashCode());
        assertEquals(3583, (new DBReferenceNumber(null, 1)).hashCode());
    }

    @Test
    public void testSetBookingid() {
        DBReferenceNumber dbReferenceNumber = new DBReferenceNumber("Bookingid", 1);
        dbReferenceNumber.setBookingid("Bookingid");
        assertEquals("Bookingid", dbReferenceNumber.getBookingid());
    }

    @Test
    public void testSetRefNo() {
        DBReferenceNumber dbReferenceNumber = new DBReferenceNumber("Bookingid", 1);
        dbReferenceNumber.setRefNo(1);
        assertEquals(1, dbReferenceNumber.getRefNo());
    }
}

