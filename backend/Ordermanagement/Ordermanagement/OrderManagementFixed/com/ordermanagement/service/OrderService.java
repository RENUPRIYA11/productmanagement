package com.ordermanagement.service;

import com.ordermanagement.model.Order;
import com.ordermanagement.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public Order getOrder(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Order createOrder(Order order) {
        return repository.save(order);
    }

    public Order updateOrder(Long id, Order updatedOrder) {
        Optional<Order> optionalOrder = repository.findById(id);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setProduct(updatedOrder.getProduct());
            return repository.save(order);
        } else {
            return null;
        }
    }

    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }
}