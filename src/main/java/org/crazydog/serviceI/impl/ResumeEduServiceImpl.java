package org.crazydog.serviceI.impl;

import java.util.List;

import org.crazydog.daoI.ResumeEduDaoI;
import org.crazydog.daoI.ResumedaoI;
import org.crazydog.domain.ResumeEduEntity;
import org.crazydog.serviceI.ResumeEduServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component("resumeEduServiceImpl")
public class ResumeEduServiceImpl implements ResumeEduServiceI {
	@Autowired(required=true)
//	@Qualifier(value="resumeEduDaoImpl")
	private ResumeEduDaoI  resumeEduDaoImpl;

	@Override
	public void addResumeEdu(ResumeEduEntity entity) {
		// TODO Auto-generated method stub
		resumeEduDaoImpl.addResumeEdu(entity);
	}

	@Override
	public void modifyResumeEdu(ResumeEduEntity entity) {
		// TODO Auto-generated method stub
		resumeEduDaoImpl.modifyResumeEdu(entity);
	}

	@Override
	public void deleteResumeEdu(int id) {
		// TODO Auto-generated method stub
		resumeEduDaoImpl.deleteResumeEdu(id);
	}

	@Override
	public ResumeEduEntity getResumeEdu(int id) {
		// TODO Auto-generated method stub
		return resumeEduDaoImpl.getResumeEdu(id);
	}

	@Override
	public List<ResumeEduEntity> getAllResumeEdus() {
		// TODO Auto-generated method stub
		return resumeEduDaoImpl.getAllResumeEdus();
	}

}
