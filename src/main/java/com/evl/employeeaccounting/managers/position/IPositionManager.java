package com.evl.employeeaccounting.managers.position;

import com.evl.employeeaccounting.controllers.dto.BaseData;
import com.evl.employeeaccounting.entityes.Position;

import java.util.List;

public interface IPositionManager {

    List<BaseData> findAllDto ();

    BaseData toBaseData (Position position);

    Position save (String name);

    Position update (Long id, String name);

    void deleteById (Long id);
}
