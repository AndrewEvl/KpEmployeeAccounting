package com.evl.employeeaccounting.managers.enployee;

import com.evl.employeeaccounting.controllers.dto.BaseData;
import com.evl.employeeaccounting.controllers.dto.EmployeeDto;
import com.evl.employeeaccounting.entityes.Employee;
import com.evl.employeeaccounting.services.implimentation.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@Transactional
@AllArgsConstructor
public class EmployeeManager implements IEmployeeManager {

    private final EmployeeService employeeService;

    @Override
    public List<EmployeeDto> findAll() {
        return employeeService.findAll()
                .stream()
                .map(this::toEmployeeDto)
                .collect(toList());
    }

    public EmployeeDto toEmployeeDto(Employee employee) {
        return EmployeeDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .surname(employee.getSurname())
                .birthday(employee.getBirthday())
                .department(BaseData.builder()
                        .id(employee.getDepartment().getId())
                        .name(employee.getDepartment().getName())
                        .build())
                .status(BaseData.builder()
                        .id(employee.getStatus().getId())
                        .name(employee.getStatus().getName())
                        .build())
                .position(BaseData.builder()
                        .id(employee.getPosition().getId())
                        .name(employee.getPosition().getName())
                        .build())
                .build();
    }
}
