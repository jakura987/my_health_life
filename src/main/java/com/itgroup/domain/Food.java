package com.itgroup.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Food {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String name;
    private Long categoryId;
    private Integer caloriesPer100g;
    private BigDecimal proteinPer100g;
    private BigDecimal fatPer100g;
    private BigDecimal carbsPer100g;
    private BigDecimal sugarsPer100g;
    private String image;
}
