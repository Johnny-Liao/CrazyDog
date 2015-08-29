package org.crazydog.daoI.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;

public class ResumeDaoImplTest {
	ApplicationContext applicationContext;

    @Before
    public void before() {
        applicationContext = new ClassPathXmlApplicationContext("test-application-config.xml");
    }

    @Test
    public void testSpring() {
        HibernateTemplate hibernateTemplate = (HibernateTemplate) applicationContext.getBean("hibernateTemplate");
        System.out.println(hibernateTemplate);
        
    }
    @Test
    public void testResume() {
//    	HireDaoImpl hiredaoImpl = (HireDaoImpl) applicationContext.getBean("hireDaoImpl");
//        System.out.println(hiredaoImpl);
//        HireEntity h = new HireEntity();
//        h.setId(1);
//        h.setDeclineCause("我修改了录取意见");
//        hiredaoImpl.modifyEntity(h);
//    	ResumedaoImpl resumedaoImpl = (ResumedaoImpl) applicationContext.getBean("resumedaoImpl");
////        System.out.println(hiredaoImpl);
//        ResumeEntity h = new ResumeEntity();
//        h.setName("我修改了。。你妹的");
//        resumedaoImpl.modifyEntity(h);
    }
}
