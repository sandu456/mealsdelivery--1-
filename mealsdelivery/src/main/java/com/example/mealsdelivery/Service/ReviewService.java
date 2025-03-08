package com.example.mealsdelivery.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.mealsdelivery.Repository.ReviewRepository;
import com.example.mealsdelivery.models.Review;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    public Optional<Review> getReviewById(String id) {
        return reviewRepository.findById(id);
    }

    public List<Review> getReviewsByMealId(String mealId) {
        return reviewRepository.findByMealId(mealId);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review updateReview(String id, Review review) {
        review.setId(id);
        return reviewRepository.save(review);
    }

    public void deleteReview(String id) {
        reviewRepository.deleteById(id);
    }
}