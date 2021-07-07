package com.capgemini.payment.service.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class amountTest {
    @Test
    public void testSetValue() {
        amount amount = new amount();
        amount.setValue(10.0);
        assertEquals(10.0, amount.getValue());
    }
}

