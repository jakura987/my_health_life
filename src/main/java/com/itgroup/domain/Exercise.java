package com.itgroup.domain;

import lombok.Data;

@Data
public class Exercise {
    private Long id;
    private String name;
    private int aveCaloriesBurnedPerHour;
}
