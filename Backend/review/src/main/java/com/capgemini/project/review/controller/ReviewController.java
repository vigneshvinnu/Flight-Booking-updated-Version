package com.capgemini.project.review.controller;


import com.capgemini.project.review.model.Review;
import com.capgemini.project.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/review")
public class ReviewController {


    @Autowired
    ReviewService reviewService;

    @PostMapping("/post")
    private Review getpost(@RequestBody Review review)
    {
        return reviewService.post(review);
    }
}
