package com.Capgemini.Project.userandadminoperations.controller;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doNothing;

import com.Capgemini.Project.userandadminoperations.service.FlightsService;
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

@ContextConfiguration(classes = {FlightsController.class})
@ExtendWith(SpringExtension.class)
public class FlightsControllerTest {
    @Autowired
    private FlightsController flightsController;

    @MockBean
    private FlightsService flightsService;

    @Test
    public void testDeleteFlight() throws Exception {
        doNothing().when(this.flightsService).delete(anyString());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/admin/flights/{flightId}", "42");
        MockMvcBuilders.standaloneSetup(this.flightsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Successfully deleted with id 42")));
    }

    @Test
    public void testDeleteFlight2() throws Exception {
        doNothing().when(this.flightsService).delete(anyString());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/admin/flights/{flightId}", "42");
        MockMvcBuilders.standaloneSetup(this.flightsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Successfully deleted with id 42")));
    }
}

