package com.itgroup.dto.UserFoodIntakeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordsWithDate {
    private Long userId;
    private String date;
    private Map<String, List<FoodDetailDTO>> records;
}
