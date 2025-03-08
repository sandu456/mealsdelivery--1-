package com.example.mealsdelivery.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mealsdelivery.models.Customer;

public interface CustomerRepository extends MongoRepository<Customer,String> {
    
}
