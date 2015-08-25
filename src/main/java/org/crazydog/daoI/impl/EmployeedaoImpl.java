package org.crazydog.daoI.impl;

import org.crazydog.daoI.Basedao;
import org.crazydog.domain.EmployeeEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Johnny on 2015/8/23.
 */
@Component
public class EmployeedaoImpl extends Basedao<EmployeeEntity> {

    /**
     * 通过名字获得员工（抽象匹配）
     *
     * @param name
     * @return
     */
    public List<EmployeeEntity> getEmployeeByName(String name) {
        Map<String, Object> map = new HashMap<String, Object>(1);
        map.put("name", name);
        return find("from employeeEntity where employeeEntity.emp_name like :name", map);
    }

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
}
