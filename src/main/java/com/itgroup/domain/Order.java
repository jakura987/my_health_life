package com.itgroup.domain;

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
public class Order {
    private Long id;
    private Long userId;
    @ApiModelProperty(hidden = true)
    private String address;
    @ApiModelProperty(hidden = true)
    private String phone;
    @ApiModelProperty(hidden = true)
    private Date orderTime;
    private Double totalPrice;

}
