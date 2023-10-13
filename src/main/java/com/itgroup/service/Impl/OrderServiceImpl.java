package com.itgroup.service.Impl;

import com.itgroup.common.R;
import com.itgroup.domain.Order;
import com.itgroup.exception.BusinessException;
import com.itgroup.mapper.OrderMapper;
import com.itgroup.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Integer createOrder(Order order) {
        try{
            order.setOrderTime(new Date());
            return orderMapper.addOrder(order);
        }catch (Exception e){
            throw new BusinessException("Error occurs in CreateOrder " + e.getMessage());
        }
    }

    @Override
    public List<Order> getOrdersByUserId(Long userId) {
        List<Order> ordersByUserId = orderMapper.getOrdersByUserId(userId);
        return ordersByUserId;
    }
}
