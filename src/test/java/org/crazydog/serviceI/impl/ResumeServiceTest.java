package org.crazydog.serviceI.impl;

import org.crazydog.daoI.Basedao;
import org.crazydog.daoI.impl.HireDaoImpl;
import org.crazydog.domain.HireEntity;
import org.crazydog.serviceI.BaseService;
import org.hibernate.Query;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;

public class ResumeServiceTest {
	ApplicationContext applicationContext;
	ResumeServiceImpl resumeServiceImpl;
	Basedao basedao;

	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(
				"test-application-config.xml");

	}

	// @Test
	// public void test(){
	// resumeServiceImpl = (ResumeServiceImpl)
	// applicationContext.getBean("resumeServiceImpl");
	// System.out.println(resumeServiceImpl);
	// // 测试取消录取
	// resumeServiceImpl.cancelHire(1,"李飞");
	// }
	// @Test
	// public void test(){
	// // 测试通过resumeid拿取录取信息
	// resumeServiceImpl = (ResumeServiceImpl)
	// applicationContext.getBean("resumeServiceImpl");
	// System.out.println(resumeServiceImpl);
	// HireEntity h = resumeServiceImpl.getEntitybyreumeid(3);
	// System.out.println(h);
	// }
	@Test
	public void test() {
		// 简历的复杂查询
		resumeServiceImpl = (ResumeServiceImpl) applicationContext.getBean("resumeServiceImpl");
		SearchModel  sreach = new SearchModel(null, "博士","二审" );
		String hql = sreach.advanceSearch();
		System.out.println(hql);
		System.out.println(resumeServiceImpl.queryEntity(hql).get(0).toString());
	}

}
