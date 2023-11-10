package com.example.jpademo;

import com.example.jpademo.Service.OrderService;
import com.example.jpademo.order.Order;
import com.example.jpademo.repository.OrderRepo;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest
public class OrderServiceUnitTest {

    @MockBean
    private OrderRepo orderRepo;

    @Autowired
    private OrderService orderService;

    @Test
    void shouldGetOrders(){
        List<Order> orderList = List.of(new Order());

    }
}
