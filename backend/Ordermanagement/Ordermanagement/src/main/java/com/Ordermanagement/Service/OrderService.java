package com.Ordermanagement.Service;

import com.Ordermanagement.model.Order;
import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrder(Long id);
    Order createOrder(Order order);
    Order updateOrder(Long id, Order updated);
    void deleteOrder(Long id);
}
