package com.capgemini.payment.service.model;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

public class purchase_unitsTest {
    @Test
    public void testSetAmount() {
        purchase_units purchase_units = new purchase_units();
        amount amount = new amount();
        purchase_units.setAmount(amount);
        assertSame(amount, purchase_units.getAmount());
    }
}

