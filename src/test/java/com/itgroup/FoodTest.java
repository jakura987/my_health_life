package com.itgroup;

import com.itgroup.domain.Food;
import com.itgroup.domain.UserFoodIntake;
import com.itgroup.mapper.FoodMapper;
import com.itgroup.service.FoodService;
import lombok.Builder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class FoodTest {
    @Autowired
    private FoodService foodService;

    @Test
    void getFoodListTest(){
        List<Food> foodList = foodService.findAllFood();
        for (Food food :
                foodList) {
            System.out.println(food);
        }
    }

    @Test
    void addRecordTest(){
        ArrayList<UserFoodIntake> list = new ArrayList<>();
        UserFoodIntake userFoodIntake = UserFoodIntake.builder()
                .type(2)
                .userId(2L)
                .foodId(1657890910927896543L)
                .grams(200)
                .intakeDate(new Date(System.currentTimeMillis()))
                .build();

        UserFoodIntake userFoodIntake2 = UserFoodIntake.builder()
                .type(3)
                .userId(2L)
                .foodId(1657890910927896543L)
                .grams(300)
                .intakeDate(new Date(System.currentTimeMillis()))
                .build();
        list.add(userFoodIntake);
        list.add(userFoodIntake2);
        foodService.addDietaryRecord(list);

    }

    @Test
    void getRecordByUserId(){
        List<UserFoodIntake> list = foodService.findFoodIntakeRecordByUserId(1L);
        for (UserFoodIntake userfoodIntake :
                list) {
            System.out.println(userfoodIntake);
        }
    }

    @Test
    void deleteRecordById(){
        foodService.deleteRecordById(42L);
    }

}
