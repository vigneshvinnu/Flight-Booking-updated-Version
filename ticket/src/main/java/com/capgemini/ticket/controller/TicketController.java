package com.capgemini.ticket.controller;

import com.capgemini.ticket.model.Ticket;
import com.capgemini.ticket.service.TicketService;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ticket")
public class TicketController {



    @Autowired
    TicketService ticketService;

    @GetMapping("/ticket")
    public Object getTicketEstimator(Ticket ticket)
    {
        return ticketService.getTicket(ticket);
    }

    @GetMapping( value = "/generate/pdf.htm/{ticketId}",produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> TicketReport(@PathVariable("ticketId") int ticketId) throws IOException {
        Ticket ticket1= (Ticket) ticketService.pdf(ticketId);

        ByteArrayInputStream bis = GeneratePdfReport.pdfReport(ticket1);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=Ticket.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}
