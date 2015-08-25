package org.crazydog.daoI.impl;

import java.util.List;

import org.crazydog.daoI.ResumeFamilyDaoI;
import org.crazydog.domain.ResumeEduEntity;
import org.crazydog.domain.ResumeFamilyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
@Component("resumeFamilyDaoImpl")
public class ResumeFamilyDaoImpl implements  ResumeFamilyDaoI{
	@Autowired(required=true)
	@Qualifier(value="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	@Override
	public void addResumeFamily(ResumeFamilyEntity entity) {
		hibernateTemplate.save(entity);
	}

	@Override
	public void modifyResumeFamily(ResumeFamilyEntity entity) {
	hibernateTemplate.update(entity);
	}

	@Override
	public void deleteResumeFamily(int id) {
		hibernateTemplate.delete(this.getResumeFamily(id));
	}


	@Override
	public List<ResumeFamilyEntity> getAllResumeFamilys() {
		// TODO Auto-generated method stub
		return hibernateTemplate.loadAll(ResumeFamilyEntity.class);
	}

	@Override
	public ResumeFamilyEntity getResumeFamily(int id) {
		// TODO Auto-generated method stub
	 return hibernateTemplate.get(ResumeFamilyEntity.class, id);
	}
	

}
