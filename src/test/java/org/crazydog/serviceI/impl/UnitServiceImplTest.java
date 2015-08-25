package org.crazydog.serviceI.impl;

import org.crazydog.domain.UnitEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by never on 2015/8/25.
 */
public class UnitServiceImplTest {
    ApplicationContext applicationContext;
    UnitServiceI unitService;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("test-application-config.xml");
        unitService = (UnitServiceI) applicationContext.getBean("unitServiceImpl");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAddUnit() throws Exception {

    }

    @Test
    public void testModifyUnit() throws Exception {

    }

    @Test
    public void testDeleteUnit() throws Exception {

    }

    @Test
    public void testLoadUnit() throws Exception {

    }

    @Test
    public void testGetUnit() throws Exception {

    }

    @Test
    public void testGetAllUnits() throws Exception {
        List<UnitEntity> unitEntities = unitService.getAllUnits();
        for (UnitEntity unitEntity : unitEntities)
            System.out.println(unitEntity);
    }

    @Test
    public void testAddDepartments() throws Exception {

    }
}