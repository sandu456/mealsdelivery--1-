package com.example.mealsdelivery.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mealsdelivery.models.Order;



public interface OrderRepository extends MongoRepository<Order, String> {

    List<Order> findByCustomerId(String customerId);
    boolean existsByCustomerIdAndMealId(String customerId, String mealId);
}
