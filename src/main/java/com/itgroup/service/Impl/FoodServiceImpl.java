package com.itgroup.service.Impl;

import com.itgroup.domain.Food;
import com.itgroup.domain.FoodCategory;
import com.itgroup.domain.UserFoodIntake;
import com.itgroup.exception.BusinessException;
import com.itgroup.mapper.FoodMapper;
import com.itgroup.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodMapper foodMapper;

    @Override
    public List<Food> findAllFood() {
        List<Food> foods = foodMapper.getAllFood();
        if (foods != null) {
            return foods;
        }
        //TODO:Delete this sentence and return null
        throw new BusinessException("Um... some unknown issues, perhaps Bob can solve");
    }

    @Override
    public List<Food> findFoodsByCategoryId(Long categoryId) {
        if (categoryId != null) {
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
    public List<UserFoodIntake> findFoodIntakeRecordByUserId(Long id) {
        List<UserFoodIntake> recordList = foodMapper.getFoodIntakeRecordByUserId(id);
        if (recordList != null) {
            return recordList;
        }
        throw new BusinessException("wrong in findFoodIntakeRecordByUserId");

    }

    @Override
    public void addDietaryRecord(List<UserFoodIntake> userFoodIntakeList) {
        if (userFoodIntakeList != null && !userFoodIntakeList.isEmpty()) {
            for (UserFoodIntake userFoodIntake :
                    userFoodIntakeList) {
                foodMapper.addFoodIntakeRecord(userFoodIntake);
            }
        } else
            throw new BusinessException("userFoodIntakeList value is empty or null");

    }

    @Override
    public int deleteRecordById(Long id) {
        int count = foodMapper.deleteRecordById(id);
        if(count == 0){
            throw new BusinessException("no such record exists");
        }
        return count;

    }

    @Override
    public int updateRecordQuality(UserFoodIntake userFoodIntake) {
        int count = foodMapper.updateQuality(userFoodIntake);
        if(count == 0){
            throw new BusinessException("no such record exists");
        }
        return count;
    }

}
