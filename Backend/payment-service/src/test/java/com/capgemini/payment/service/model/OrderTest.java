package com.capgemini.payment.service.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class OrderTest {
    @Test
    public void testCanEqual() {
        assertFalse((new Order()).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        Order order = new Order();

        Order order1 = new Order();
        order1.setStatus("Status");
        order1.setPayer(new payer());
        order1.setIntent("Intent");
        order1.setId("42");
        order1.setPurchase_units(new ArrayList<purchase_units>());
        order1.setDescription("The characteristics of someone or something");
        assertTrue(order.canEqual(order1));
    }

    @Test
    public void testEquals() {
        assertFalse((new Order()).equals("42"));
    }

    @Test
    public void testEquals10() {
        Order order = new Order();

        Order order1 = new Order();
        order1.setDescription("The characteristics of someone or something");
        assertFalse(order.equals(order1));
    }

    @Test
    public void testEquals11() {
        Order order = new Order("42", "Intent", null, new ArrayList<purchase_units>(),
                "The characteristics of someone or something", "Status");

        Order order1 = new Order();
        order1.setStatus("Status");
        order1.setPayer(null);
        order1.setIntent("Intent");
        order1.setId("42");
        order1.setPurchase_units(new ArrayList<purchase_units>());
        order1.setDescription("The characteristics of someone or something");
        assertTrue(order.equals(order1));
    }

    @Test
    public void testEquals12() {
        ArrayList<purchase_units> purchase_unitsList = new ArrayList<purchase_units>();
        purchase_unitsList.add(new purchase_units());
        Order order = new Order("42", "Intent", null, purchase_unitsList, "The characteristics of someone or something",
                "Status");

        Order order1 = new Order();
        order1.setStatus("Status");
        order1.setPayer(null);
        order1.setIntent("Intent");
        order1.setId("42");
        order1.setPurchase_units(new ArrayList<purchase_units>());
        order1.setDescription("The characteristics of someone or something");
        assertFalse(order.equals(order1));
    }

    @Test
    public void testEquals13() {
        Order order = new Order("42", "Intent", null, new ArrayList<purchase_units>(),
                "The characteristics of someone or something", "42");

        Order order1 = new Order();
        order1.setStatus("Status");
        order1.setPayer(null);
        order1.setIntent("Intent");
        order1.setId("42");
        order1.setPurchase_units(new ArrayList<purchase_units>());
        order1.setDescription("The characteristics of someone or something");
        assertFalse(order.equals(order1));
    }

    @Test
    public void testEquals14() {
        Order order = new Order("42", "Intent", null, new ArrayList<purchase_units>(),
                "The characteristics of someone or something", null);

        Order order1 = new Order();
        order1.setStatus("Status");
        order1.setPayer(null);
        order1.setIntent("Intent");
        order1.setId("42");
        order1.setPurchase_units(new ArrayList<purchase_units>());
        order1.setDescription("The characteristics of someone or something");
        assertFalse(order.equals(order1));
    }

    @Test
    public void testEquals15() {
        Order order = new Order("42", "Intent", null, new ArrayList<purchase_units>(),
                "The characteristics of someone or something", "Status");
        order.setPurchase_units(null);

        Order order1 = new Order();
        order1.setStatus("Status");
        order1.setPayer(null);
        order1.setIntent("Intent");
        order1.setId("42");
        order1.setPurchase_units(new ArrayList<purchase_units>());
        order1.setDescription("The characteristics of someone or something");
        assertFalse(order.equals(order1));
    }

    @Test
    public void testEquals2() {
        Order order = new Order();

        Order order1 = new Order();
        order1.setStatus("Status");
        order1.setPayer(new payer());
        order1.setIntent("Intent");
        order1.setId("42");
        order1.setPurchase_units(new ArrayList<purchase_units>());
        order1.setDescription("The characteristics of someone or something");
        assertFalse(order.equals(order1));
    }

    @Test
    public void testEquals3() {
        Order order = new Order();
        assertTrue(order.equals(new Order()));
    }

    @Test
    public void testEquals4() {
        payer payer = new payer();
        Order order = new Order("42", "Intent", payer, new ArrayList<purchase_units>(),
                "The characteristics of someone or something", "Status");

        Order order1 = new Order();
        order1.setStatus("Status");
        order1.setPayer(new payer());
        order1.setIntent("Intent");
        order1.setId("42");
        order1.setPurchase_units(new ArrayList<purchase_units>());
        order1.setDescription("The characteristics of someone or something");
        assertFalse(order.equals(order1));
    }

    @Test
    public void testEquals5() {
        Order order = new Order();

        Order order1 = new Order();
        order1.setStatus("Status");
        order1.setPayer(new payer());
        order1.setIntent("Intent");
        order1.setId(null);
        order1.setPurchase_units(new ArrayList<purchase_units>());
        order1.setDescription("The characteristics of someone or something");
        assertFalse(order.equals(order1));
    }

    @Test
    public void testEquals6() {
        payer payer = new payer();
        Order order = new Order("42", "Intent", payer, new ArrayList<purchase_units>(),
                "The characteristics of someone or something", "Status");
        assertFalse(order.equals(new Order()));
    }

    @Test
    public void testEquals7() {
        payer payer = new payer();
        Order order = new Order("42", "42", payer, new ArrayList<purchase_units>(),
                "The characteristics of someone or something", "Status");

        Order order1 = new Order();
        order1.setStatus("Status");
        order1.setPayer(new payer());
        order1.setIntent("Intent");
        order1.setId("42");
        order1.setPurchase_units(new ArrayList<purchase_units>());
        order1.setDescription("The characteristics of someone or something");
        assertFalse(order.equals(order1));
    }

    @Test
    public void testEquals8() {
        Order order = new Order("42", "Intent", null, new ArrayList<purchase_units>(),
                "The characteristics of someone or something", "Status");

        Order order1 = new Order();
        order1.setStatus("Status");
        order1.setPayer(new payer());
        order1.setIntent("Intent");
        order1.setId("42");
        order1.setPurchase_units(new ArrayList<purchase_units>());
        order1.setDescription("The characteristics of someone or something");
        assertFalse(order.equals(order1));
    }

    @Test
    public void testEquals9() {
        Order order = new Order();
        order.setDescription("The characteristics of someone or something");
        assertFalse(order.equals(new Order()));
    }

    @Test
    public void testHashCode() {
        assertEquals(437864549, (new Order()).hashCode());
    }

    @Test
    public void testHashCode2() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        payer payer = new payer();
        (new Order("42", "Intent", payer, new ArrayList<purchase_units>(), "The characteristics of someone or something",
                "Status")).hashCode();
    }

    @Test
    public void testSetDescription() {
        Order order = new Order();
        order.setDescription("The characteristics of someone or something");
        assertEquals("The characteristics of someone or something", order.getDescription());
    }

    @Test
    public void testSetId() {
        Order order = new Order();
        order.setId("42");
        assertEquals("42", order.getId());
    }

    @Test
    public void testSetIntent() {
        Order order = new Order();
        order.setIntent("Intent");
        assertEquals("Intent", order.getIntent());
    }

    @Test
    public void testSetPayer() {
        Order order = new Order();
        payer payer = new payer();
        order.setPayer(payer);
        assertSame(payer, order.getPayer());
    }

    @Test
    public void testSetPurchase_units() {
        Order order = new Order();
        order.setPurchase_units(new ArrayList<purchase_units>());
        assertEquals("Order(id=null, intent=null, payer=null, purchase_units=[], description=null, status=null)",
                order.toString());
    }

    @Test
    public void testSetStatus() {
        Order order = new Order();
        order.setStatus("Status");
        assertEquals("Status", order.getStatus());
    }
}

