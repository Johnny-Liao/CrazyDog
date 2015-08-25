package org.crazydog.daoI;

import org.crazydog.domain.EmployeeEntity;

import java.util.List;

/**
 * 对人员信息实体进行操作
 * Created by never on 2015/8/23.
 */
public interface EmployeedaoI {
    /**
     * 增加人员
     *
     * @param entity 人员员工信息
     */
    void addEmployee(EmployeeEntity entity);

    /**
     * 修改人员
     *
     * @param entity 人员员工信息
     */
    void modifyEmployee(EmployeeEntity entity);

    /**
     * 删除人员
     *
     * @param id 人员的id
     */
    void deleteEmployee(int id);

    /**
     * 获取指定的人员
     *
     * @param id 人员的id
     * @return
     */
    EmployeeEntity getEmployee(int id);


    /**
     * 根据姓名模糊查询人员
     * @param name
     * @return
     */
    List<EmployeeEntity> getEmployeeByName(String name);

    /**
     * 获取所有的人员
     *
     * @return
     */
    List<EmployeeEntity> getAllEmployees();
}