package org.crazydog.serviceI.impl;

import org.crazydog.daoI.Basedao;
import org.crazydog.daoI.impl.DepartmentdaoImpl;
import org.crazydog.domain.DepartmentEntity;
import org.crazydog.domain.UnitEntity;
import org.crazydog.serviceI.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by never on 2015/8/24.
 */
@Service
public class UnitServiceImpl implements BaseService<UnitEntity> {

    @Autowired
    @Qualifier("unitdaoImpl")
    private Basedao unitdao;

    @Autowired
    @Qualifier("departmentdaoImpl")
    private DepartmentdaoImpl departmentdao;

    /**
     * 通过服务单位名称查询
     * 理论上来说单位的名字应该不会重复，所以大多数情况下应该只有一个实例，
     * 但是以防万一还是返回一个list
     *
     * @param name 服务单位的名字
     * @return
     */
    public List<UnitEntity> getUnitByName(String name) {

        return null;
    }

    /**
     * 通过服务单位编码查询
     *
     * @param code 服务单位的编码
     * @return
     */
    public UnitEntity getUnitByCode(String code) {
        return null;
    }


    /**
     * 一次添加多个部门
     *
     * @param unitEntity         部门所属的单位
     * @param departmentEntities 所有的部门
     */
    public void addDepartments(UnitEntity unitEntity, List<DepartmentEntity> departmentEntities) {
        if (departmentEntities != null && departmentEntities.size() != 0)
            departmentdao.addEntities(unitEntity, departmentEntities);
    }

    /**
     * 添加服务单位
     *
     * @param entity 服务单位对象
     */
    public void addEntity(UnitEntity entity) {
        unitdao.addEntity(entity);
    }

    /**
     * 修改服务单位
     *
     * @param entity 服务单位对象
     */
    public void modifyEntity(UnitEntity entity) {
        unitdao.modifyEntity(entity);
    }

    /**
     * load具有懒加载效果，获得服务单位类
     *
     * @param id 服务单位对象的id
     * @return
     */
    public UnitEntity loadEntity(int id) {
        return (UnitEntity) unitdao.loadEntity(id);
    }

    /**
     * 获得服务单位类
     *
     * @param id 服务单位对象的id
     * @return
     */
    public UnitEntity getEntity(int id) {
        return (UnitEntity) unitdao.getEntity(id);
    }

    /**
     * 获得所有的服务单位类
     *
     * @return
     */
    public List<UnitEntity> getAllEntities() {
        return unitdao.getAllEntities();
    }

    /**
     * 删除指定的某个服务单位
     * 注意这里具有级联效果（会删除该单位下属的所有部门），所以小心操作
     *
     * @param entity 服务单位对象
     * @return
     */
    public void deleteEntity(UnitEntity entity) {
        unitdao.deleteEntity(entity);
    }
}
