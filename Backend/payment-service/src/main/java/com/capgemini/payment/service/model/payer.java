package com.capgemini.payment.service.model;

public class payer {
    private String email_address;
    private address address;

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public com.capgemini.payment.service.model.address getAddress() {
        return address;
    }

    public void setAddress(com.capgemini.payment.service.model.address address) {
        this.address = address;
    }
}
