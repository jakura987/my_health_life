package com.itgroup;

import com.itgroup.domain.Order;
import com.itgroup.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class OrderTest {
    @Autowired
    private OrderService orderService;

    @Test
    void createOrderTest(){
        Order order = Order.builder()
                .userId(1L)
                .totalPrice(50.0)
                .orderTime(new Date())
                .build();

        orderService.createOrder(order);
    }

    @Test
    void getOrdersByUserIdTest(){
        List<Order> ordersByUserId = orderService.getOrdersByUserId(1993L);
        for (Order order :
                ordersByUserId) {
            System.out.println(order);
        }

    }
}
