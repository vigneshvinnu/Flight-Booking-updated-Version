package com.capgemini.ticket.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.capgemini.ticket.model.Passenger;
import com.capgemini.ticket.model.Ticket;
import com.capgemini.ticket.service.TicketService;

import java.util.ArrayList;

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

@ContextConfiguration(classes = {TicketController.class})
@ExtendWith(SpringExtension.class)
public class TicketControllerTest {
    @Autowired
    private TicketController ticketController;

    @MockBean
    private TicketService ticketService;

    @Test
    public void testGeneratePdf() throws Exception {
        Ticket ticket = new Ticket();
        ticket.setTicketId(123);
        ticket.setArrivalDate("2020-03-01");
        ticket.setDepartureDate("2020-03-01");
        ticket.setFlightTakeOffStation("?");
        ticket.setDepartureTime("?");
        ticket.setPassengerList(new ArrayList<Passenger>());
        ticket.setFlightId("42");
        ticket.setFlightLandingStation("?");
        ticket.setTicketAmount(10.0);
        ticket.setFarenum(10);
        ticket.setArrivalTime("?");
        ticket.setPrice(0);
        when(this.ticketService.getTicket((Ticket) any())).thenReturn(ticket);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/ticket/generate/pdf.htm");
        MockMvcBuilders.standaloneSetup(this.ticketController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(2))
                .andExpect(MockMvcResultMatchers.model().attributeExists("command", "ticket"))
                .andExpect(MockMvcResultMatchers.view().name("pdfView"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("pdfView"));
    }

    @Test
    public void testGetTicketEstimator() throws Exception {
        when(this.ticketService.getTicket((com.capgemini.ticket.model.Ticket) any())).thenReturn("42");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/ticket/ticket");
        MockMvcBuilders.standaloneSetup(this.ticketController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("42")));
    }

    @Test
    public void testGetTicketEstimator2() throws Exception {
        when(this.ticketService.getTicket((com.capgemini.ticket.model.Ticket) any())).thenReturn("42");
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/ticket/ticket");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.ticketController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("42")));
    }
}

