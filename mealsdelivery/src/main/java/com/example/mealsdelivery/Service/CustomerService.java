package com.example.mealsdelivery.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.mealsdelivery.Repository.CustomerRepository;
import com.example.mealsdelivery.models.Customer;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Optional<Customer> getCustomerById(String id) {
        return customerRepository.findById(id);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(String id, Customer customer) {
        customer.setId(id);
        return customerRepository.save(customer);
    }

    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }


    // Retrieve all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}

