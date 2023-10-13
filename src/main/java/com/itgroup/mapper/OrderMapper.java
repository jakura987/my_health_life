package com.itgroup.mapper;

import com.itgroup.domain.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Insert("insert into orders(user_id, order_time, totalPrice, address, phone) VALUES (#{userId} ,#{orderTime}, #{totalPrice}, #{address}, #{phone})")
    Integer addOrder(Order order);

    @Select("select * from orders where user_id = #{userId}")
    List<Order> getOrdersByUserId(Long userId);
}
