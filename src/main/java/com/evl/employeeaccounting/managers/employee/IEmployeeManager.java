package com.evl.employeeaccounting.managers.employee;

import com.evl.employeeaccounting.controllers.dto.EmployeeChangeDto;
import com.evl.employeeaccounting.controllers.dto.EmployeeFullDto;
import com.evl.employeeaccounting.controllers.dto.EmployeeShortDto;
import com.evl.employeeaccounting.entityes.Employee;

import java.util.List;

public interface IEmployeeManager {

    List<EmployeeFullDto> findAllDto();

    EmployeeFullDto toEmployeeFullDto(Employee employee);

    EmployeeShortDto toEmployeeShortDto(Employee employee);

    EmployeeFullDto save(EmployeeChangeDto employeeDto);

    void delete(Long id);

    EmployeeFullDto getById(Long id);
}
