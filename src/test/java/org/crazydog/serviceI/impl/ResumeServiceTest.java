package org.crazydog.serviceI.impl;

import java.util.Iterator;
import java.util.List;

import org.crazydog.daoI.Basedao;
import org.crazydog.daoI.impl.HireDaoImpl;
import org.crazydog.domain.HireEntity;
import org.crazydog.domain.ResumeEduEntity;
import org.crazydog.domain.ResumeEntity;
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
    // resumeServiceImpl.cancelHire(1,"廖仕豪");
    // }
//     @Test
//     public void test(){
//     // 测试通过resumeid拿取录取信息
//     resumeServiceImpl = (ResumeServiceImpl)
//     applicationContext.getBean("resumeServiceImpl");
//     System.out.println(resumeServiceImpl);
//     HireEntity h = resumeServiceImpl.getEntitybyreumeid(3);
//     System.out.println(h);
//     }
//    @Test
//    public void test() {
//        //简历的复杂查询
//        resumeServiceImpl = (ResumeServiceImpl) applicationContext.getBean("resumeServiceImpl");
//        SearchModel sreach = new SearchModel(null, "博士", "二审");
//        String sql = sreach.advanceSearch();
//        System.out.println(sql);
//        List<Object> list = resumeServiceImpl.queryEntity(sql);
//        System.out.println((Object) list.get(0));
//        for (int i = 0; i < list.size(); i++) {
//            Object[] b = (Object[]) list.get(i);
//            for (int j = 0; j < b.length; j++) {
//                System.out.println(b[j]);
//            }
//        }
//		Object[] b = (Object[]) list.get(0);
//		HireEntity h = (HireEntity) b[1];
//		System.out.println(h.getOperator());
//    }
    @Test
    public void test(){
        resumeServiceImpl = (ResumeServiceImpl) applicationContext.getBean("resumeServiceImpl");
        java.util.List<ResumeEntity> resumes = resumeServiceImpl.getAllEntities();
//		java.util.List<ResumeEntity>
//        request.setAttribute("resumes", resumes);
        Iterator<ResumeEntity> it = resumes.iterator();
        while(it.hasNext()){
            ResumeEntity a = it.next();
            System.out.println(a.getAddress());
            HireEntity b = (HireEntity) a.getHireById();
            System.out.println(b);
        }
        System.out.println("通过不同方式进行跳转");
    }

}
