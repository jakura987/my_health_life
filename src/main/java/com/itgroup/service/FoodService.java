package com.itgroup.service;

import com.itgroup.domain.Food;
import com.itgroup.domain.FoodCategory;
import com.itgroup.domain.UserFoodIntake;

import java.util.List;

public interface FoodService {
    List<Food> findAllFood();
    List<Food> findFoodsByCategoryId(Long categoryId);
    List<FoodCategory> findAllFoodCategory();
    void addDietaryRecord(List<UserFoodIntake> userFoodIntakeList);
    List<UserFoodIntake> findFoodIntakeRecordByUserId(Long id);

}
