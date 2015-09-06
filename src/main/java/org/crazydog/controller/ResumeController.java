package org.crazydog.controller;

import org.crazydog.domain.ResumeEntity;
import org.crazydog.serviceI.impl.ResumeServiceImpl;
import org.crazydog.serviceI.impl.searchmodel.ResumeSearchModel;
import org.crazydog.util.PoiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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
		List<ResumeEntity> resumes = resumeService.getAllEntities();
		request.setAttribute("resumes", resumes);
		Iterator<ResumeEntity> it = resumes.iterator();
		while(it.hasNext()){
			ResumeEntity a = it.next();
			System.out.println(a.getAddress());
			System.out.println(a.getHireById());
		}
		return "resumeBypage";
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
		return "resumeBypage";
	}
	/*
		批量删除
	 */
	@RequestMapping(value="/resume",params ="action=batchdelete")
	public String batchdelete(HttpServletRequest request,@RequestParam("selects")int[] id){
		if(id!=null){
			resumeService.batchDeleteResume(id);
		}
		List<ResumeEntity> resumes = resumeService.getAllEntities();
		request.setAttribute("resumes", resumes);
		return "resumeBypage";
	}

	/*
		批量录取
	 */
	@RequestMapping(value="/resume",params ="action=batchHire")
	public String batchHire(HttpServletRequest request,@RequestParam("selects")int[] id){
		if(id!=null){
			resumeService.batchHire(id, "李飞");
		}
		ResumeSearchModel resumeSearchModel = new ResumeSearchModel(null,null, ResumeSearchModel.Luqu.等待审核);
		List<ResumeEntity> resumes2 = resumeService.advanceSearch(resumeSearchModel);
		request.setAttribute("resumes2", resumes2);
		return "batchhire";

	}

	/**
	 * 批量取消录取
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/resume",params ="action=batchCancelHire")
	public String batchCancelHire(HttpServletRequest request,@RequestParam("selects")int[] id){
		if(id!=null){
			resumeService.batchCancelHire(id, "李飞");
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



	// eg : .../employee?pages=1
	// 处理pages参数，显示相应页数的所有人员信息
	@RequestMapping(method = RequestMethod.GET, value = "/resume/{page}")
	public String getEmployeeByPages(HttpServletRequest request, @PathVariable String page) {
		request.setAttribute("resumes", resumeService.getResumeByPage(Integer.parseInt(page)));
		request.setAttribute("page", page);
		request.setAttribute("maxPage", resumeService.maxPageNum());
		return "resumeBypage";
	}



	/*
            从excel中读取简历信息
     */
	@RequestMapping(value="/resume",params ="action=upLoadExcel")
	public String upLoadResume(HttpServletRequest request,@RequestParam("uploadExcel")File excel){
			String path = excel.getPath();
			System.out.println(path);
		PoiUtils.PoiUtils(path);
		return this.getAllmes(request);
	}


}
