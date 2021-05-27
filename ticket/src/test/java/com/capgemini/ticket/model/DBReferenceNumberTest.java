package com.capgemini.ticket.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DBReferenceNumberTest {
    @Test
    public void testCanEqual() {
        assertFalse((new DBReferenceNumber("42", 1)).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        DBReferenceNumber dbReferenceNumber = new DBReferenceNumber("42", 1);

        DBReferenceNumber dbReferenceNumber1 = new DBReferenceNumber();
        dbReferenceNumber1.setTicketId("42");
        dbReferenceNumber1.setRefNo(0);
        assertTrue(dbReferenceNumber.canEqual(dbReferenceNumber1));
    }

    @Test
    public void testEquals() {
        assertFalse((new DBReferenceNumber("42", 1)).equals("42"));
    }

    @Test
    public void testEquals2() {
        DBReferenceNumber dbReferenceNumber = new DBReferenceNumber("42", 1);

        DBReferenceNumber dbReferenceNumber1 = new DBReferenceNumber();
        dbReferenceNumber1.setTicketId("42");
        dbReferenceNumber1.setRefNo(0);
        assertFalse(dbReferenceNumber.equals(dbReferenceNumber1));
    }

    @Test
    public void testEquals3() {
        DBReferenceNumber dbReferenceNumber = new DBReferenceNumber("42", 1);
        assertTrue(dbReferenceNumber.equals(new DBReferenceNumber("42", 1)));
    }

    @Test
    public void testEquals4() {
        DBReferenceNumber dbReferenceNumber = new DBReferenceNumber(null, 1);
        assertFalse(dbReferenceNumber.equals(new DBReferenceNumber("42", 1)));
    }

    @Test
    public void testEquals5() {
        DBReferenceNumber dbReferenceNumber = new DBReferenceNumber("Ticket Id", 1);
        assertFalse(dbReferenceNumber.equals(new DBReferenceNumber("42", 1)));
    }

    @Test
    public void testEquals6() {
        DBReferenceNumber dbReferenceNumber = new DBReferenceNumber(null, 1);
        assertTrue(dbReferenceNumber.equals(new DBReferenceNumber(null, 1)));
    }

    @Test
    public void testHashCode() {
        assertEquals(5202, (new DBReferenceNumber("42", 1)).hashCode());
        assertEquals(3583, (new DBReferenceNumber(null, 1)).hashCode());
    }

    @Test
    public void testSetRefNo() {
        DBReferenceNumber dbReferenceNumber = new DBReferenceNumber("42", 1);
        dbReferenceNumber.setRefNo(1);
        assertEquals(1, dbReferenceNumber.getRefNo());
    }

    @Test
    public void testSetTicketId() {
        DBReferenceNumber dbReferenceNumber = new DBReferenceNumber("42", 1);
        dbReferenceNumber.setTicketId("42");
        assertEquals("42", dbReferenceNumber.getTicketId());
    }
}

