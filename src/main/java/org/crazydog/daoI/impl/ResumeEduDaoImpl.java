package org.crazydog.daoI.impl;

import java.util.List;

import org.crazydog.daoI.ResumeEduDaoI;
import org.crazydog.domain.ResumeEduEntity;
import org.crazydog.domain.ResumeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
@Component("resumeEduDaoImpl")
public class ResumeEduDaoImpl implements ResumeEduDaoI{
	@Autowired(required=true)
	@Qualifier(value="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void addResumeEdu(ResumeEduEntity entity) {
		hibernateTemplate.save(entity);
	}

	@Override
	public void modifyResumeEdu(ResumeEduEntity entity) {
		hibernateTemplate.update(entity);
	}

	@Override
	public void deleteResumeEdu(int id) {
		hibernateTemplate.delete(this.getResumeEdu(id));
	}

	@Override
	public ResumeEduEntity getResumeEdu(int id) {
		return (ResumeEduEntity)hibernateTemplate.get(ResumeEduEntity.class, id);
	}

	@Override
	public List<ResumeEduEntity> getAllResumeEdus() {
		return hibernateTemplate.loadAll(ResumeEduEntity.class);
	}

}
