package org.crazydog.daoI.impl;

import org.crazydog.daoI.Basedao;
import org.crazydog.domain.DepartmentEntity;
import org.crazydog.domain.EmployeeEntity;
import org.crazydog.domain.PositionChangeEntity;
import org.crazydog.domain.UnitEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;

import static org.junit.Assert.*;

/**
 * Created by johnny on 15-8-31.
 */
public class PositionChangedaoImplTest {
    ApplicationContext applicationContext;

    Basedao<PositionChangeEntity> positionChangedao;

    @Before
    public void before() {
        applicationContext = new ClassPathXmlApplicationContext("test-application-config.xml");
        positionChangedao = applicationContext.getBean("positionChangedaoImpl", Basedao.class);
    }

    @Test
    public void testModifyEntity() throws Exception {
        PositionChangeEntity positionChangeEntity = new PositionChangeEntity();

        positionChangeEntity.setId(1);
        positionChangeEntity.setChangeTime(new Date(100000));
        positionChangeEntity.setChangeCause("gaigaigai");

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(1);
        positionChangeEntity.setEmployeeEntity(employeeEntity);

        UnitEntity unitEntity = new UnitEntity();
        unitEntity.setId(1);
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setId(1);


        UnitEntity unitEntity2 = new UnitEntity();
        unitEntity2.setId(2);
        DepartmentEntity departmentEntity2 = new DepartmentEntity();
        departmentEntity2.setId(6);

        positionChangeEntity.setUnitByBeforUnitId(unitEntity);
        positionChangeEntity.setDepartmentByBeforDeptId(departmentEntity);
        positionChangeEntity.setUnitByAfterUnitId(unitEntity2);
        positionChangeEntity.setDepartmentByAfterDeptId(departmentEntity2);

        positionChangedao.modifyEntity(positionChangeEntity);


    }
}