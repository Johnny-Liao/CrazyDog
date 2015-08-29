package org.crazydog.daoI.impl;

import org.crazydog.daoI.Basedao;
import org.crazydog.domain.EmployeeEntity;
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

    Basedao employeedaoImpl;

    @Before
    public void before() {
        applicationContext = new ClassPathXmlApplicationContext("test-application-config.xml");
        employeedaoImpl = applicationContext.getBean("employeedaoImpl", Basedao.class);
    }

    @Test
    public void testGetEmployeeByName() throws Exception {

    }

    @Test
    public void testAddEntity() throws Exception {

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