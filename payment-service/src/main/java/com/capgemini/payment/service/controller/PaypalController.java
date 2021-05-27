package com.capgemini.payment.service.controller;

import com.capgemini.payment.service.model.Order;
import com.capgemini.payment.service.service.PaypalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pay")
@CrossOrigin(origins = "*")
public class PaypalController {

    @Autowired
    PaypalService service;

    @PostMapping("/paypal")
    public ResponseEntity<?> saveFlightDetails(@RequestBody Order order)
    {
        service.saveOrUpdate(order);
        return new ResponseEntity<>("Successfully Saved with Details ", HttpStatus.OK);
    }
}
