package com.example.demo.controller;

import com.example.demo.config.RabbitMQConfig;
import com.example.demo.model.Review;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/review")
public class ReviewController  {

    final static String queueName = "message_queue";

    @PostMapping("/post")
    private Review getpost(@RequestBody Review review)
    {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(RabbitMQConfig.class);
        RabbitTemplate rabbitTemplate = (RabbitTemplate) ctx.getBean("rabbitTemplate");
        review.setExperience(review.getExperience());
        review.setUsername(review.getUsername());
        review.setFeedback(review.getFeedback());
        rabbitTemplate.convertAndSend(queueName, review);
        System.out.println("product object has been sent successfully to Queue");
//        ctx.close();
        return review;
    }

}
