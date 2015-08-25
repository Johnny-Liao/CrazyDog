package org.crazydog.daoI.impl;

import org.crazydog.daoI.EmployeedaoI;
import org.crazydog.domain.EmployeeEntity;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by John on 2015/8/25.
 */
public class EmployeedaoImplTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("test-application-config.xml");
    EmployeedaoI employeedao = context.getBean("employeedaoImpl", EmployeedaoI.class);

    @Test
    public void getEmployee() {
        EmployeeEntity get_entity = employeedao.getEmployee(1);
        System.out.println(get_entity.getId());
        System.out.println(get_entity.getEmpName());
    }

    @Test
    public void getEmployeeByName() {
/*        EmployeeEntity entity = new EmployeeEntity();
        String name = "张三";
        entity.setEmpName(name);*/
        String name = "aa";
        /*List<EmployeeEntity> employees = */
        employeedao.getEmployeeByName(name);
/*        for(EmployeeEntity emp : employees) {
            if(emp.getId().equals(1)) {
                System.out.println("right");
            }
        }*/
    }

}
