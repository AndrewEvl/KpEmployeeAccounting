package com.evl.employeeaccounting.managers.status;

import com.evl.employeeaccounting.controllers.dto.BaseData;
import com.evl.employeeaccounting.entityes.Employee;
import com.evl.employeeaccounting.entityes.EmployeeStatus;
import com.evl.employeeaccounting.exeptions.ApplicationException;
import com.evl.employeeaccounting.services.implimentation.EmployeeService;
import com.evl.employeeaccounting.services.implimentation.StatusService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Component
@Transactional
@AllArgsConstructor
public class StatusManager implements IStatusManager{

    private final StatusService statusService;
    private final EmployeeService employeeService;

    public List<BaseData> findAllDto() {
        return statusService.findAll()
                .stream()
                .map(this::toBaseData)
                .collect(toList());
    }

    @Override
    public BaseData toBaseData(EmployeeStatus status) {
        return BaseData.builder()
                .id(status.getId())
                .name(status.getName())
                .build();
    }

    @Override
    public EmployeeStatus save(String name) {
        return statusService.save(
                EmployeeStatus.builder()
                        .name(name)
                        .build());
    }

    @Override
    public EmployeeStatus update(Long id, String name) {
        Optional<EmployeeStatus> statusOptional = statusService.findById(id);
        if (statusOptional.isPresent()) {
            EmployeeStatus status = statusOptional.get();
            status.setName(name);
            return statusService.save(status);
        } else {
            throw new ApplicationException(500, "Позиция с id " + id + " ненайдена");
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        List<Employee> employeeList = employeeService.findByPositionId(id);
        if (employeeList.isEmpty()) {
            statusService.deleteById(id);
        } else {
            throw new ApplicationException(500, "К должности привязанны сотрудники");
        }
    }
}
