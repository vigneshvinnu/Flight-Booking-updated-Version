package com.capgemini.project.review.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.capgemini.project.review.model.Review;
import com.capgemini.project.review.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ReviewService.class})
@ExtendWith(SpringExtension.class)
public class ReviewServiceTest {
    @MockBean
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewService reviewService;

    @Test
    public void testPost() {
        Review review = new Review();
        review.setExperience("Experience");
        review.setUserName("janedoe");
        review.setDescription("The characteristics of someone or something");
        when(this.reviewRepository.save((Review) any())).thenReturn(review);
        assertSame(review, this.reviewService.post(new Review()));
        verify(this.reviewRepository).save((Review) any());
    }

    @Test
    public void testPost2() {
        Review review = new Review();
        review.setExperience("Experience");
        review.setUserName("janedoe");
        review.setDescription("The characteristics of someone or something");
        when(this.reviewRepository.save((Review) any())).thenReturn(review);
        assertSame(review, this.reviewService.post(new Review()));
        verify(this.reviewRepository).save((Review) any());
    }
}

