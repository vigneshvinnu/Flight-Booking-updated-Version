package com.capgemini.gateway;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
public class FallbackController {

    @RequestMapping("/adminFallBack")
    public Mono<String> adminServiceFallBack(){
        return Mono.just("Admin operations is taking too long to respond or server is down,Please try again");
    }

    @RequestMapping("/userFallBack")
    public Mono<String> userServiceFallBack(){
        return Mono.just("User operations is taking too long to respond or server is down,Please try again");
    }

    @RequestMapping("/bookingFallBack")
    public Mono<String> bookingServiceFallBack(){
        return Mono.just("Booking is taking too long to respond or server is down,Please try again");
    }

    @RequestMapping("/fareFallBack")
    public Mono<String> fareServiceFallBack() {
        return Mono.just("Fare calculator is taking too long to respond or server is down,Please try again");
    }

    @RequestMapping("/paymentFallBack")
    public Mono<String> paymentServiceFallBack(){
        return Mono.just("Payment Service is taking too long to respond or server is down,please try again");
    }

    @RequestMapping("/ticketFallBack")
    public Mono<String> ticketServiceFallBack(){
        return Mono.just("Ticket Service is taking too long to respond or server is down,please try again");
    }

    @RequestMapping("/securityFallBack")
    public Mono<String> securityServiceFallBack(){
        return Mono.just("Security Service is taking too long to respond or server is down,please try again");
    }

    @RequestMapping("/reviewFallBack")
    public Mono<String> reviewServiceFallBack(){
        return Mono.just("Review Service is taking too long to respond or server is down,please try again");
    }
}
