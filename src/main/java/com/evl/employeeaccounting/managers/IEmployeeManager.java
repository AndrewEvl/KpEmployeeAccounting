package com.evl.employeeaccounting.managers;

import com.evl.employeeaccounting.controllers.dto.EmployeeDto;

import java.util.List;

public interface IEmployeeManager {

    List<EmployeeDto> findAll ();
}
