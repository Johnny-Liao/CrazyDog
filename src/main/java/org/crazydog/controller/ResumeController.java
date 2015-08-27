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

@Controller
public class ResumeController {
	
//	@Autowired
//	@Qualifier("resumeServiceImpl")
//	private ResumeServiceImpl resumeService;
//	
	
	@RequestMapping("/resumeController")
	public String getAllmes(){
//		List resumes = (List)resumeService.getAllEntities();
		System.out.println("stupid lifei");
		return "resume";
	}

}
