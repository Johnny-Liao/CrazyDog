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
    	ResumedaoImpl resumedaoImpl = (ResumedaoImpl) applicationContext.getBean("resumedaoImpl");
        System.out.println(resumedaoImpl);
        
    }
}
