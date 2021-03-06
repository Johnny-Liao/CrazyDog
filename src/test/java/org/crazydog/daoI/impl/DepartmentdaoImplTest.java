package org.crazydog.daoI.impl;

import org.crazydog.domain.DepartmentEntity;
import org.crazydog.domain.UnitEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by never on 2015/8/25.
 */
public class DepartmentdaoImplTest {

    ApplicationContext applicationContext;

    DepartmentdaoImpl departmentdao;

    @Before
    public void before() {
        applicationContext = new ClassPathXmlApplicationContext("test-application-config.xml");
        departmentdao = (DepartmentdaoImpl) applicationContext.getBean("departmentdaoImpl");
    }

    @Test
    public void testAddDepartment() throws Exception {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setDeptName("傻逼");
        UnitEntity unitEntity = new UnitEntity();
        unitEntity.setId(1);
        departmentEntity.setUnitByUnitId(unitEntity);
        departmentdao.addEntity(departmentEntity);
    }

    @Test
    public void testAddDepartments() throws Exception {
        UnitEntity unitEntity = new UnitEntity();
        unitEntity.setId(1);
        List<DepartmentEntity> departmentEntities = new ArrayList<DepartmentEntity>(2);

        DepartmentEntity departmentEntity1 = new DepartmentEntity();
        departmentEntity1.setDeptName("傻逼");
        departmentEntity1.setUnitByUnitId(unitEntity);

        DepartmentEntity departmentEntity2 = new DepartmentEntity();
        departmentEntity2.setDeptName("SB");
        departmentEntity2.setUnitByUnitId(unitEntity);

        departmentEntities.add(departmentEntity1);
        departmentEntities.add(departmentEntity2);
        departmentdao.addEntities(unitEntity, departmentEntities);
    }

    @Test
    public void testModifyDepartment() throws Exception {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setId(11);
        UnitEntity unitEntity = new UnitEntity();
        unitEntity.setId(2);
        departmentEntity.setUnitByUnitId(unitEntity);
        departmentEntity.setDeptName("333傻逼");
        departmentdao.modifyEntity(departmentEntity);
    }

    @Test
    public void testDeleteDepartment() throws Exception {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setId(10);
        UnitEntity unitEntity = new UnitEntity();
        unitEntity.setId(2);
        departmentEntity.setUnitByUnitId(unitEntity);
        departmentdao.deleteEntity(departmentEntity);
    }

    @Test
    public void testGetDepartmentEntity() throws Exception {
        DepartmentEntity departmentEntity = departmentdao.getEntity(1);
        System.out.println(departmentEntity);
    }

    @Test
    public void testGetAllDepartmentEntity() throws Exception {
        UnitEntity unitEntity = new UnitEntity();
        unitEntity.setId(1);
        List<DepartmentEntity> departmentEntities = departmentdao.getAllDepartmentEntity(unitEntity);
        for (DepartmentEntity departmentEntity : departmentEntities)
            System.out.println(departmentEntity);
    }

    @Test
    public void getDepartmentByName() {
        DepartmentEntity departmentEntity = departmentdao.getDepartmentByName("守门部");
        System.out.println(departmentEntity);
    }
}