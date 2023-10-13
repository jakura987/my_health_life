package com.itgroup.controller;

import com.itgroup.common.R;
import com.itgroup.domain.Order;
import com.itgroup.domain.User;
import com.itgroup.service.OrderService;
import com.itgroup.service.UserService;
import com.itgroup.vo.OrderVo;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin/user/orders")
@Api(tags = "orders(online mart) related interface")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    /**
     * Create new orders from the provided list.
     *
     * @param orderList A list of orders to be created.
     * @return A response indicating success or error.
     */
    @PostMapping("/add")
    public R<String> createOrders(@RequestBody List<Order> orderList){
        if(orderList != null && !orderList.isEmpty()){
            for (Order order :
                    orderList) {
                orderService.createOrder(order);
            }
            return R.success("create successfully");
        }

        return R.error("orderList is empty");

    }

    /**
     * Retrieve a list of orders associated with the specified user ID.
     * This method also enhances the retrieved orders with additional details
     * from the User entity (e.g., the user's first name).
     *
     * @param userId The ID of the user whose orders are to be retrieved.
     * @return A response containing a list of enhanced order details (OrderVo).
     */
    @GetMapping("/getOrders/{userId}")
    public R<List<OrderVo>> getOrdersById(@PathVariable Long userId){
        List<Order> orderList = orderService.getOrdersByUserId(userId);
        ArrayList<OrderVo> orderVosList = new ArrayList<>();
        User user = userService.findUserById(userId);
        if(orderList != null && !orderList.isEmpty()){
            for (Order order :
                    orderList) {
                OrderVo orderVo = new OrderVo();
                BeanUtils.copyProperties(order, orderVo);

                orderVo.setUserName(user.getFirstName());
                orderVosList.add(orderVo);
            }
        }
        return R.success(orderVosList);
    }
}
