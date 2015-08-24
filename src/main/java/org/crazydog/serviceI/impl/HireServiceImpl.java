package org.crazydog.serviceI.impl;

import java.util.List;

import org.crazydog.daoI.HireDaoI;
import org.crazydog.domain.HireEntity;
import org.crazydog.serviceI.HireServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

public class HireServiceImpl implements HireServiceI{
	@Autowired(required=true)
	@Qualifier(value="hireDaoImpl")
	private HireDaoI hireDaoImpl;
	@Override
	@Transactional(readOnly=false)
	public void addHire(HireEntity entity) {
		// TODO Auto-generated method stub
		hireDaoImpl.addHire(entity);
	}

	@Override
	@Transactional(readOnly=false)
	public void modifyHire(HireEntity entity) {
		// TODO Auto-generated method stub
		hireDaoImpl.modifyHire(entity);
	}

	@Override
	@Transactional(readOnly=false)
	public void deleteHire(int id) {
		// TODO Auto-generated method stub
		hireDaoImpl.deleteHire(id);
	}

	@Override
	@Transactional(readOnly=false)
	public HireEntity getHire(int id) {
		// TODO Auto-generated method stub
		return hireDaoImpl.getHire(id);
	}

	@Override
	@Transactional(readOnly=false)
	public List<HireEntity> getAllHires() {
		// TODO Auto-generated method stub
		return hireDaoImpl.getAllHires();
	}

}
