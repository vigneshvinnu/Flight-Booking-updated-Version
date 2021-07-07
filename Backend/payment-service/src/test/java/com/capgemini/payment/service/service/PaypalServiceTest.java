package com.capgemini.payment.service.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.capgemini.payment.service.model.Order;
import com.capgemini.payment.service.model.payer;
import com.capgemini.payment.service.model.purchase_units;
import com.capgemini.payment.service.repository.PaymentRepository;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PaypalService.class})
@ExtendWith(SpringExtension.class)
public class PaypalServiceTest {
    @MockBean
    private PaymentRepository paymentRepository;

    @Autowired
    private PaypalService paypalService;

    @Test
    public void testSaveOrUpdate() {
        Order order = new Order();
        order.setStatus("Status");
        order.setPayer(new payer());
        order.setIntent("Intent");
        order.setId("42");
        order.setPurchase_units(new ArrayList<purchase_units>());
        order.setDescription("The characteristics of someone or something");
        when(this.paymentRepository.save((Order) any())).thenReturn(order);
        assertSame(order, this.paypalService.saveOrUpdate(new Order()));
        verify(this.paymentRepository).save((Order) any());
    }
}

