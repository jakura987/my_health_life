package com.itgroup.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itgroup.utils.CalorieUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String name;

    private String username;//email
    private String password;
    private BigDecimal height;
    private BigDecimal weight;
    private Integer age;
    private String gender;

    public User(String name, String password, BigDecimal height, BigDecimal weight, Integer age, String gender) {
        this.name = name;
        this.password = password;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.gender = gender;
    }
}
