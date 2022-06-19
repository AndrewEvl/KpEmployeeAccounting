package com.evl.employeeaccounting.controllers.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
public class CourseShortDto {

    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
}
