package com.example.mealsdelivery.Service;

import org.springframework.stereotype.Service;

import com.example.mealsdelivery.Repository.MealRepository;
import com.example.mealsdelivery.Repository.OrderRepository;
import com.example.mealsdelivery.models.Meal;
import com.example.mealsdelivery.models.Order;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final MealRepository mealRepository;

    public OrderService(OrderRepository orderRepository,MealRepository mealRepository) {
        this.orderRepository = orderRepository;
        this.mealRepository=mealRepository;
    }

    
    public Order createOrder(Order order) {
        Optional<Meal> mealOpt = mealRepository.findById(order.getMealId());

        if (mealOpt.isEmpty()) {
            throw new IllegalArgumentException("Meal not found for ID: " + order.getMealId());
        }

        Meal meal = mealOpt.get();
        double totalAmount = meal.getPrice() * order.getTotalAmount();  // Calculate price

        order.setPaymentAmount(totalAmount);  // Set calculated payment
        return orderRepository.save(order);
    }

    public Optional<Order> getOrderById(String id) {
        return orderRepository.findById(id);
    }

    public List<Order> getOrdersByCustomerId(String customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order updateOrder(String id, Order order) {
        if (orderRepository.existsById(id)) {
            Optional<Meal> mealOpt = mealRepository.findById(order.getMealId());

            if (mealOpt.isEmpty()) {
                throw new IllegalArgumentException("Meal not found for ID: " + order.getMealId());
            }

            double updatedAmount = mealOpt.get().getPrice() * order.getTotalAmount();
            order.setPaymentAmount(updatedAmount);  // Recalculate amount on update

            order.setId(id);
            return orderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Order with ID " + id + " does not exist.");
        }
    }

    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }

    public boolean hasPurchasedMeal(String customerId, String mealId) {
        return orderRepository.existsByCustomerIdAndMealId(customerId, mealId);
    }

}

