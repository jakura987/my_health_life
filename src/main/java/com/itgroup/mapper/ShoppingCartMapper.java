package com.itgroup.mapper;

import com.itgroup.domain.Product;
import com.itgroup.domain.ShoppingCart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {
    @Select("select * from shopping_cart where user_id = #{userId}")
    List<ShoppingCart> getShoppingCartByUserId(Long userId);

    @Insert("insert into shopping_cart (user_id, product_id, quantity, total_amount, create_time, update_time)VALUES (#{userId}, #{productId},#{quantity}, #{totalAmount}, #{createTime}, #{updateTime})")
    void add(ShoppingCart shoppingCart);

    @Delete("delete from shopping_cart where id = #{id}")
    void delete(Long id);

    void update(ShoppingCart shoppingCart);


}
