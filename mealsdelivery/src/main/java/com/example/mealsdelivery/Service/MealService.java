package com.example.mealsdelivery.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.mealsdelivery.Repository.MealRepository;
import com.example.mealsdelivery.models.Meal;

@Service
public class MealService {
    private final MealRepository mealRepository;

    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }


    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }

    public Optional<Meal> getMealById(String id) {
        return mealRepository.findById(id);
            
    }
        
            
    public Meal saveMeal(Meal meal) {
        return mealRepository.save(meal);
    }

    public Meal updateMeal(String id, Meal meal) {
        meal.setId(id);
        return mealRepository.save(meal);
    }

    public void deleteMeal(String id) {
        mealRepository.deleteById(id);
    }

    public List<Meal> getAvailableMeals() {
        return mealRepository.findByIsAvailable(true); // Custom query for available meals
    }
}
    

