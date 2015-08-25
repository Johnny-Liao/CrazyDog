package org.crazydog.serviceI.impl;

import java.util.List;

import org.crazydog.daoI.ResumeJobsDaoI;
import org.crazydog.daoI.ResumedaoI;
import org.crazydog.domain.ResumeJobsEntity;
import org.crazydog.serviceI.ResumeJobsServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component("resumeJobsServiceImpl")
public class ResumeJobsServiceImpl implements ResumeJobsServiceI {
	@Autowired(required=true)
	@Qualifier(value="resumeJobsDaoImpl")
	private ResumeJobsDaoI  resumeJobsDaoImpl;
	@Override
	@Transactional(readOnly=false)
	public void addResumeJob(ResumeJobsEntity entity) {
		// TODO Auto-generated method stub
		resumeJobsDaoImpl.addResumeJob(entity);
	}

	@Override
	@Transactional(readOnly=false)
	public void modifyResumeJob(ResumeJobsEntity entity) {
		// TODO Auto-generated method stub
		resumeJobsDaoImpl.modifyResumeJob(entity);
	}

	@Override
	@Transactional(readOnly=false)
	public void deleteResumeJob(int id) {
		// TODO Auto-generated method stub
		resumeJobsDaoImpl.deleteResumeJob(id);
	}

	@Override
	@Transactional(readOnly=false)
	public ResumeJobsEntity getResumeJob(int id) {
		// TODO Auto-generated method stub
		return resumeJobsDaoImpl.getResumeJob(id);
	}

	@Override
	@Transactional(readOnly=false)
	public List<ResumeJobsEntity> getAllResumeJobs() {
		// TODO Auto-generated method stub
		return resumeJobsDaoImpl.getAllResumeJobs();
	}

}
