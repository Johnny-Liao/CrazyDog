package org.crazydog.controller;

import org.crazydog.domain.tmp.ResumeEntity;
import org.crazydog.serviceI.impl.ResumeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;

@Controller
@RequestMapping("/resumeController")
public class ResumeController {
	
	@Autowired
	@Qualifier("resumeServiceImpl")
	private ResumeServiceImpl resumeService;
	
	@RequestMapping(params="getAllmes")
	public String getAllmes(HttpServletRequest request){
		java.util.List<ResumeEntity> resumes = resumeService.getAllEntities();
//		java.util.List<ResumeEntity>
		request.setAttribute("resumes", resumes);
		Iterator<ResumeEntity> it = resumes.iterator();
		while(it.hasNext()){
			ResumeEntity a = it.next();
			System.out.println(a.getAddress());
			System.out.println(a.getHireById());
		}
		return "resume";
	}
	@RequestMapping("/modelSearch")
	public String modelSearch(@RequestParam("name")String name,@RequestParam("highestEdu")String highestEdu,@RequestParam("luquState")String luquState){
		System.out.println(name + highestEdu + luquState);
		return "selectresume";

	}


}
