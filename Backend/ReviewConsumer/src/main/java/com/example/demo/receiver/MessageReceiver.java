package com.example.demo.receiver;

import java.util.concurrent.CountDownLatch;
import com.example.demo.model.Review;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class MessageReceiver
{



    private CountDownLatch countDownLatch = new CountDownLatch(1);

    public void receiveMsg(Review review1) {
        System.out.println("product object is Received: " + review1);
        countDownLatch.countDown();
    }

    public CountDownLatch getCountDownLatch()
    {
        return countDownLatch;
    }
}