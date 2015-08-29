package org.crazydog.daoI.impl;

import org.crazydog.domain.HireInfoEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;

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
        HireInfoDaoImpl hireInfoDaoImpl = (HireInfoDaoImpl) applicationContext.getBean("hireInfoDaoImpl");
       HireInfoEntity h =  hireInfoDaoImpl.getEntitybyreumeid(6);
        h.setState("录取");
        hireInfoDaoImpl.modifyEntity(h);
        System.out.println(h.getState());


    }

}
