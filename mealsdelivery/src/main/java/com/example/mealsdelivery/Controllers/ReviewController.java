package com.example.mealsdelivery.Controllers;


import com.example.mealsdelivery.Service.ReviewService;
import com.example.mealsdelivery.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('CUSTOMER')")
    public Review addReview(@RequestBody Review review) {
        return reviewService.addReview(review);
    }

    @GetMapping("/{id}")
    public Optional<Review> getReviewById(@PathVariable String id) {
        return reviewService.getReviewById(id);
    }


    @GetMapping("/{mealId}")
    public List<Review> getReviewsByMealId(@PathVariable String mealId) {
        return reviewService.getReviewsByMealId(mealId);
    }

    @GetMapping("/get")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }



    @PutMapping("/{id}")
    @PreAuthorize("hasRole('CUSTOMER')")
    public Review updateReview(@PathVariable String id, @RequestBody Review review){
        return reviewService.updateReview(id,review);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
   public String deleteReview(@PathVariable String id) {
        reviewService.deleteReview(id);
        return "Review with ID " + id + " has been deleted.";
    }



} 
