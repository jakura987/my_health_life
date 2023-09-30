package com.itgroup.vo;

import com.itgroup.domain.ShoppingCart;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ShoppingCartVo extends ShoppingCart {
    @ApiModelProperty(value = "Unit Price")
    private Double unitPrice;
    private String productName;
}
