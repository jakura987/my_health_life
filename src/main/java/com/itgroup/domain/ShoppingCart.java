package com.itgroup.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoppingCart {
    private Integer id;
    private Integer userId;
    private Long productId;
    private Integer quantity;
    private Double totalAmount;
    private LocalDateTime createTime;
}
