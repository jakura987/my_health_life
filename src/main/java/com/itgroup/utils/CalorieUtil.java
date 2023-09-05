package com.itgroup.utils;

import com.itgroup.domain.UserFoodIntake;
import com.itgroup.dto.UserFoodIntakeDTO.FoodDetailDTO;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class CalorieUtil {

    /**
     * 根据activity level, 计算每天所需要的卡路里
     *
     * @param weight
     * @param height
     * @param age
     * @param gender
     * @param activityLevel
     * @return
     */
    public static int calculateNeededCalories(BigDecimal weight, BigDecimal height, int age, String gender, String activityLevel) {
        int bmr = CalorieUtil.calculateBmr(weight, height, age, gender);
        int everyDayCalorieNeeds = CalorieUtil.calculateDailyCalorieNeeds(bmr, activityLevel);
        return everyDayCalorieNeeds;
    }

    public static int calculateBmr(BigDecimal weight, BigDecimal height, int age, String gender) {
        BigDecimal bmr;

        if ("male".equalsIgnoreCase(gender)) {
            bmr = new BigDecimal("88.362")
                    .add(new BigDecimal("13.397").multiply(weight))
                    .add(new BigDecimal("4.799").multiply(height))
                    .subtract(new BigDecimal("5.677").multiply(new BigDecimal(age)));
        } else {  // assuming any other input defaults to female
            bmr = new BigDecimal("447.593")
                    .add(new BigDecimal("9.247").multiply(weight))
                    .add(new BigDecimal("3.098").multiply(height))
                    .subtract(new BigDecimal("4.330").multiply(new BigDecimal(age)));
        }

        return bmr.intValue();
    }

    public static int calculateDailyCalorieNeeds(int bmr, String activityLevel) {
        switch (activityLevel) {
            case "Sedentary":
                return (int) (bmr * 1.2);
            case "Light":
                return (int) (bmr * 1.375);
            case "Moderate":
                return (int) (bmr * 1.55);
            case "Active":
                return (int) (bmr * 1.725);
            case "Very Active":
                return (int) (bmr * 1.9);
            default:
                return bmr;
        }
    }

    public static void processMeal(List<FoodDetailDTO> foodList, Long userId, int type, List<UserFoodIntake> userFoodIntakes, Date recordDate) {
        if (foodList != null && !foodList.isEmpty()) {
            for (FoodDetailDTO foodDetailDto : foodList) {
                UserFoodIntake userFoodIntake = new UserFoodIntake();
                BeanUtils.copyProperties(foodDetailDto, userFoodIntake);
                userFoodIntake.setUserId(userId);
                userFoodIntake.setType(type);
                userFoodIntake.setIntakeDate(recordDate);
                userFoodIntakes.add(userFoodIntake);

            }
        }
    }


    public static Date convertToFormattedSqlDate(String inputDateStr) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("MM/dd/yyyy");
            java.util.Date utilDate = inputFormat.parse(inputDateStr);

            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDateStr = outputFormat.format(utilDate);

            return java.sql.Date.valueOf(formattedDateStr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

