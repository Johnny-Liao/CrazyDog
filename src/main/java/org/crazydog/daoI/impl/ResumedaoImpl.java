package org.crazydog.daoI.impl;

import java.util.List;

import org.crazydog.daoI.ResumedaoI;
import org.crazydog.domain.HireEntity;
import org.crazydog.domain.ResumeEntity;
import org.crazydog.utils.SpringHelper;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
@Component("resumedaoImpl")
public class ResumedaoImpl implements ResumedaoI{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void addResume(ResumeEntity entity) {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void modifyResume(ResumeEntity entity) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteResume(int id) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(this.getResume(id));
	}

	@Override
	public ResumeEntity getResume(int id) {
		// TODO Auto-generated method stub
		
		return hibernateTemplate.get(ResumeEntity.class, id);
	}

	@Override
	public List<ResumeEntity> getAllResumes() {
		// TODO Auto-generated method stub
		return hibernateTemplate.loadAll(ResumeEntity.class);
	}
}
