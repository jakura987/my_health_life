package com.itgroup.mapper;

import com.itgroup.domain.Food;
import com.itgroup.domain.FoodCategory;
import com.itgroup.domain.UserFoodIntake;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FoodMapper {
    @Select("select * from food")
    List<Food> getAllFood();

    @Select("select * from food_category")
    List<FoodCategory> getAllFoodCategory();

    @Select("select * from food where category_id = #{categoryId}")
    List<Food> getFoodsByCategoryId(Long categoryId);

    @Insert("insert into user_food_intake(type, user_id, food_id, grams, intake_date)VALUES (#{type}, #{userId}, #{foodId}, #{grams}, #{intakeDate})")
    void addFoodIntakeRecord(UserFoodIntake userFoodIntakeRecord);
}
