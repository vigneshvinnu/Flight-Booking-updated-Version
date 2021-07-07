package com.capgemini.project.review.service;


import com.capgemini.project.review.model.Review;
import com.capgemini.project.review.repository.ReviewRepository;
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
