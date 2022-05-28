package com.evl.employeeaccounting.managers.status;

import com.evl.employeeaccounting.controllers.dto.BaseData;
import com.evl.employeeaccounting.entityes.EmployeeStatus;
import org.springframework.transaction.annotation.Transactional;

public interface IStatusManager {
    BaseData toBaseData(EmployeeStatus status);

    EmployeeStatus save(String name);

    EmployeeStatus update(Long id, String name);

    @Transactional
    void deleteById(Long id);
}
