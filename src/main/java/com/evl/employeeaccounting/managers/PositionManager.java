package com.evl.employeeaccounting.managers;

import com.evl.employeeaccounting.controllers.dto.BaseData;
import com.evl.employeeaccounting.entityes.Position;
import com.evl.employeeaccounting.exeptions.ApplicationException;
import com.evl.employeeaccounting.services.implimentation.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Component
@Transactional
@AllArgsConstructor
public class PositionManager implements IPositionManager {

    private final PositionService positionService;

    @Override
    public List<BaseData> findAllDto() {
        return positionService.findAll()
                .stream()
                .map(this::toBaseData)
                .collect(toList());
    }

    @Override
    public BaseData toBaseData(Position position) {
        return BaseData.builder()
                .id(position.getId())
                .name(position.getName())
                .build();
    }

    @Override
    public Position save(String name) {
        return positionService.save(
                Position.builder()
                        .name(name)
                        .build());
    }

    @Override
    public Position update(Long id, String name) {
        Optional<Position> positionOptional = positionService.findById(id);
        if (positionOptional.isPresent()) {
            Position position = positionOptional.get();
            position.setName(name);
            return positionService.save(position);
        } else {
            throw new ApplicationException(500, "Позиция с id " + id + " ненайдена");
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        positionService.deleteById(id);
    }
}
