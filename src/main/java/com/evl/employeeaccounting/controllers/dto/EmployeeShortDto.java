package com.evl.employeeaccounting.controllers.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
public class EmployeeShortDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String surname;
    private LocalDate birthday;
    private BaseData department;
    private BaseData position;
    private BaseData status;

}
