package com.itgroup.dto.UserFoodIntakeDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDetailDTO {
    private Long foodId;
    private String name;
    private Long categoryId;
    private Integer grams;

}

