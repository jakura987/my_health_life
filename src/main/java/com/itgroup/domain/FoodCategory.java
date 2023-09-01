package com.itgroup.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodCategory {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String name;
    private Integer sort;
}
