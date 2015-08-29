package org.crazydog.daoI.impl;

import org.crazydog.daoI.Basedao;
import org.crazydog.domain.DepartmentEntity;
import org.crazydog.domain.EmployeeEntity;
import org.crazydog.domain.UnitEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by never on 2015/8/23.
 */
@Component
public class EmployeedaoImpl extends Basedao<EmployeeEntity> {

    /**
     * 添加实体
     *
     * @param employeeEntity 实体对象
     */
    @Override
    public void addEntity(EmployeeEntity employeeEntity) {
        hibernateTemplate.save(employeeEntity);
    }

    /**
     * 修改实体
     *
     * @param employeeEntity 实体对象
     */
    @Override
    public void modifyEntity(EmployeeEntity employeeEntity) {
        hibernateTemplate.update(employeeEntity);
    }

    /**
     * load具有懒加载效果，获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    @Override
    public EmployeeEntity loadEntity(int id) {
        return hibernateTemplate.load(EmployeeEntity.class, id);
    }

    /**
     * 获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    @Override
    public EmployeeEntity getEntity(int id) {
        return hibernateTemplate.get(EmployeeEntity.class, id);
    }

    /**
     * 获得所有的实体类
     * <p>
     * 注意这里获得的所有实体在底层关闭了延迟加载，所以会导致所有的字段都取出来
     * 所以他的所有外键都为非空
     *
     * @return
     */
    @Override
    public List<EmployeeEntity> getAllEntities() {
        return hibernateTemplate.loadAll(EmployeeEntity.class);
    }

    /**
     * 删除指定的某个实体
     *
     * @param employeeEntity 实体对象的id
     * @return
     */
    @Override
    public void deleteEntity(EmployeeEntity employeeEntity) {
        hibernateTemplate.delete(employeeEntity);
    }

    /**
     * 通过employee获取到employee显示页面所需要的所有信息
     * @param employeeEntity
     */

    public void getAllEmployeeMessage(EmployeeEntity employeeEntity) {
        String hql =  "from EmployeeEntity left join DepartmentEntity left join UnitEntity";
    }
}
