package com.example.jpademo.repository;


import com.example.jpademo.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
