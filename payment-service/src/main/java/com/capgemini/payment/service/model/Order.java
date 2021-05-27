package com.capgemini.payment.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Paypal")
public class Order {
    @Id
    private String id;
    private String intent;
    private payer payer;
    private List<purchase_units> purchase_units;
    private String description;
    private String status;

}