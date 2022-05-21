package com.evl.employeeaccounting.services.implimentation;

import com.evl.employeeaccounting.entityes.Employee;
import com.evl.employeeaccounting.repositories.EmployeeRepository;
import com.evl.employeeaccounting.services.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EmployeeService extends AbstractService<Employee, EmployeeRepository> {

    public EmployeeService(EmployeeRepository repository) {
        super(repository);
    }

}
