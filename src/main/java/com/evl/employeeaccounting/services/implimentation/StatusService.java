package com.evl.employeeaccounting.services.implimentation;

import com.evl.employeeaccounting.entityes.EmployeeStatus;
import com.evl.employeeaccounting.repositories.StatusRepository;
import com.evl.employeeaccounting.services.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StatusService extends AbstractService<EmployeeStatus, StatusRepository> {

    public StatusService(StatusRepository repository) {
        super(repository);
    }
}
