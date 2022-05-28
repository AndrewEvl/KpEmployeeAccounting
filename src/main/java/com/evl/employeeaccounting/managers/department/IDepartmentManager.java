package com.evl.employeeaccounting.managers.department;

import com.evl.employeeaccounting.controllers.dto.BaseData;
import com.evl.employeeaccounting.entityes.Department;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IDepartmentManager {
    List<BaseData> findAllDto();

    BaseData toBaseData(Department position);

    Department save(String name);

    Department update(Long id, String name);

    @Transactional
    void deleteById(Long id);
}
