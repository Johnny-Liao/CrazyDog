package org.crazydog.controller;

import org.crazydog.domain.ResumeEntity;
import org.crazydog.serviceI.impl.ResumeServiceImpl;
import org.crazydog.serviceI.impl.searchmodel.ResumeSearchModel;
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
	/*
	    获取所有的简历信息
	 */
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
	    获取指定的简历信息
	 */
	@RequestMapping(value="/resume",params="action=getAresume")
	public String getAresume(HttpServletRequest request,@RequestParam("resumeid")int resumeid){
		ResumeEntity resume = resumeService.getEntity(resumeid);
		System.out.println(resume.getHireById().getState());
		request.setAttribute("resume", resume);
		return "getAResume";
	}
	/*
		条件查询
	 */
	@RequestMapping(value="/resume",params ="action=modelSearch")
	public String modelSearch(@RequestParam("username")String name,@RequestParam("highestEdu")String highestEdu,@RequestParam("luquState")String luquState,HttpServletRequest request){
		System.out.println(name+"==========================================================");
		if(name==""){
			name=null;
		}
		ResumeSearchModel resumeSearchModel = new ResumeSearchModel(name,ResumeSearchModel.Edu.valueOf(highestEdu), ResumeSearchModel.Luqu.valueOf(luquState));
		List<ResumeEntity> resumes = resumeService.advanceSearch(resumeSearchModel);
		request.setAttribute("resumes", resumes);
		return "resume";
	}
	/*
		批量删除
	 */
	@RequestMapping(value="/resume",params ="action=batchdelete")
	public String batchdelete(HttpServletRequest request){
		String[] ids =  request.getParameterValues("selectid");
		if(ids!=null){
			int[] id = resumeService.stringtoint(ids);
			resumeService.batchdeleteresume(id);
		}
		java.util.List<ResumeEntity> resumes = resumeService.getAllEntities();
		request.setAttribute("resumes", resumes);
		return "resume";
	}

	/*
		批量录取
	 */
	@RequestMapping(value="/resume",params ="action=batchHire")
	public String batchHire(HttpServletRequest request){
		String[] ids =  request.getParameterValues("selectes");
		if(ids!=null){
			int[] id = resumeService.stringtoint(ids);
			resumeService.batchHire(id, "李飞");
		}
		ResumeSearchModel resumeSearchModel = new ResumeSearchModel(null,null, ResumeSearchModel.Luqu.等待审核);
		List<ResumeEntity> resumes2 = resumeService.advanceSearch(resumeSearchModel);
		request.setAttribute("resumes2", resumes2);
		return "batchhire";

	}

	/*
            批量取消录取
         */
	@RequestMapping(value="/resume",params ="action=batchCancelHire")
	public String batchCancelHire(HttpServletRequest request){
		String[] ids =  request.getParameterValues("selectes");
		if(ids!=null){
			int[] id = resumeService.stringtoint(ids);
			resumeService.batchcancelHire(id,"李飞");
		}
		ResumeSearchModel resumeSearchModel = new ResumeSearchModel(null,null, ResumeSearchModel.Luqu.录取);
		List<ResumeEntity> resumes1 = resumeService.advanceSearch(resumeSearchModel);
		request.setAttribute("resumes1", resumes1);
		return "batchCancelHire";

	}






	/*
		获取所有录取等待状态的简历
	 */
	@RequestMapping(value="/resume",params ="action=getNoHire")
	public String getNoHire(HttpServletRequest request){
		ResumeSearchModel resumeSearchModel = new ResumeSearchModel(null,null, ResumeSearchModel.Luqu.等待审核);
		List<ResumeEntity> resumes2 = resumeService.advanceSearch(resumeSearchModel);
		request.setAttribute("resumes2", resumes2);
		return "batchhire";
	}
	/*
            获取所有已录取简历
         */
	@RequestMapping(value="/resume",params ="action=getAllHire")
	public String getAllHire(HttpServletRequest request){
		ResumeSearchModel resumeSearchModel = new ResumeSearchModel(null,null, ResumeSearchModel.Luqu.录取);
		List<ResumeEntity> resumes1 = resumeService.advanceSearch(resumeSearchModel);
		request.setAttribute("resumes1", resumes1);
		return "batchCancelHire";
	}

}
