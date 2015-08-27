package org.crazydog.serviceI.impl;

import org.crazydog.daoI.Basedao;
import org.crazydog.domain.EmployeeEntity;
import org.crazydog.serviceI.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by never on 2015/8/26.
 */
@Service("employeeService")
public class EmployeeServiceImpl implements BaseService<EmployeeEntity> {

    @Autowired
    @Qualifier("employeedaoImpl")
    private Basedao<EmployeeEntity> employeedao;


    /**
     * 通过名字获得员工（抽象匹配）
     *
     * @param name
     * @return
     */
    public List<EmployeeEntity> getEmployeeByName(String name) {
        Map<String, Object> map = new HashMap<String, Object>(1);
        map.put("name", name);
        return employeedao.find("from EmployeeEntity emp where emp.empName like :name", map);
    }

    /**
     * 通过员工的编码来获取信息
     *
     * @param code
     * @return
     */
    public EmployeeEntity getEmployeeByCode(String code) {
        Map<String, Object> map = new HashMap<String, Object>(1);
        map.put("code", code);
        List<EmployeeEntity> list = employeedao.find("from EmployeeEntity emp where emp.empCode like :code", map);
        if (list != null && list.size() == 1)
            return list.get(0);
        return null;
    }

    /**
     * 高级搜索
     *
     * @param model
     * @return
     */
    public List<EmployeeEntity> advanceSearch(SearchModel model) {
        String hql = model.advanceSearch();
        return employeedao.find(hql);
    }

    /**
     * 添加实体
     *
     * @param employeeEntity 实体对象
     */
    public void addEntity(EmployeeEntity employeeEntity) {
        employeedao.addEntity(employeeEntity);
    }

    /**
     * 修改实体
     *
     * @param employeeEntity 实体对象
     */
    public void modifyEntity(EmployeeEntity employeeEntity) {
        employeedao.modifyEntity(employeeEntity);
    }

    /**
     * load具有懒加载效果，获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    public EmployeeEntity loadEntity(int id) {
        return employeedao.loadEntity(id);
    }

    /**
     * 获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    public EmployeeEntity getEntity(int id) {
        return employeedao.getEntity(id);
    }

    /**
     * 获得所有的实体类
     * <p>
     * 注意这里获得的所有实体在底层关闭了延迟加载，所以会导致所有的字段都取出来
     * 所以他的所有外键都为非空
     *
     * @return
     */
    public List<EmployeeEntity> getAllEntities() {
        return employeedao.getAllEntities();
    }

    /**
     * 删除指定的某个实体
     *
     * @param employeeEntity 实体对象
     * @return
     */
    public void deleteEntity(EmployeeEntity employeeEntity) {
        employeedao.deleteEntity(employeeEntity);
    }
}
