package com.itgroup.service.Impl;

import com.itgroup.domain.Food;
import com.itgroup.domain.FoodCategory;
import com.itgroup.domain.UserFoodIntake;
import com.itgroup.exception.BusinessException;
import com.itgroup.mapper.FoodMapper;
import com.itgroup.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodMapper foodMapper;
    @Override
    public List<Food> findAllFood() {
        List<Food> foods = foodMapper.getAllFood();
        if(foods != null){
            return foods;
        }
        //TODO:Delete this sentence and return null
        throw new BusinessException("Um... some unknown issues, perhaps Bob can solve");
    }

    @Override
    public List<Food> findFoodsByCategoryId(Long categoryId) {
        if(categoryId != null){
            List<Food> foodList = foodMapper.getFoodsByCategoryId(categoryId);
            return foodList;
        }
        throw new BusinessException("no such category");
    }

    @Override
    public List<FoodCategory> findAllFoodCategory() {
        List<FoodCategory> list = foodMapper.getAllFoodCategory();
        return list;
    }

    @Override
    public void addDietaryRecord(List<UserFoodIntake> userFoodIntakeList) {
        for (UserFoodIntake userFoodIntake :
                userFoodIntakeList) {
            userFoodIntake.setIntakeDate(new Date(System.currentTimeMillis()));
            foodMapper.addFoodIntakeRecord(userFoodIntake);
        }
    }

    @Override
    public List<UserFoodIntake> findFoodIntakeRecordByUserId(Long id) {
        List<UserFoodIntake> recordList = foodMapper.getFoodIntakeRecordByUserId(id);
        return recordList;
    }
}
