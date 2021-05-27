package com.capgemini.payment.service.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

public class payerTest {
    @Test
    public void testSetEmail_address() {
        payer payer = new payer();
        payer.setEmail_address("42 Main St");
        assertEquals("42 Main St", payer.getEmail_address());
    }

    @Test
    public void testSetAddress() {
        payer payer = new payer();
        address address = new address();
        payer.setAddress(address);
        assertSame(address, payer.getAddress());
    }
}

