package com.example.demo;

import com.example.demo.config.RabbitMQConfig;
import com.example.demo.receiver.MessageReceiver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableDiscoveryClient

public class DemoApplication {

	public static void main(String[] args) throws InterruptedException
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(RabbitMQConfig.class);
		MessageReceiver receiver = (MessageReceiver) ctx.getBean("receiver");
		receiver.getCountDownLatch().await(200000, TimeUnit.SECONDS);
		SpringApplication.run(DemoApplication.class, args);
	}

}
