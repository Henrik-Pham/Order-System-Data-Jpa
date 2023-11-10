package com.example.jpademo.Service;

import com.example.jpademo.order.Order;
import com.example.jpademo.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepo orderRepo;

    @Autowired
    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public Order createOrder(Order order) {
        return orderRepo.save(order);
    }

    public List<Order> getOrders() {
        return orderRepo.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepo.findById(id).orElse(null);
    }
}
