package com.evl.employeeaccounting.services.implimentation;

import com.evl.employeeaccounting.entityes.Position;
import com.evl.employeeaccounting.repositories.PositionRepository;
import com.evl.employeeaccounting.services.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PositionService extends AbstractService<Position, PositionRepository> {

    public PositionService(PositionRepository repository) {
        super(repository);
    }

}
