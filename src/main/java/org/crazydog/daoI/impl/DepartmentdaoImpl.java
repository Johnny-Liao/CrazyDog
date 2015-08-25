package org.crazydog.daoI.impl;

import org.crazydog.daoI.Basedao;
import org.crazydog.domain.DepartmentEntity;
import org.crazydog.domain.UnitEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by never on 2015/8/25.
 */
@Component
public class DepartmentdaoImpl extends Basedao<DepartmentEntity> {
    /**
     * 添加实体
     *
     * @param departmentEntity 实体对象（不能为空）
     */
    @Override
    public void addEntity(DepartmentEntity departmentEntity) {
        hibernateTemplate.save(departmentEntity);
    }

    /**
     * 修改实体
     *
     * @param departmentEntity 实体对象（不能为空）
     */
    @Override
    public void modifyEntity(DepartmentEntity departmentEntity) {
        hibernateTemplate.update(departmentEntity);
    }

    /**
     * load具有懒加载效果，获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    @Override
    public DepartmentEntity loadEntity(int id) {
        return hibernateTemplate.load(DepartmentEntity.class, id);
    }

    /**
     * 获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    @Override
    public DepartmentEntity getEntity(int id) {
        return hibernateTemplate.get(DepartmentEntity.class, id);
    }

    /**
     * 获得所有的实体类
     *
     * @return
     */
    @Override
    public List<DepartmentEntity> getAllEntities() {
        return hibernateTemplate.loadAll(DepartmentEntity.class);
    }

    /**
     * @param unitEntity 服务单位（不能为空）
     * @return
     */
    public List<DepartmentEntity> getAllDepartmentEntity(UnitEntity unitEntity) {
        List<DepartmentEntity> departmentEntities = (List<DepartmentEntity>) hibernateTemplate.findByNamedParam("from DepartmentEntity dept where dept.unitByUnitId=:id", "id", unitEntity);
        return departmentEntities;
    }

    /**
     * 删除指定的某个实体
     *
     * @param id 实体对象的id
     * @return
     */
    @Override
    public void deleteEntity(int id) {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setId(id);
        hibernateTemplate.delete(departmentEntity);
    }
}
