package com.capgemini.project.review.repository;

import com.capgemini.project.review.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository  extends MongoRepository<Review,String> {
}
