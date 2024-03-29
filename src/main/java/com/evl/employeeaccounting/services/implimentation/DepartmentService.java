package com.evl.employeeaccounting.services.implimentation;

import com.evl.employeeaccounting.entityes.Department;
import com.evl.employeeaccounting.repositories.DepartmentRepository;
import com.evl.employeeaccounting.services.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DepartmentService extends AbstractService<Department, DepartmentRepository> {

    public DepartmentService(DepartmentRepository repository) {
        super(repository);
    }
}
