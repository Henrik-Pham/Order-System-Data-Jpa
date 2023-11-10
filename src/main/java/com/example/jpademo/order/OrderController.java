package com.example.jpademo.order;

import com.example.jpademo.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderRepo orderRepo;

    @GetMapping
    public List<Order> getOrders() {
        return orderRepo.findAll();
    }
}
