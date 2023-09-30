package com.itgroup.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String name;
    private Long productSeriesId;
    private Long productCategoryId;
    private Double price;
    private String image;
}
