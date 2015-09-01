package org.crazydog.serviceI.impl;

import org.crazydog.domain.HireInfoEntity;
import org.crazydog.serviceI.impl.searchmodel.ResumeSearchModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by never on 2015/8/31.
 */
public class HireInfoServiceImplTest {
    ApplicationContext applicationContext;
    HireInfoServiceImpl hireInfoService;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("test-application-config.xml");
        hireInfoService = (HireInfoServiceImpl) applicationContext.getBean("hireInfoServiceImpl");
    }

    @Test
    public void testGetHireInfoEntityByResume() throws Exception {

    }

    @Test
    public void testGetAllHireEnititiesByState() throws Exception {
        List<HireInfoEntity> list = hireInfoService.getAllHireEntitiesByState(ResumeSearchModel.Luqu.录取);
        for (HireInfoEntity hireInfoEntity : list) {
            System.out.println(hireInfoEntity);
            System.out.println(hireInfoEntity.getResumeEntity());
        }
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
}