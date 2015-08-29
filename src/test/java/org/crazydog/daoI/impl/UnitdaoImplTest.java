package org.crazydog.daoI.impl;

import org.crazydog.daoI.Basedao;
import org.crazydog.domain.UnitEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by never on 2015/8/24.
 */
public class UnitdaoImplTest {
    ApplicationContext applicationContext;

    Basedao<UnitEntity> unitdaoImpl;

    @Before
    public void before() {
        applicationContext = new ClassPathXmlApplicationContext("test-application-config.xml");
        unitdaoImpl = (Basedao) applicationContext.getBean("unitdaoImpl");
    }

    @Test
    public void testGetUnit() {
        UnitEntity unitEntity = unitdaoImpl.getEntity(2);
        System.out.println(unitEntity);
    }

    @Test
    public void testaddEntity() {
        UnitEntity unitEntity = new UnitEntity();
        unitEntity.setUnitCode("SB1");
        unitEntity.setUnitName("臭傻逼");
        unitdaoImpl.addEntity(unitEntity);
    }

    @Test
    public void testModifyUnit() {
        UnitEntity unitEntity = new UnitEntity();
        unitEntity.setId(1);
        unitEntity.setUnitCode("ZY");
        unitEntity.setUnitName("邹杨");
        unitdaoImpl.modifyEntity(unitEntity);
    }

    @Test
    public void testDeleteUnit() {
        UnitEntity unitEntity = new UnitEntity();
        unitEntity.setId(1);
        unitdaoImpl.deleteEntity(unitEntity);
    }
}
