package com.evl.employeeaccounting.controllers.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
public class CourseFullDto {

    private int id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<EmployeeShortDto> employeeList;
}
