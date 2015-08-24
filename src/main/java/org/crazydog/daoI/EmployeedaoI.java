package org.crazydog.daoI;

import org.crazydog.domain.EmployeeEntity;

import java.util.List;

/**
 * Created by never on 2015/8/23.
 */
public interface EmployeedaoI {
    /**
     * 增加简历
     *
     * @param entity 简历员工信息
     */
    void addEmployee(EmployeeEntity entity);

    /**
     * 修改简历
     *
     * @param entity 简历员工信息
     */
    void modifyEmployee(EmployeeEntity entity);

    /**
     * 删除简历
     *
     * @param id 简历的id
     */
    void deleteEmployee(int id);

    /**
     * 获取指定的简历
     *
     * @param id 简历的id
     * @return
     */
    EmployeeEntity getEmployee(int id);

    /**
     * 获取所有的简历
     *
     * @return
     */
    List<EmployeeEntity> getAllEmployees();
}