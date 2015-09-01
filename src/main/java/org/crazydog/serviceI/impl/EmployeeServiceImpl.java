package org.crazydog.serviceI.impl;

import org.crazydog.daoI.Basedao;
import org.crazydog.daoI.impl.ResumedaoImpl;
import org.crazydog.domain.*;
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
@Service
public class EmployeeServiceImpl implements BaseService<EmployeeEntity> {

    @Autowired
    @Qualifier("employeedaoImpl")
    private Basedao<EmployeeEntity> employeedao;

    @Autowired
    @Qualifier("positionLeavedaoImpl")
    private Basedao<PositionLeaveEntity> positionLeavedao;

    @Autowired
    @Qualifier("positionChangedaoImpl")
    private Basedao<PositionChangeEntity> positionChangedao;

    @Autowired
    private ResumedaoImpl resumedao;

    /**
     * 获取所有的岗位更改的信息
     *
     * @return
     */
    public List<PositionChangeEntity> getAllPositionChangeEntities() {
        return positionChangedao.getAllEntities();
    }

//    /**
//     * 获取所有的离职员工信息
//     *
//     * @return
//     */
//    public List<PositionLeaveEntity> getAllPositionLeaveEntities() {
//        return positionLeavedao.getAllEntities();
//    }

    /**
     * 通过名字获得员工（抽象匹配）
     *
     * @param name
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<EmployeeEntity> getEmployeeByName(String name) {
        Map<String, Object> map = new HashMap<String, Object>(1);
        map.put("name", name);
        return (List<EmployeeEntity>) employeedao.find("from EmployeeEntity emp where emp.empName like :name", map);
    }

    /**
     * 通过员工的编码来获取信息
     *
     * @param code
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<EmployeeEntity> getEmployeeByCode(String code) {
        Map<String, Object> map = new HashMap<String, Object>(1);
        map.put("code", code);
        List<EmployeeEntity> list = (List<EmployeeEntity>) employeedao.find("from EmployeeEntity emp where emp.empCode like :code", map);
        if (list != null)
            return list;
        return null;
    }

//    /**
//     * 高级搜索
//     *
//     * @param model
//     * @return
//     */

//    public List<?> advanceSearch(SearchModel model) {
//        String hql = SearchModel.advanceSearch(model);
//        return employeedao.find(hql);
//    }

    /**
     * 给某个录取的人员简历档案
     *
     * @param resumeId 简历id
     * @param unitId   分配的单位id
     * @param deptId   分配的部门id
     * @param code     分配的员工编号
     */
    public void buildEmployee(int resumeId, int unitId, int deptId, String code) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        //设置员工的单位
        UnitEntity unitEntity = new UnitEntity();
        unitEntity.setId(unitId);
        employeeEntity.setUnitEntity(unitEntity);
        //设置员工的部门
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setId(deptId);
        employeeEntity.setDepartmentEntity(departmentEntity);
        //设置员工编码
        employeeEntity.setEmpCode(code);

        //将简历中的信息转到人事表
        //可以通过一个hql或者sql语句来进行操作，但是这里是面向对象的程序
        ResumeEntity resumeEntity = resumedao.getEntity(resumeId);
        employeeEntity.setZzmm(resumeEntity.getZzmm());
        employeeEntity.setHyzk(resumeEntity.getHyzk());
        employeeEntity.setAddress(resumeEntity.getAddress());
        employeeEntity.setEducation(resumeEntity.getEducation());
        employeeEntity.setBirthday(resumeEntity.getBirthday());
        employeeEntity.setEmail(resumeEntity.getEmail());
        employeeEntity.setEmpName(resumeEntity.getName());
        employeeEntity.setForeignLang(resumeEntity.getForeignLang());
        employeeEntity.setGender(resumeEntity.getGender());
        employeeEntity.setHeight(resumeEntity.getHeight());
        employeeEntity.setHomePhone(resumeEntity.getHomePhone());
        employeeEntity.setHukou(resumeEntity.getHukou());
        employeeEntity.setHukouAddress(resumeEntity.getHukouAddress());
        employeeEntity.setIdNum(resumeEntity.getIdNum());
        employeeEntity.setNation(resumeEntity.getNation());
        employeeEntity.setTel(resumeEntity.getTel());
        employeeEntity.setJjsp(resumeEntity.getJjsp());
        employeeEntity.setProfession(resumeEntity.getProfession());
        employeeEntity.setZipCode(resumeEntity.getZipCode());
        employeeEntity.setHomeTown(resumeEntity.getHomeTown());
        employeeEntity.setSpecialty(resumeEntity.getSpecialty());
        employeeEntity.setJndj(resumeEntity.getJndj());

        addEntity(employeeEntity);
        //建档完成之后删去这个简历
        resumedao.deleteEntity(resumeEntity);
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

    /**
     * 默认一页显示5条记录
     */
    private int pageNum = 5;

    @SuppressWarnings("unchecked")
    public List<EmployeeEntity> getEmployeeByPage(int page) {
        String hql = "from EmployeeEntity emp"; // left join emp.unitEntity unit left join emp.departmentEntity depart left join emp.contractEntity cont";
        return (List<EmployeeEntity>) employeedao.find(hql, page, pageNum);
    }

    /**
     * 计算总的记录数，用于分页
     *
     * @return 记录条数
     */
    public int maxPageNum() {
        String sql = "select count(*)  from  EmployeeEntity";
        int count = ((Long) employeedao.find(sql).iterator().next()).intValue();
        return count / pageNum + 1;
    }
}
