package org.crazydog.serviceI;

import org.crazydog.domain.EmployeeEntity;

import java.util.List;

/**
 * 人员管理服务层接口
 * Created by John on 2015/8/25.
 */
public interface EmployeeServiceI {

    EmployeeEntity getEmployeeById(int id);

    EmployeeEntity getEmployeeByName(String name);

    List<EmployeeEntity> getAllEmployee();

}
