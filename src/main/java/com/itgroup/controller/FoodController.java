package com.itgroup.controller;

import com.itgroup.common.R;
import com.itgroup.domain.Food;
import com.itgroup.domain.FoodCategory;
import com.itgroup.domain.UserFoodIntake;
import com.itgroup.service.FoodService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return R.success(foodListByCategory);
    }

    @PostMapping("/addDietaryRecord")
    private R<String> addDietaryRecord(@RequestBody List<UserFoodIntake> userFoodIntakeList){
        foodService.addDietaryRecord(userFoodIntakeList);
        return R.success("add successfully");
    }
}
