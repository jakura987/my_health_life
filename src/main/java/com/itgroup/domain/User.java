package com.itgroup.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itgroup.utils.CalorieUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Long id;
    private String firstname;
    private String lastname;

    private String username;//email
    private String password;
    private BigDecimal height;
    private BigDecimal weight;
    private Integer age;
    private String gender;


    public User(String firstname, String lastname, String username, String password, BigDecimal height, BigDecimal weight, Integer age, String gender) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.gender = gender;
    }
}
