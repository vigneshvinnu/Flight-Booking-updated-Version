package com.capgemini.project.farecalculator.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import com.capgemini.project.farecalculator.model.Fare;
import com.capgemini.project.farecalculator.service.Fareservice;

import java.util.ArrayList;
import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {farecontroller.class})
@ExtendWith(SpringExtension.class)
public class farecontrollerTest {
    @Autowired
    private farecontroller farecontroller;

    @MockBean
    private Fareservice fareservice;

    @Test
    public void testGetAllFares() throws Exception {
        when(this.fareservice.getAll()).thenReturn(new ArrayList<Fare>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/fare/fares");
        MockMvcBuilders.standaloneSetup(this.farecontroller)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testGetFare() throws Exception {
        Fare fare = new Fare();
        fare.setBookingfare(10.0);
        fare.setBookingid(1);
        fare.setFarenum(10);
        Optional<Fare> ofResult = Optional.<Fare>of(fare);
        when(this.fareservice.getByFarenum(anyInt())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/fare/fare/{farenum}", 123456789);
        MockMvcBuilders.standaloneSetup(this.farecontroller)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString("{\"farenum\":10,\"bookingid\":1,\"bookingfare\":10.0}")));
    }

    @Test
    public void testGetFareEstimator() throws Exception {
        when(this.fareservice.saveOrUpdate((com.capgemini.project.farecalculator.model.Fare) any())).thenReturn("42");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/fare/fare");
        MockMvcBuilders.standaloneSetup(this.farecontroller)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("42")));
    }

    @Test
    public void testGetFareEstimator2() throws Exception {
        when(this.fareservice.saveOrUpdate((com.capgemini.project.farecalculator.model.Fare) any())).thenReturn("42");
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/fare/fare");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.farecontroller)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("42")));
    }
}

