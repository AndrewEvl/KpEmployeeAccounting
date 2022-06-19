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
public class EmployeeChangeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String surname;
    private LocalDate birthday;
    private Long departmentId;
    private Long positionId;
    private Long statusId;
    private List<Long> addCourse = new ArrayList<>();
    private List<Long> minusCourse = new ArrayList<>();
}
