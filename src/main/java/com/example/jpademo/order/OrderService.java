package com.example.jpademo.order;

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

    public List<Order> getOrders(){
        return orderRepo.findAll();
    }

    public Order getOrderById(Long id){
        return orderRepo.findById(id).orElse(null);
    }

    public Order createOrder(Order order){
        return orderRepo.save(order);
    }

    public void deleteOrder(Long id){
        orderRepo.deleteById(id);
    }
}
