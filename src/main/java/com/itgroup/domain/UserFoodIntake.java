package com.itgroup.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "用户食物摄入记录")
public class UserFoodIntake {
    @ApiModelProperty(value = "id")
    private Long id;
    private Integer type;//breakfast, lunch, dinner
    private Long userId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long foodId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long categoryId;
    private String name;// name of food
    private Integer grams;
    @ApiModelProperty(value = "摄入日期", hidden = true)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date intakeDate;
}
