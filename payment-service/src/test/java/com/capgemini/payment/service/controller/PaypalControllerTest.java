package com.capgemini.payment.service.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.capgemini.payment.service.model.Order;
import com.capgemini.payment.service.model.payer;
import com.capgemini.payment.service.model.purchase_units;
import com.capgemini.payment.service.service.PaypalService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {PaypalController.class})
@ExtendWith(SpringExtension.class)
public class PaypalControllerTest {
    @Autowired
    private PaypalController paypalController;

    @MockBean
    private PaypalService paypalService;

    @Test
    public void testSaveFlightDetails() throws Exception {
        Order order = new Order();
        order.setStatus("Status");
        order.setPayer(new payer());
        order.setIntent("Intent");
        order.setId("42");
        order.setPurchase_units(new ArrayList<purchase_units>());
        order.setDescription("The characteristics of someone or something");
        when(this.paypalService.saveOrUpdate((Order) any())).thenReturn(order);

        Order order1 = new Order();
        order1.setStatus("Status");
        order1.setPayer(new payer());
        order1.setIntent("Intent");
        order1.setId("42");
        order1.setPurchase_units(new ArrayList<purchase_units>());
        order1.setDescription("The characteristics of someone or something");
        String content = (new ObjectMapper()).writeValueAsString(order1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/pay/paypal")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.paypalController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Successfully Saved with Details ")));
    }
}

