package com.evl.employeeaccounting.controllers.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
public class CourseChangeDto {

    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Long> addEmployee = new ArrayList<>();
    private List<Long> minusEmployee = new ArrayList<>();
}
