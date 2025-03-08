package com.example.mealsdelivery.Controllers;

import com.example.mealsdelivery.Service.OrderService;
import com.example.mealsdelivery.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;













@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('CUSTOMER')")
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Optional<Order> getOrderById(@PathVariable String id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/customers/{customerId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
    public List<Order> getOrdersByCustomerId(@PathVariable String customerId) {
        return orderService.getOrdersByCustomerId(customerId);
    }

    @GetMapping("/get")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable String id, @RequestBody Order order){
        return orderService.updateOrder(id,order);
    }


}


