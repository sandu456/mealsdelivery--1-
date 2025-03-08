package com.example.mealsdelivery.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mealsdelivery.models.Meal;


    public interface MealRepository extends MongoRepository<Meal, String> {

        List<Meal> findByIsAvailable(boolean b);
}
    
