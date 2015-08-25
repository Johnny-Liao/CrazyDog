package org.crazydog.serviceI.impl;

import java.util.List;

import org.crazydog.domain.ResumeEntity;
import org.crazydog.serviceI.ResumeServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component("resumeServiceImpl")
public class ResumeServiceImpl implements ResumeServiceI{
	
	@Autowired(required=true)
	@Qualifier(value="resumedaoImpl")
	private ResumedaoI  resumedaoImpl;
	
	
	
	@Override
	@Transactional(readOnly=false)
	public void modifyResume(ResumeEntity entity) {
		// TODO Auto-generated method stub
		resumedaoImpl.modifyResume(entity);
	}


	@Override
	@Transactional(readOnly=false)
	public void addResume(ResumeEntity entity) {
		// TODO Auto-generated method stub
		resumedaoImpl.addResume(entity);
	}


	@Override
	@Transactional(readOnly=false)
	public void deleteResume(int id) {
		// TODO Auto-generated method stub
		resumedaoImpl.deleteResume(id);
	}


	@Override
	@Transactional(readOnly=false)
	public ResumeEntity getResume(int id) {
		// TODO Auto-generated method stub
		return resumedaoImpl.getResume(id);
	}


	@Override
	@Transactional(readOnly=false)
	public List<ResumeEntity> getAllResumes() {
		// TODO Auto-generated method stub
		return resumedaoImpl.getAllResumes();
	}

}
