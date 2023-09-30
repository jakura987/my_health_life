package com.itgroup.vo;

import com.itgroup.domain.ShoppingCart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ShoppingCartVo extends ShoppingCart {
    private String productName;
}
