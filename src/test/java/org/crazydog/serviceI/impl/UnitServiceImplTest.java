package org.crazydog.serviceI.impl;

import org.crazydog.controller.util.GenerateArray;
import org.crazydog.domain.UnitEntity;
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
    UnitServiceImpl unitService;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("test-application-config.xml");
        unitService = (UnitServiceImpl) applicationContext.getBean("unitServiceImpl");
    }

    @Test
    public void testGetUnitByName() throws Exception {
        List<UnitEntity> unitEntities = unitService.getUnitByName("农大");
        System.out.println(unitEntities.size());
    }

    @Test
    public void testGetUnitByCode() throws Exception {
        UnitEntity nd = unitService.getUnitByCode("ND");
        System.out.println(nd);
    }

    @Test
    public void testAddDepartments() throws Exception {
//        GenerateArray generateArray = new GenerateArray();
        String s = GenerateArray.generateScript(unitService);
        System.out.println(s);
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
        System.out.println(unitService.getClass());
        List<UnitEntity> unitEntities = unitService.getAllEntities();
        for (UnitEntity unitEntity : unitEntities)
            System.out.println(unitEntity);
    }

    @Test
    public void testDeleteEntity() throws Exception {

    }
}