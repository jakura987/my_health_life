package com.itgroup.mapper;

import com.itgroup.domain.Product;
import com.itgroup.domain.ShoppingCart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShoppingCartMapper {
    @Insert("insert into shopping_cart (user_id, product_id, quantity, total_amount, create_time)VALUES (#{userId}, #{productId},#{quantity}, #{totalAmount}, #{createTime})")
    void add(ShoppingCart shoppingCart);
}
