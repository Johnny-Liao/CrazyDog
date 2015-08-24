package org.crazydog.utils;

import org.crazydog.daoI.ResumedaoI;
import org.crazydog.daoI.impl.ResumedaoImpl;
import org.crazydog.domain.ResumeEntity;
import org.crazydog.serviceI.ResumeServiceI;
import org.crazydog.serviceI.impl.ResumeServiceImpl;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ResumeEntityTest {
	@Test
	public void test(){
		System.out.println("进入测试");
		String path="classpath:application-config.xml";
		ApplicationContext context= new ClassPathXmlApplicationContext(path);
		ResumedaoI  resumedao = (ResumedaoI) context.getBean("resumedaoImpl");
		System.out.println("拿到Bean对象");
      	ResumeEntity resume = (ResumeEntity)resumedao.getResume(1);
      	System.out.println();
		ResumeServiceI resumeservice = (ResumeServiceI) context.getBean("resumeServiceImpl");
      	resume.setName("呵呵");
      	resumeservice.modifyResume(resume);
		System.out.println(resume.getName());
		
		
	}

}
