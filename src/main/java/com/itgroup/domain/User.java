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
    private String firstName;
    private String lastName;
    private String userName;//email
    private String password;
    private BigDecimal height;
    private BigDecimal weight;
    private Integer age;
    private String gender;

}
