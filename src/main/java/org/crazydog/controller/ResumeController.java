package org.crazydog.controller;

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
	@RequestMapping(value="/resume",params ="action=modelSearch")
	public String modelSearch(@RequestParam("name")String name,@RequestParam("highestEdu")String highestEdu,@RequestParam("luquState")String luquState,HttpServletRequest request){
//		ResumeSearchModel  resumeSearchModel = new ResumeSearchModel(null,null, ResumeSearchModel.Luqu.等待审核);
		ResumeSearchModel resumeSearchModel = new ResumeSearchModel(null,null, ResumeSearchModel.Luqu.valueOf(luquState));
		String hql= SearchModel.advanceSearch(resumeSearchModel);
		List<Object> resumes= resumeService.queryEntity(hql);
		request.setAttribute("resumes", resumes);
		return "selectresume";
	}
//	@RequestMapping(value="bitchdelete")
//	public String modelSearch(HttpServletRequest request){
//		String[] s = request.getParameterValues("bitchdelete");
//		System.out.println(s.toString());
//		java.util.List<ResumeEntity> resumes = resumeService.getAllEntities();
//		request.setAttribute("resumes", resumes);
//		Iterator<ResumeEntity> it = resumes.iterator();
//		while(it.hasNext()){
//			ResumeEntity a = it.next();
//			System.out.println(a.getAddress());
//			System.out.println(a.getHireById());
//		}
//		return "selectresume";
//
//	}


}
