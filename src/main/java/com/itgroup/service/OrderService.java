package com.itgroup.service;

import com.itgroup.domain.Order;

import java.util.List;

public interface OrderService {
    Integer createOrder(Order order);
    List<Order> getOrdersByUserId(Long userId);
}
