package org.crazydog.serviceI.impl;

import org.crazydog.domain.ResumeEduEntity;
import org.crazydog.serviceI.ResumeEduServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component("resumeEduServiceImpl")
public class ResumeEduServiceImpl implements ResumeEduServiceI {
	@Autowired(required=true)
//	@Qualifier(value="resumeEduDaoImpl")
	private ResumeEduDaoI  resumeEduDaoImpl;

	@Transactional(readOnly=false)
	public void addResumeEdu(ResumeEduEntity entity) {
		// TODO Auto-generated method stub
		resumeEduDaoImpl.addResumeEdu(entity);
	}

	@Transactional(readOnly=false)
	public void modifyResumeEdu(ResumeEduEntity entity) {
		// TODO Auto-generated method stub
		resumeEduDaoImpl.modifyResumeEdu(entity);
	}

	@Transactional(readOnly=false)
	public void deleteResumeEdu(int id) {
		// TODO Auto-generated method stub
		resumeEduDaoImpl.deleteResumeEdu(id);
	}

	@Transactional(readOnly=false)
	public ResumeEduEntity getResumeEdu(int id) {
		// TODO Auto-generated method stub
		return resumeEduDaoImpl.getResumeEdu(id);
	}

	@Transactional(readOnly=false)
	public List<ResumeEduEntity> getAllResumeEdus() {
		// TODO Auto-generated method stub
		return resumeEduDaoImpl.getAllResumeEdus();
	}

}
