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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Component("resumedaoImpl")
public class ResumedaoImpl implements ResumedaoI{
	
	@Autowired(required=true)
	@Qualifier(value="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	@Override
	public void addResume(ResumeEntity entity) {
		hibernateTemplate.save(entity);
	}
	@Transactional(readOnly=false)
	@Override
	public void modifyResume(ResumeEntity entity) {
		hibernateTemplate.update(entity);
	}

	@Override
	public void deleteResume(int id) {
		hibernateTemplate.delete(this.getResume(id));
	}

	@Override
	public ResumeEntity getResume(int id) {
		return hibernateTemplate.get(ResumeEntity.class, id);
	}

	@Override
	public List<ResumeEntity> getAllResumes() {
		return hibernateTemplate.loadAll(ResumeEntity.class);
	}
}
