package com.itgroup.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "用户食物摄入记录")
public class UserFoodIntake {
    @ApiModelProperty(value = "id", hidden = true)
    private Long id;
    private Integer type;//breakfast, lunch, dinner
    private Long userId;
    private Long foodId;
    private Integer grams;
    @ApiModelProperty(value = "摄入日期", hidden = true)
    private LocalDate intakeDate;
}
