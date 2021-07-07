package com.example.demo.service;

import com.example.demo.model.Review;
import com.example.demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    public Review post(@RequestBody Review review)
    {
        return reviewRepository.save(review);
    }
}

