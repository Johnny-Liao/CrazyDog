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

    public void addDepartment(DepartmentEntity departmentEntity) {
        hibernateTemplate.save(departmentEntity);
    }

    public void addDepartments(List<DepartmentEntity> departmentEntities) {
        for (DepartmentEntity departmentEntity : departmentEntities)
            addDepartment(departmentEntity);
    }

    public void modifyDepartment(DepartmentEntity departmentEntity) {
        hibernateTemplate.update(departmentEntity);
    }

    public void deleteDepartment(DepartmentEntity departmentEntity) {
        hibernateTemplate.delete(departmentEntity);
    }

    public DepartmentEntity getDepartmentEntity(int id) {
        return hibernateTemplate.load(DepartmentEntity.class, id);
    }

    public List<DepartmentEntity> getAllDepartmentEntity(UnitEntity unitEntity) {
        List<DepartmentEntity> departmentEntities = (List<DepartmentEntity>) hibernateTemplate.find("from DepartmentEntity where DepartmentEntity.unitByUnitId=?", unitEntity.getId());
        return departmentEntities;
    }
}
