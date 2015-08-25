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
     * 添加部门实体
     * 注意添加部门的时候，必须指定部门所属单位
     *
     * @param departmentEntity 部门实体对象（不能为空）
     */
    @Override
    public void addEntity(DepartmentEntity departmentEntity) {
        hibernateTemplate.save(departmentEntity);
    }

    /**
     * 一次添加多个单位下的部门实例
     * 默认将设置所有的部门为该单位下属
     * 不管你是否设置单位和部门的联系，这里都会添加他们之间的联系
     *
     * @param departmentEntities List列表（不能为空）
     */
    public void addEntities(UnitEntity unitEntity, List<DepartmentEntity> departmentEntities) {
        for (DepartmentEntity departmentEntity : departmentEntities) {
            departmentEntity.setUnitByUnitId(unitEntity);
            addEntity(departmentEntity);
        }
    }

    /**
     * 修改部门实体
     *
     * @param departmentEntity 部门实体对象（不能为空）
     */
    @Override
    public void modifyEntity(DepartmentEntity departmentEntity) {
        hibernateTemplate.update(departmentEntity);
    }

    /**
     * load具有懒加载效果，获得部门实体类
     *
     * @param id 部门实体对象的id
     * @return
     */
    @Override
    public DepartmentEntity loadEntity(int id) {
        return hibernateTemplate.load(DepartmentEntity.class, id);
    }

    /**
     * 获得部门实体类
     *
     * @param id 部门实体对象的id
     * @return
     */
    @Override
    public DepartmentEntity getEntity(int id) {
        return hibernateTemplate.get(DepartmentEntity.class, id);
    }

    /**
     * 获得所有的部门实体类
     *
     * @return
     */
    @Override
    public List<DepartmentEntity> getAllEntities() {
        return hibernateTemplate.loadAll(DepartmentEntity.class);
    }

    /**
     * 删除指定的某个部门实体
     *
     * @param departmentEntity 部门实体对象
     * @return
     */
    @Override
    public void deleteEntity(DepartmentEntity departmentEntity) {
        hibernateTemplate.delete(departmentEntity);
    }

    /**
     * @param unitEntity 服务单位（不能为空）
     * @return
     */
    public List<DepartmentEntity> getAllDepartmentEntity(UnitEntity unitEntity) {
        List<DepartmentEntity> departmentEntities = (List<DepartmentEntity>) hibernateTemplate.findByNamedParam("from DepartmentEntity dept where dept.unitByUnitId=:id", "id", unitEntity);
        return departmentEntities;
    }

}
