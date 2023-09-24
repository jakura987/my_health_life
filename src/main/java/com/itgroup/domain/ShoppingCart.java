package com.itgroup.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoppingCart {
    @ApiModelProperty(value = "shoppingCartId", hidden = true)
    private Long id;
    private Long userId;
    private Long productId;
    private Integer quantity;
    private Double totalAmount;
    @ApiModelProperty(value = "createTime", hidden = true)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @ApiModelProperty(value = "updateTime", hidden = true)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
