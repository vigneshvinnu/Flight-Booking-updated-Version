package com.capgemini.payment.service;


import com.capgemini.payment.service.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PaymentControllerTests {


    @Autowired
    private PaymentRepository paymentRepository;

    @Test
    void contextLoads()
    {

    }

   /* @Test
    public void testFindByRefereceNumber()
    {
        int referenceNumber=41;
       List<Payment> payment= paymentRepository.findByReferenceNumber(referenceNumber);
       System.out.println(payment.get(referenceNumber));
        assertEquals(payment,referenceNumber);
    }*/

   /* @Test
    public void testNotFindByRefereceNumber()
    {
        int referenceNumber=142;
        List<Payment> payment=  paymentRepository.findByReferenceNumber(referenceNumber);
        System.out.println(payment.getReferenceNumber());
        assertNotEquals(payment.getReferenceNumber(),referenceNumber);
    }*/

}
