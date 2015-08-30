package org.crazydog.controller;

import org.crazydog.domain.HireInfoEntity;
import org.crazydog.domain.ResumeEntity;
import org.crazydog.serviceI.impl.ResumeServiceImpl;
import org.crazydog.serviceI.impl.searchmodel.ResumeSearchModel;
import org.crazydog.serviceI.impl.searchmodel.SearchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class ResumeController {
	
	@Autowired
	@Qualifier("resumeServiceImpl")
	private ResumeServiceImpl resumeService;
	
	@RequestMapping(value="/resume",params="action=getAll")
	public String getAllmes(HttpServletRequest request){
		java.util.List<ResumeEntity> resumes = resumeService.getAllEntities();
		request.setAttribute("resumes", resumes);
		Iterator<ResumeEntity> it = resumes.iterator();
		while(it.hasNext()){
			ResumeEntity a = it.next();
			System.out.println(a.getAddress());
			System.out.println(a.getHireById());
		}
		return "resume";
	}
	/*
		条件查询
	 */
	@RequestMapping(value="/resume",params ="action=modelSearch")
	public String modelSearch(@RequestParam("name")String name,@RequestParam("highestEdu")String highestEdu,@RequestParam("luquState")String luquState,HttpServletRequest request){
		ResumeSearchModel resumeSearchModel = new ResumeSearchModel(null,null, ResumeSearchModel.Luqu.valueOf(luquState));
		List<Object[]> list = resumeService.advanceSearch(resumeSearchModel);
		List<ResumeEntity> resumes= new ArrayList<ResumeEntity>();
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
            Object[] b = (Object[]) list.get(i);
			ResumeEntity  resume = (ResumeEntity)b[0];
			HireInfoEntity h = (HireInfoEntity) b[1];
			resume.setHireById(h);
			resumes.add(resume);
        }
		request.setAttribute("resumes", resumes);

		return "resume";
	}
	/*
		批量删除
	 */
	@RequestMapping(value="/resume",params ="action=bitchdelete")
	public String modelSearch(HttpServletRequest request){
		String[] s = request.getParameterValues("selectes");
		System.out.println(s);
//		java.util.List<ResumeEntity> resumes = resumeService.getAllEntities();
//		request.setAttribute("resumes", resumes);
//		Iterator<ResumeEntity> it = resumes.iterator();
//		while(it.hasNext()){
//			ResumeEntity a = it.next();
//			System.out.println(a.getAddress());
//			System.out.println(a.getHireById());
//		}
		return "selectresume";

	}

	/*
		批量录取
	 */
	@RequestMapping(value="/resume",params ="action=bitchHire")
	public String bitchHire(HttpServletRequest request){
		String[] ids =  request.getParameterValues("selectes");
		int[] i = {2,3};
		String name = "李飞";
		resumeService.batchHire(i, name);
		return "resume";

	}

	/*
            批量取消录取
         */
	@RequestMapping(value="/resume",params ="action=bitchCancelHire")
	public String bitchCancelHire(HttpServletRequest request){
		String[] ids =  request.getParameterValues("selectes");
		int[] i = {2,3};
		String name = "李飞";
		resumeService.batchcancelHire(i,name);
		return "resume";

	}






	/*
		获取所有录取等待状态的简历
	 */
	@RequestMapping(value="/resume",params ="action=getHiremes")
	public String getNoHire(HttpServletRequest request){
		ResumeSearchModel resumeSearchModel = new ResumeSearchModel(null,null, ResumeSearchModel.Luqu.等待审核);
		List<Object[]> list = resumeService.advanceSearch(resumeSearchModel);
		List<ResumeEntity> resumes2= new ArrayList<ResumeEntity>();
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			Object[] b = (Object[]) list.get(i);
			ResumeEntity  resume = (ResumeEntity)b[0];
			HireInfoEntity h = (HireInfoEntity) b[1];
			resume.setHireById(h);
			resumes2.add(resume);
		}
		request.setAttribute("resumes2", resumes2);
		return "bitchhire";
	}
	/*
            获取所有已录取简历
         */
	@RequestMapping(value="/resume",params ="action=getAllHire")
	public String getAllHire(HttpServletRequest request){
		ResumeSearchModel resumeSearchModel = new ResumeSearchModel(null,null, ResumeSearchModel.Luqu.录取);
		List<Object[]> list = resumeService.advanceSearch(resumeSearchModel);
		List<ResumeEntity> resumes1= new ArrayList<ResumeEntity>();
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			Object[] b = (Object[]) list.get(i);
			ResumeEntity  resume = (ResumeEntity)b[0];
			HireInfoEntity h = (HireInfoEntity) b[1];
			resume.setHireById(h);
			resumes1.add(resume);
		}
		request.setAttribute("resumes1", resumes1);
		return "bitchCancelHire";
	}
}
