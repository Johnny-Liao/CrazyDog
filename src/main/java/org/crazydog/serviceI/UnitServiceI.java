<<<<<<< HEAD
package org.crazydog.serviceI;

import org.crazydog.domain.UnitEntity;

import java.util.List;

/**
 * 本接口定义了对服务单位进行的操作
 * Created by never on 2015/8/23.
 */
public interface UnitServiceI {
    /**
     * 增加服务单位
     *
     * @param entity 服务单位实例
     */
    void addUnit(UnitEntity entity);

    /**
     * 修改服务单位
     *
     * @param entity 服务单位实例
     */
    void modifyUnit(UnitEntity entity);

    /**
     * 删除服务单位
     *
     * @param id 服务单位的id
     */
    void deleteUnit(int id);

    /**
     * 获取指定的服务单位
     *
     * @param id 服务单位的id
     * @return
     */
    UnitEntity getUnit(int id);

    /**
     * 获取所有的服务单位
     *
     * @return
     */
    List<UnitEntity> getAllUnits();
}
=======
package org.crazydog.serviceI;

import org.crazydog.domain.DepartmentEntity;
import org.crazydog.domain.UnitEntity;

import java.util.List;

/**
 * 本接口定义了对服务单位进行的操作
 * Created by never on 2015/8/23.
 */
public interface UnitServiceI {
    /**
     * 增加服务单位
     *
     * @param entity 服务单位实例
     */
    void addUnit(UnitEntity entity);

    /**
     * 修改服务单位
     *
     * @param entity 服务单位实例
     */
    void modifyUnit(UnitEntity entity);

    /**
     * 删除服务单位
     *
     * @param id 服务单位的id
     */
    void deleteUnit(int id);

    /**
     * 获取指定的服务单位
     *
     * @param id 服务单位的id
     * @return
     */
    UnitEntity getUnit(int id);

    /**
     * 获取所有的服务单位
     *
     * @return
     */
    List<UnitEntity> getAllUnits();

    /**
     * 向服务单位一次添加多个部门
     *
     * @param departmentEntities 部门集合
     */
    void addDepartments(List<DepartmentEntity> departmentEntities);
}
>>>>>>> bcd33826cccc6660b1d060c59ac9e26753337c6e
