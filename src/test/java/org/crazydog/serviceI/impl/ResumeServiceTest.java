package org.crazydog.serviceI.impl;

import org.crazydog.daoI.Basedao;
import org.crazydog.serviceI.impl.searchmodel.ResumeSearchModel;
import org.crazydog.serviceI.impl.searchmodel.SearchModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
    @Test
    public void test() {
        //简历的复杂查询
        resumeServiceImpl = (ResumeServiceImpl) applicationContext.getBean("resumeServiceImpl");
        SearchModel sreach = new ResumeSearchModel(null, ResumeSearchModel.Edu.博士, ResumeSearchModel.Luqu.通过);
        String sql = sreach.advanceSearch(sreach);
        System.out.println(sql);
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
    }
//    @Test
//    public void test(){
//        resumeServiceImpl = (ResumeServiceImpl) applicationContext.getBean("resumeServiceImpl");
//        java.util.List<ResumeEntity> resumes = resumeServiceImpl.getAllEntities();
////		java.util.List<ResumeEntity>
////        request.setAttribute("resumes", resumes);
//        Iterator<ResumeEntity> it = resumes.iterator();
//        while(it.hasNext()){
//            ResumeEntity a = it.next();
//            System.out.println(a.getAddress());
////            HireEntity b = (HireEntity) a.getHireById();
//            System.out.println(a.getHireById().getOperator());
//        }
//        System.out.println("通过不同方式进行跳转");
//    }

}
