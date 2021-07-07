package com.capgemini.ticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fare {
    @Id
    private int farenum;
    private String bookingid;
    private double bookingfare;
}
