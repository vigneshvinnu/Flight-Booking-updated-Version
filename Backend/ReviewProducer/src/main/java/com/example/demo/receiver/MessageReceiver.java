package com.example.demo.receiver;

import com.example.demo.model.Review;

import java.util.concurrent.CountDownLatch;

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