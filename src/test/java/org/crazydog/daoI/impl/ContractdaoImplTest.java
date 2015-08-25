package org.crazydog.daoI.impl;

import org.crazydog.Basedao;
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
        applicationContext = new ClassPathXmlApplicationContext("test-application-config.xml");
    }

    @Test
    public void testSpring() {
        HibernateTemplate hibernateTemplate = (HibernateTemplate) applicationContext.getBean("hibernateTemplate");
        System.out.println(hibernateTemplate);
    }

    @Test
    public void testaddEntity() {
        Basedao contractdaoImpl = (Basedao) applicationContext.getBean("contractdaoImpl");
        ContractEntity contractEntity = new ContractEntity();
        System.out.println(contractdaoImpl);
    }

    @Test
    public void testAddContractEntity() throws Exception {

    }

    @Test
    public void testModifyContractEntity() throws Exception {

    }

    @Test
    public void testDeleteContractEntity() throws Exception {

    }

    @Test
    public void testGetContractEntity() throws Exception {

    }

    @Test
    public void testGetContractEntity1() throws Exception {

    }

    @Test
    public void testGetAllContractEntity() throws Exception {

    }
}
