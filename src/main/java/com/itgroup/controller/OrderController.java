package com.itgroup.controller;

import com.itgroup.common.R;
import com.itgroup.domain.Order;
import com.itgroup.service.OrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/user/orders")
@Api(tags = "orders(online mart) related interface")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public R<String> createNewOrder(@RequestBody Order order){
        Integer count = orderService.createOrder(order);
        if(count != 0){
            return R.success("create successfully");
        }
        return R.error("create fail");

    }

    @GetMapping("/getOrders/{userId}")
    public R<List<Order>> getOrdersById(@PathVariable Long userId){
        List<Order> orderList = orderService.getOrdersByUserId(userId);
        return R.success(orderList);
    }
}
