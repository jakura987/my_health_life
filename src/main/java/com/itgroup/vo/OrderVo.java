package com.itgroup.vo;

import com.itgroup.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVo extends Order {
    private Integer quantity;
    private String userName;
}
