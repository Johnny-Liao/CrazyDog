package org.crazydog.daoI.impl;

import java.util.List;

import org.crazydog.daoI.ResumeJobsDaoI;
import org.crazydog.domain.ResumeJobsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
@Component("resumeJobsDaoImpl")
public class ResumeJobsDaoImpl implements  ResumeJobsDaoI{
	@Autowired(required=true)
	@Qualifier(value="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	@Override
	public void addResumeJob(ResumeJobsEntity entity) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(entity);
	}

	@Override
	public void modifyResumeJob(ResumeJobsEntity entity) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(entity);
	}

	@Override
	public void deleteResumeJob(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResumeJobsEntity getResumeJob(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(ResumeJobsEntity.class, id);
	}

	@Override
	public List<ResumeJobsEntity> getAllResumeJobs() {
		// TODO Auto-generated method stub
		return hibernateTemplate.loadAll(ResumeJobsEntity.class);
	}

}
