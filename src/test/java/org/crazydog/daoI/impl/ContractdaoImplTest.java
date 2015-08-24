package org.crazydog.daoI.impl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;

/**
 * Created by never on 2015/8/24.
 */
public class ContractdaoImplTest {

    @Test
    public void testSpring() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application-config.xml");
        HibernateTemplate hibernateTemplate = (HibernateTemplate) applicationContext.getBean("hibernateTemplate");
        System.out.println(hibernateTemplate);
    }
}
