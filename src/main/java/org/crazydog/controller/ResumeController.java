package org.crazydog.controller;

import org.crazydog.domain.ResumeEntity;
import org.crazydog.serviceI.impl.ResumeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import antlr.collections.List;

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
		System.out.println("通过不同方式进行跳转");
		return "resume";
	}

}
