package com.itgroup.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserActivity {
    private Long id;
    private int userId;
    private Date activityDate;
    private String activityLevel;
    private int neededCalories;
    private int consumedCalories;
    private int intakeCalories;
}
