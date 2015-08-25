package org.crazydog.serviceI.impl;

import org.crazydog.daoI.DepartmentdaoI;
import org.crazydog.daoI.UnitdaoI;
import org.crazydog.domain.DepartmentEntity;
import org.crazydog.domain.UnitEntity;
import org.crazydog.serviceI.UnitServiceI;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by never on 2015/8/24.
 */
//@Service
public class UnitServiceImpl implements UnitServiceI {

    @Autowired
    private UnitdaoI unitdao;

    @Autowired
    private DepartmentdaoI departmentdao;

    public void addUnit(UnitEntity entity) {
        unitdao.addUnit(entity);
    }

    public void modifyUnit(UnitEntity entity) {
        unitdao.modifyUnit(entity);
    }

    public void deleteUnit(int id) {
        UnitEntity entity = new UnitEntity();
        entity.setId(id);
        unitdao.deleteUnit(entity);
    }

    public UnitEntity getUnit(int id) {
        return unitdao.getUnit(id);
    }

    public List<UnitEntity> getAllUnits() {
        return unitdao.getAllUnits();
    }

    public void addDepartments(List<DepartmentEntity> departmentEntities) {
        if (departmentEntities != null && departmentEntities.size() != 0)
            departmentdao.addDepartments(departmentEntities);
    }
}
