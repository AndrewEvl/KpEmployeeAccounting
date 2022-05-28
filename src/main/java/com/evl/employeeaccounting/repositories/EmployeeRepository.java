package com.evl.employeeaccounting.repositories;

import com.evl.employeeaccounting.entityes.Employee;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends AbstractRepository<Employee> {

    List<Employee> findAllByPositionId (@Param("id") Long positionId);

}
