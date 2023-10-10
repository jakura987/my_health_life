package com.itgroup.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Food {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String name;
    private Long categoryId;
    private String image;
}
