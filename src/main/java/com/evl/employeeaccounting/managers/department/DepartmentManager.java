package com.evl.employeeaccounting.managers.department;

import com.evl.employeeaccounting.controllers.dto.BaseData;
import com.evl.employeeaccounting.entityes.Department;
import com.evl.employeeaccounting.entityes.Employee;
import com.evl.employeeaccounting.exeptions.ApplicationException;
import com.evl.employeeaccounting.services.implimentation.DepartmentService;
import com.evl.employeeaccounting.services.implimentation.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Component
@Transactional
@AllArgsConstructor
public class DepartmentManager implements IDepartmentManager {

    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    @Override
    public List<BaseData> findAllDto() {
        return departmentService.findAll()
                .stream()
                .map(this::toBaseData)
                .collect(toList());
    }

    @Override
    public BaseData toBaseData(Department position) {
        return BaseData.builder()
                .id(position.getId())
                .name(position.getName())
                .build();
    }

    @Override
    public Department save(String name) {
        return departmentService.save(
                Department.builder()
                        .name(name)
                        .build());
    }

    @Override
    public Department update(Long id, String name) {
        Optional<Department> departmentOptional = departmentService.findById(id);
        if (departmentOptional.isPresent()) {
            Department department = departmentOptional.get();
            department.setName(name);
            return departmentService.save(department);
        } else {
            throw new ApplicationException(500, "Дупартамент с id " + id + " ненайдена");
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        List<Employee> employeeList = employeeService.findByPositionId(id);
        if (employeeList.isEmpty()) {
            departmentService.deleteById(id);
        } else {
            throw new ApplicationException(500, "К департаменту привязанны сотрудники");
        }
    }
}
