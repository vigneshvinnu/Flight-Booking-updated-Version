package com.capgemini.payment.service.service;

import com.capgemini.payment.service.model.Order;
import com.capgemini.payment.service.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaypalService {    @Autowired private PaymentRepository repository;


    public Order saveOrUpdate(Order order)
    {
        System.out.println(order.getPurchase_units());
        return repository.save(order);

    }
}