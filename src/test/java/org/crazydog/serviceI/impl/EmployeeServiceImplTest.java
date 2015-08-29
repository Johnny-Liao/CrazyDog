package org.crazydog.serviceI.impl;

import org.crazydog.domain.EmployeeEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by johnny on 15-8-29.
 */
public class EmployeeServiceImplTest {

    ApplicationContext applicationContext;
    EmployeeServiceImpl employeeService;
    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("test-application-config.xml");
        employeeService = applicationContext.getBean("employeeServiceImpl", EmployeeServiceImpl.class);
    }

    @Test
    public void testGetEmployeeByName() throws Exception {
        List<EmployeeEntity> employeeEntitys = employeeService.getEmployeeByName("邹杨");
        Assert.assertEquals("邹杨", employeeEntitys.get(0).getEmpName());
    }

    @Test
    public void testGetEmployeeByCode() throws Exception {
        List<EmployeeEntity> employeeEntities = employeeService.getEmployeeByCode("4");
        for (EmployeeEntity entity : employeeEntities) {
            System.out.println(entity);
        }
    }

    @Test
    public void testAdvanceSearch() throws Exception {

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

    }

    @Test
    public void testDeleteEntity() throws Exception {

    }

    @Test
    public void testShowEmployeeInfo() throws Exception {

    }

    @Test
    public  void getEmployeeByPage() {
        List<Object[]> objects = employeeService.getEmployeeByPage(1);
        for(Object object : objects) {
            System.out.println(object);
        }
    }
}