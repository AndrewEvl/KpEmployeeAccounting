package com.evl.employeeaccounting.services.implimentation;

import com.evl.employeeaccounting.entityes.Employee;
import com.evl.employeeaccounting.repositories.EmployeeRepository;
import com.evl.employeeaccounting.services.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class EmployeeService extends AbstractService<Employee, EmployeeRepository> {

    public EmployeeService(EmployeeRepository repository) {
        super(repository);
    }

    public List<Employee> findByPositionId (Long positionId){
       return repository.findAllByPositionId(positionId)
               .stream()
               .sorted(Comparator.comparing(Employee::getLastName))
               .toList();
    }

}
