package com.capgemini.project.review.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ReviewTest {
    @Test
    public void testSetUserName() {
        Review review = new Review();
        review.setUserName("janedoe");
        assertEquals("janedoe", review.getUserName());
    }

    @Test
    public void testSetExperience() {
        Review review = new Review();
        review.setExperience("Experience");
        assertEquals("Experience", review.getExperience());
    }

    @Test
    public void testSetDescription() {
        Review review = new Review();
        review.setDescription("The characteristics of someone or something");
        assertEquals("The characteristics of someone or something", review.getDescription());
    }
}

