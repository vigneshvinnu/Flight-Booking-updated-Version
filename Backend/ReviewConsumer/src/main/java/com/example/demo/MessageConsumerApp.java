package com.example.demo;

import java.util.concurrent.TimeUnit;

import com.example.demo.config.RabbitMQConfig;
import com.example.demo.model.Review;
import com.example.demo.receiver.MessageReceiver;
import com.example.demo.service.ReviewService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MessageConsumerApp
{
	final static String queueName = "message_queue";

	public static void main(String[] args) throws InterruptedException
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(RabbitMQConfig.class);
		MessageReceiver receiver = (MessageReceiver) ctx.getBean("receiver");
		receiver.getCountDownLatch().await(200000, TimeUnit.SECONDS);
		SpringApplication.run(MessageConsumerApp.class, args);


	}

//	@Bean
//	ReviewService reviewService;
}