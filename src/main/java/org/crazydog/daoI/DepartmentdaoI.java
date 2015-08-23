package org.crazydog.daoI;

import org.crazydog.domain.DepartmentEntity;
import org.crazydog.domain.UnitEntity;

import java.util.List;

/**
 * Created by never on 2015/8/23.
 */
public interface DepartmentdaoI {
    /**
     * 增加部门
     *
     * @param departmentEntity 部门
     */
    void addDepartment(DepartmentEntity departmentEntity);

    /**
     * 修改部门
     *
     * @param departmentEntity 部门
     */
    void modifyDepartment(DepartmentEntity departmentEntity);

    /**
     * 删除部门
     *
     * @param id 部门id
     */
    void deleteDepartment(int id);

    /**
     * 根据部门的id来获取部门信息
     *
     * @param id 部门id
     * @return
     */
    DepartmentEntity getDepartmentEntity(int id);

    /**
     * 根据服务单位获取其所有的部门信息
     *
     * @param unitEntity 服务单位
     * @return
     */
    List<DepartmentEntity> getAllDepartmentEntity(UnitEntity unitEntity);
}
