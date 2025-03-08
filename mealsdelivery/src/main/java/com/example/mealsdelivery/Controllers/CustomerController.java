package com.example.mealsdelivery.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mealsdelivery.Service.CustomerService;
import com.example.mealsdelivery.models.Customer;



@RestController
    @RequestMapping("/customers")
    public class CustomerController{

        @Autowired
            private CustomerService customerService;
        @PostMapping("/create")
    public Customer createCustomer(@RequestBody Customer customer) {
            return customerService.createCustomer(customer);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
        @GetMapping("/get/{id}")
        @PreAuthorize("hasRole('ADMIN')")
            public Optional<Customer> getCustomer(@PathVariable String id){
                return customerService.getCustomerById(id);
            }
        @PutMapping("/{id}") 
            public Customer updateCustomer(@PathVariable String id, @RequestBody Customer customer){
                return customerService.updateCustomer(id, customer);
            }
         @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);
        return "Customer with ID " + id + " has been deleted.";
    }}








    
