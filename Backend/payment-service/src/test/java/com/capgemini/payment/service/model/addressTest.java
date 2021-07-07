package com.capgemini.payment.service.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class addressTest {
    @Test
    public void testSetCountry_code() {
        address address = new address();
        address.setCountry_code("Country code");
        assertEquals("Country code", address.getCountry_code());
    }
}

