package org.crazydog.controller;

import org.crazydog.serviceI.BaseService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by johnny on 15-8-27.
 */
public class EmployeeControllerTest {

    ApplicationContext applicationContext;
    BaseService employeeService;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("test-application-config.xml");
        employeeService = (BaseService) applicationContext.getBean("employeeService");
    }

    @Test
    public void getEmployeeService() {

    }
}
