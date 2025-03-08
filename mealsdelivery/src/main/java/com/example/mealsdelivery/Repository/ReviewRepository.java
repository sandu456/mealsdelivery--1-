package com.example.mealsdelivery.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mealsdelivery.models.Review;

public interface ReviewRepository extends MongoRepository<Review, String> {

    List<Review> findByMealId(String mealId);
    
}
