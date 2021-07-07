package com.capgemini.payment.service.repository;

import com.capgemini.payment.service.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends MongoRepository<Order,String> {



}
