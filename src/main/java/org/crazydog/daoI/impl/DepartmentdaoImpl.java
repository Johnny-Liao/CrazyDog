package org.crazydog.daoI.impl;

import org.crazydog.daoI.DepartmentdaoI;
import org.crazydog.domain.DepartmentEntity;
import org.crazydog.domain.UnitEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by never on 2015/8/24.
 */
@Component
public class DepartmentdaoImpl implements DepartmentdaoI {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    /**
     * @param departmentEntity 部门
     */
    public void addDepartment(DepartmentEntity departmentEntity) {
        hibernateTemplate.save(departmentEntity);
    }

    /**
     * @param departmentEntities 部门
     */
    public void addDepartments(List<DepartmentEntity> departmentEntities) {
        for (DepartmentEntity departmentEntity : departmentEntities)
            addDepartment(departmentEntity);
    }

    /**
     * @param departmentEntity 部门
     */
    public void modifyDepartment(DepartmentEntity departmentEntity) {
        hibernateTemplate.update(departmentEntity);
    }

    /**
     * @param departmentEntity 部门id
     */
    public void deleteDepartment(DepartmentEntity departmentEntity) {
        hibernateTemplate.delete(departmentEntity);
    }

    /**
     * 根据部门的id来获取部门信息
     * 存在延迟加载现象
     *
     * @param id 部门id
     * @return
     */
    public DepartmentEntity loadDepartmentEntity(int id) {
        return hibernateTemplate.load(DepartmentEntity.class, id);
    }

    /**
     * 根据部门的id来获取部门信息
     *
     * @param id 部门id
     * @return
     */
    public DepartmentEntity getDepartmentEntity(int id) {
        return hibernateTemplate.get(DepartmentEntity.class, id);
    }

    /**
     * @param unitEntity 服务单位
     * @return
     */
    public List<DepartmentEntity> getAllDepartmentEntity(UnitEntity unitEntity) {
        List<DepartmentEntity> departmentEntities = (List<DepartmentEntity>) hibernateTemplate.find("from DepartmentEntity where DepartmentEntity.unitByUnitId=?", unitEntity.getId());
        return departmentEntities;
    }
}
