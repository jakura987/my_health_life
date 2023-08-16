package com.itgroup.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductSeries {
    private Long id;
    private Long productCategoryId;
    private String name;
    private String description;
    private Integer sort;
}
