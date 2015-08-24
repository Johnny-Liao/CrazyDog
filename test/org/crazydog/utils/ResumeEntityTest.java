package org.crazydog.utils;

import org.crazydog.daoI.impl.ResumedaoImpl;
import org.crazydog.domain.ResumeEntity;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ResumeEntityTest {
	@Test
	public void test(){
		System.out.println("进入测试");
		String path="classpath:application-config.xml";
		ApplicationContext context= new ClassPathXmlApplicationContext(path);
		System.out.println(context.getBean("hibernateTemplate"));
		ResumedaoImpl  resumedao = context.getBean("resumedaoImpl", ResumedaoImpl.class);
		System.out.println("拿到Bean对象");
      	ResumeEntity resume = (ResumeEntity)resumedao.getResume(1);
		System.out.println(resume.getName());
	}

}
