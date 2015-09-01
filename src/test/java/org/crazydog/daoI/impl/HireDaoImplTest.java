package org.crazydog.daoI.impl;

import org.crazydog.domain.HireInfoEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lifei on 2015/8/29.
 */
public class HireDaoImplTest {

    ApplicationContext applicationContext;

    @Before
    public void before() {
        applicationContext = new ClassPathXmlApplicationContext("test-application-config.xml");
    }

    @Test
    public void testSpring() {
        /*
        测试通过resumeid获取录取信息
         */

        HireInfodaoImpl hireInfoDaoImpl = (HireInfodaoImpl) applicationContext.getBean("hireInfoDaoImpl");
       HireInfoEntity h =  hireInfoDaoImpl.getHireInfoByResumeId(6);
        h.setState("录取");
        hireInfoDaoImpl.modifyEntity(h);
        System.out.println(h.getState());


    }

}
