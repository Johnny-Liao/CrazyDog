package org.crazydog.serviceI.impl;

import org.crazydog.daoI.DepartmentdaoI;
import org.crazydog.daoI.UnitdaoI;
import org.crazydog.domain.DepartmentEntity;
import org.crazydog.domain.UnitEntity;
import org.crazydog.serviceI.UnitServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by never on 2015/8/24.
 */
@Service
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

    public UnitEntity loadUnit(int id) {
        return unitdao.loadUnit(id);
    }

    /**
     * 获取指定的服务单位
     *
     * @param id 服务单位的id
     * @return
     */
    public UnitEntity getUnit(int id) {
        return unitdao.getUnit(id);
    }

    /**
     * 通过服务单位名称查询
     *
     * @param name 服务单位的名字
     * @return
     */
    public UnitEntity getUnitByName(String name) {

        return null;
    }

    /**
     * 通过服务单位编码查询
     *
     * @param code 服务单位的编码
     * @return
     */
    public UnitEntity getUnitByCode(String code) {
        return null;
    }

    public List<UnitEntity> getAllUnits() {
        return unitdao.getAllUnits();
    }

    public void addDepartments(List<DepartmentEntity> departmentEntities) {
        if (departmentEntities != null && departmentEntities.size() != 0)
            departmentdao.addDepartments(departmentEntities);
    }
}
