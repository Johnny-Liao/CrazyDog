package org.crazydog.daoI.impl;

import org.crazydog.daoI.Basedao;
import org.crazydog.domain.DepartmentEntity;
import org.crazydog.domain.EmployeeEntity;
import org.crazydog.domain.UnitEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by never on 2015/8/25.
 */
public class EmployeedaoImplTest {
    ApplicationContext applicationContext;

    Basedao<EmployeeEntity> employeedaoImpl;

    @Before
    public void before() {
        applicationContext = new ClassPathXmlApplicationContext("test-application-config.xml");
        employeedaoImpl = (Basedao) applicationContext.getBean("employeedaoImpl");
    }

    @Test
    public void testGetEmployeeByName() throws Exception {

    }

    @Test
    public void testAddEntity() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmpCode("zy");
        employeeEntity.setEmpName("邹杨");
        employeeEntity.setGender("男");
        employeeEntity.setIdNum("421111111111111111");
        employeeEntity.setNation("汉族");
        employeeEntity.setTel(11111111111L);
        employeeEntity.setEmail("1360000@qq.com");

        UnitEntity unitEntity = new UnitEntity();
        unitEntity.setId(1);
        employeeEntity.setUnitEntity(unitEntity);

        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setId(1);
        employeeEntity.setDepartmentEntity(departmentEntity);

        employeeEntity.setHyzk("未婚");
        employeeEntity.setZzmm("群众");

        employeedaoImpl.addEntity(employeeEntity);
        System.out.println(employeeEntity);
    }

    @Test
    public void testModifyEntity() throws Exception {

    }

    @Test
    public void testLoadEntity() throws Exception {

    }

    @Test
    public void testGetEntity() throws Exception {

    }

    @Test
    public void testGetAllEntities() throws Exception {
        List<EmployeeEntity> employeeEntities = employeedaoImpl.getAllEntities();
        for (EmployeeEntity employeeEntity : employeeEntities)
            System.out.println(employeeEntity);
    }

    @Test
    public void testDeleteEntity() throws Exception {

    }
}