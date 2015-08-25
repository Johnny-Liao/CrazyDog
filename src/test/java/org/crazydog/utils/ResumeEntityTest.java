package org.crazydog.utils;

import org.crazydog.daoI.ResumedaoI;
import org.crazydog.daoI.impl.ResumedaoImpl;
import org.crazydog.domain.ResumeEduEntity;
import org.crazydog.domain.ResumeEntity;
import org.crazydog.serviceI.ResumeEduServiceI;
import org.crazydog.serviceI.ResumeServiceI;
import org.crazydog.serviceI.impl.ResumeEduServiceImpl;
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
//		ResumedaoI  resumedao = (ResumedaoI) context.getBean("resumedaoImpl");
//		System.out.println("拿到Bean对象");
//      	ResumeEntity resume = (ResumeEntity)resumedao.getResume(1);
//      	System.out.println(resume);
//		ResumeServiceI resumeservice = (ResumeServiceI) context.getBean("resumeServiceImpl");
//      	resume.setName("呵呵");
//      	resumeservice.modifyResume(resume);
//		System.out.println(resume.getName());
		ResumeEduServiceI  resumeEduServiceImpl = (ResumeEduServiceI) context.getBean("resumeEduServiceImpl");
		System.out.println(resumeEduServiceImpl.getResumeEdu(1).getSchool());
		
		ResumeEduServiceI resumeEduServiceImpl2 = (ResumeEduServiceI) context.getBean("resumeEduServiceImpl");
		ResumeEduEntity  s =  (ResumeEduEntity)resumeEduServiceImpl.getResumeEdu(1);
		s.setSchool("江西农业大学");
		resumeEduServiceImpl2.modifyResumeEdu(s);
		System.out.println("修改完成");
	}

}