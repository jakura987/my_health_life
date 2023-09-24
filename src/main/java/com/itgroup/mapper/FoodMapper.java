package com.itgroup.mapper;

import com.itgroup.domain.Food;
import com.itgroup.domain.FoodCategory;
import com.itgroup.domain.UserFoodIntake;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Mapper
public interface FoodMapper {
    @Select("select * from food")
    List<Food> getAllFood();

    @Select("select * from food_category")
    List<FoodCategory> getAllFoodCategory();

    @Select("select * from food where category_id = #{categoryId}")
    List<Food> getFoodsByCategoryId(Long categoryId);

    @Insert("insert into user_food_intake(type, user_id, food_id, category_id, name, grams, intake_date)VALUES (#{type}, #{userId}, #{foodId},#{categoryId},#{name}, #{grams}, #{intakeDate})")
    void addFoodIntakeRecord(UserFoodIntake userFoodIntakeRecord);

    @Select("select * from user_food_intake where user_id = #{id}")
    List<UserFoodIntake> getFoodIntakeRecordByUserId(Long id);

    @Delete("delete from user_food_intake where id = #{id}")
    int deleteRecordById(Long id);

    int updateQuality(UserFoodIntake userFoodIntake);


}
