package org.crazydog.daoI.impl;

import org.crazydog.daoI.ContractdaoI;
import org.crazydog.domain.ContractEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;

/**
 * Created by never on 2015/8/24.
 */
public class ContractdaoImplTest {
    ApplicationContext applicationContext;

    @Before
    public void before() {
        applicationContext = new ClassPathXmlApplicationContext("classpath:application-config.xml");
    }

    @Test
    public void testSpring() {
        HibernateTemplate hibernateTemplate = (HibernateTemplate) applicationContext.getBean("hibernateTemplate");
        System.out.println(hibernateTemplate);
    }

    @Test
    public void testaddEntity() {
        ContractdaoI contractdaoImpl = (ContractdaoI) applicationContext.getBean("contractdaoImpl");
        ContractEntity contractEntity = new ContractEntity();
        System.out.println(contractdaoImpl);
    }
}
