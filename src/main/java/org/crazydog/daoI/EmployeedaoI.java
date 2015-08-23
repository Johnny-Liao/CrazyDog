package org.crazydog.daoI;

import org.crazydog.domain.EmployeeEntity;

import java.util.List;

/**
 * Created by never on 2015/8/23.
 */
public interface EmployeedaoI {
    /**
     * 增加员工
     *
     * @param entity 员工信息
     */
    void addEmployee(EmployeeEntity entity);

    /**
     * 修改员工
     *
     * @param entity 修改员工信息
     */
    void modifyEmployee(EmployeeEntity entity);

    /**
     * 根据员工id删除员工
     *
     * @param id 员工的id
     */
    void deleteEmployee(int id);

    /**
     * 获取指定的员工
     *
     * @param id 员工的id
     * @return
     */
    EmployeeEntity getEmployee(int id);

    /**
     * 获取所有的员工
     *
     * @return
     */
    List<EmployeeEntity> getAllEmployees();
}
