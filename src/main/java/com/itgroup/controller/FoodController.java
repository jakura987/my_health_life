package com.itgroup.controller;

import com.itgroup.common.R;
import com.itgroup.domain.Food;
import com.itgroup.domain.FoodCategory;
import com.itgroup.domain.UserFoodIntake;
import com.itgroup.dto.UserFoodIntakeDTO.FoodDetailDTO;
import com.itgroup.dto.UserFoodIntakeDTO.RecordsWithDate;
import com.itgroup.dto.UserFoodIntakeDTO.UserFoodIntakeDTO;
import com.itgroup.service.FoodService;
import com.itgroup.utils.CalorieUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@ResponseBody
@RequestMapping("/admin/food")
@Api(tags = "food(饮食记录)相关接口")
public class FoodController {
    @Autowired
    private FoodService foodService;
    @GetMapping
    private R<List<Food>> findAllFood(){
        List<Food> foodList = foodService.findAllFood();
        return R.success(foodList);
    }

    @GetMapping("/category")
    private R<List<FoodCategory>> findAllFoodCategory(){
        List<FoodCategory> foodCategoryList = foodService.findAllFoodCategory();
        return R.success(foodCategoryList);
    }

    @GetMapping("/category/{categoryId}")
    private R<List<Food>> findFoodsByCategoryId(@PathVariable Long categoryId){
        List<Food> foodListByCategory = foodService.findFoodsByCategoryId(categoryId);
//        for (Food food :
//                foodListByCategory) {
//            System.out.println(food);
//        }
        return R.success(foodListByCategory);
    }

    @PostMapping("/addDietaryRecord")
    private R<String> addDietaryRecord(@RequestBody UserFoodIntakeDTO userFoodIntakeDTO){

        RecordsWithDate recordsWithDate = userFoodIntakeDTO.getRecordsWithDate();
        Map<String, List<FoodDetailDTO>> records = recordsWithDate.getRecords();

        String dateStr = recordsWithDate.getDate();
        Date recordDate = CalorieUtil.convertToFormattedSqlDate(dateStr);
//        System.out.println("recordDate: " + recordDate);
        Long userId = recordsWithDate.getUserId();

        List<UserFoodIntake> userFoodIntakes = new ArrayList<>();

        // Process each meal
        CalorieUtil.processMeal(records.get("breakfast"), userId, 1, userFoodIntakes, recordDate);
//        CalorieUtil.processMeal(records.get("lunch"), userId, 2, userFoodIntakes, recordDate);
//        CalorieUtil.processMeal(records.get("dinner"), userId, 3, userFoodIntakes, recordDate);


//        foodService.addDietaryRecord(userFoodIntakes);

        return R.success("add successfully");
    }





}
