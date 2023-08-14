package com.itgroup.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserExerciseLog {
    private Long id;
    private Long userId;
    private Long exerciseId;
    private int durationMinutes;
    private Date date;
}
