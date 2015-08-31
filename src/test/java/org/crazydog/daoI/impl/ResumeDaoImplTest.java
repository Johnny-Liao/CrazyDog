package org.crazydog.daoI.impl;

import org.crazydog.domain.HireInfoEntity;
import org.crazydog.domain.ResumeEntity;
import org.crazydog.domain.ResumeFamilyEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.sql.Date;
import java.util.Collection;

public class ResumeDaoImplTest {
	ApplicationContext applicationContext;

    @Before
    public void before() {
        applicationContext = new ClassPathXmlApplicationContext("test-application-config.xml");
    }

//    @Test
//    public void testSpring() {
//        HibernateTemplate hibernateTemplate = (HibernateTemplate) applicationContext.getBean("hibernateTemplate");
//        System.out.println(hibernateTemplate);
//
//    }
    @Test
    public void testResume() {
//        ResumedaoImpl resumedaoImpl = (ResumedaoImpl) applicationContext.getBean("resumedaoImpl");
//        ResumeEntity h =  resumedaoImpl.getEntity(1);
        /*
          测试修改方法
         */
//        h.setAddress("宜春升高");
//        resumedaoImpl.modifyEntity(h);
//        System.out.println("修改成功");
        /*
          测试拿到家庭成员对象
         */
//        Collection<ResumeFamilyEntity> f = h.getResumeFamilyById();
//        System.out.println(f.size());
        /*
          测试拿到录取的信息
         */
//       HireInfoEntity f = h.getHireById();
//        //修改录取状态
//        f.setState("未录取");
//        resumedaoImpl.modifyEntity(h);
//        System.out.println(f.getState());


        /*
        在添加简历的时候自动添加录取信息，设置为等待审核
         */
//        ResumeEntity h1 =  resumedaoImpl.getEntity(9);
//        HireInfoEntity f = new HireInfoEntity();
//        f.setState("录取");
//        f.setOperateTime(new java.sql.Date(new java.util.Date().getTime()));
//        h1.setHireById(f);
//        f.setOperator("admin");
//        f.setResumeEntity(h1);
//        resumedaoImpl.modifyEntity(h1);
//        System.out.println("完成级联更新测试");
        /*
        测试级联删除
         */
//        resumedaoImpl.deleteEntity(h);
        String s = "3";
        if((s.equals("1")&&s.equals("2"))==false){
            System.out.println("不符合要求");
        }else{
            System.out.println("符合要求");
        }

    }
}
