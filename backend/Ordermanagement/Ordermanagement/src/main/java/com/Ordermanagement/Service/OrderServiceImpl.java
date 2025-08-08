package com.Ordermanagement.Service;

import com.Ordermanagement.Repository.OrderRepository;
import com.Ordermanagement.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    @Autowired
    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    @Override
    public Order getOrder(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Order createOrder(Order order) {
        return repository.save(order);
    }

    @Override
    public Order updateOrder(Long id, Order updated) {
        Order existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        existing.setCustomerName(updated.getCustomerName());
        existing.setProductName(updated.getProductName());
        existing.setQuantity(updated.getQuantity());
        existing.setStatus(updated.getStatus());
        return repository.save(existing);
    }

    @Override
    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }
}
