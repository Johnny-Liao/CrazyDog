package org.crazydog.serviceI.impl;

import java.util.List;

import org.crazydog.daoI.ResumeEduDaoI;
import org.crazydog.daoI.ResumeFamilyDaoI;
import org.crazydog.domain.ResumeFamilyEntity;
import org.crazydog.serviceI.ResumeFamilyServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component("resumeFamilyServiceImpl")
public class ResumeFamilyServiceImpl implements ResumeFamilyServiceI {
	@Autowired(required=true)
	@Qualifier(value="resumeFamilyDaoImpl")
	private ResumeFamilyDaoI  resumeFamilyDaoImpl;
	@Override
	public void addResumeFamily(ResumeFamilyEntity entity) {
		// TODO Auto-generated method stub
		resumeFamilyDaoImpl.addResumeFamily(entity);
	}

	@Override
	public void modifyResumeFamily(ResumeFamilyEntity entity) {
		// TODO Auto-generated method stub
		resumeFamilyDaoImpl.modifyResumeFamily(entity);
	}

	@Override
	public void deleteResumeFamily(int id) {
		// TODO Auto-generated method stub
		resumeFamilyDaoImpl.deleteResumeFamily(id);
	}

	@Override
	public ResumeFamilyEntity getResumeFamily(int id) {
		// TODO Auto-generated method stub
		return resumeFamilyDaoImpl.getResumeFamily(id);
	}

	@Override
	public List<ResumeFamilyEntity> getAllResumeFamilys() {
		// TODO Auto-generated method stub
		return resumeFamilyDaoImpl.getAllResumeFamilys();
	}

}
