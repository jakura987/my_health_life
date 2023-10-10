package com.itgroup.controller;

import com.itgroup.common.R;
import com.itgroup.domain.Food;
import com.itgroup.domain.FoodCategory;
import com.itgroup.domain.MealType;
import com.itgroup.domain.UserFoodIntake;
import com.itgroup.dto.UserFoodIntakeDTO.FoodDetailDTO;
import com.itgroup.dto.UserFoodIntakeDTO.RecordsWithDate;
import com.itgroup.dto.UserFoodIntakeDTO.UserFoodIntakeDTO;
import com.itgroup.service.FoodService;
import com.itgroup.utils.CalorieUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@ResponseBody
@RequestMapping("/admin/food")
@Api(tags = "food(dietary record)related interface")
public class FoodController {
    @Autowired
    private FoodService foodService;

    /**
     * Handles the GET request to retrieve all available foods.
     *
     * @return R object encapsulating the success response and the list of all foods.
     */
    @GetMapping
    private R<List<Food>> findAllFood(){
        List<Food> foodList = foodService.findAllFood();
        return R.success(foodList);
    }

    /**
     * Handles the GET request to retrieve all available food categories.
     *
     * @return R object encapsulating the success response and the list of all food categories.
     */
    @GetMapping("/category")
    private R<List<FoodCategory>> findAllFoodCategory(){
        List<FoodCategory> foodCategoryList = foodService.findAllFoodCategory();
        return R.success(foodCategoryList);
    }

    /**
     * Handles the GET request to retrieve foods belonging to a specific category.
     *
     * @param categoryId The ID of the food category.
     * @return R object encapsulating the success response and the list of foods for the given category.
     */
    @GetMapping("/category/{categoryId}")
    private R<List<Food>> findFoodsByCategoryId(@PathVariable Long categoryId){
        List<Food> foodListByCategory = foodService.findFoodsByCategoryId(categoryId);
        return R.success(foodListByCategory);
    }

    /**
     * Handles the POST request to add dietary records for a user.
     *
     * @param userFoodIntakeDTO The dietary details received as a JSON in the request body.
     * @return R object encapsulating the success response message.
     */
    @PostMapping("/addDietaryRecord")
    private R<String> addDietaryRecord(@RequestBody UserFoodIntakeDTO userFoodIntakeDTO){
        RecordsWithDate recordsWithDate = userFoodIntakeDTO.getRecordsWithDate();
        Map<String, List<FoodDetailDTO>> records = recordsWithDate.getRecords();

        String dateStr = recordsWithDate.getDate();
        Date recordDate = CalorieUtil.convertToFormattedSqlDate(dateStr);
        Long userId = recordsWithDate.getUserId();
        List<UserFoodIntake> userFoodIntakes = new ArrayList<>();

        CalorieUtil.processMeal(records.get("breakfast"), userId, MealType.BREAKFAST, userFoodIntakes, recordDate);
        CalorieUtil.processMeal(records.get("lunch"), userId, MealType.LUNCH, userFoodIntakes, recordDate);
        CalorieUtil.processMeal(records.get("dinner"), userId, MealType.DINNER, userFoodIntakes, recordDate);
        CalorieUtil.processMeal(records.get("snack"), userId, MealType.SNACK, userFoodIntakes, recordDate);

        foodService.addDietaryRecord(userFoodIntakes);
        return R.success("add successfully");
    }

    /**
     * Handles the GET request to retrieve the dietary record history for a specific user.
     *
     * @param userId The ID of the user.
     * @return R object encapsulating the success response and the list of dietary records for the user.
     */
    @GetMapping("/getDietaryRecordByUserId/{userId}")
    private R<List<UserFoodIntake>> findDietaryRecordHistoryByUserId(@PathVariable Long userId){
        List<UserFoodIntake> recordList = foodService.findFoodIntakeRecordByUserId(userId);
        return R.success(recordList);
    }

    /**
     * Handles the DELETE request to remove a specific dietary record by its ID.
     *
     * @param id The ID of the dietary record to be removed.
     * @return R object encapsulating the success response message.
     */
    @DeleteMapping("/removeDietaryRecordById/{id}")
    private R<String> removeDietaryRecordById(@PathVariable Long id){
        foodService.deleteRecordById(id);
        return R.success("remove successfully");
    }

    /**
     * Handles the PUT request to update the quantity/details of a dietary record.
     *
     * @param userFoodIntake The updated dietary record received as a JSON in the request body.
     * @return R object encapsulating the success response message.
     */
    @PutMapping("/updateRecordQuality")
    private R<String> updateRecordQuality(@RequestBody UserFoodIntake userFoodIntake){
        foodService.updateRecordQuality(userFoodIntake);
        return R.success("update quality successfully");
    }


}
