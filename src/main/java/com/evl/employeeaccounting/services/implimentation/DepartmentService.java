package com.evl.employeeaccounting.services.implimentation;

import com.evl.employeeaccounting.entityes.Department;
import com.evl.employeeaccounting.repositories.DepartmentRepository;
import com.evl.employeeaccounting.services.AbstractService;

public class DepartmentService extends AbstractService<Department, DepartmentRepository> {

    public DepartmentService(DepartmentRepository repository) {
        super(repository);
    }
}
