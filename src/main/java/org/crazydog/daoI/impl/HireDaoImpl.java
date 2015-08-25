package org.crazydog.daoI.impl;

import java.util.List;

import org.crazydog.daoI.HireDaoI;
import org.crazydog.domain.HireEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
@Component("hireDaoImpl")
public class HireDaoImpl implements HireDaoI{
	@Autowired(required=true)
	@Qualifier(value="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	@Override
	public void addHire(HireEntity entity) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(entity);
	}

	@Override
	public void modifyHire(HireEntity entity) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(entity);
	}

	@Override
	public void deleteHire(int id) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(this.getHire(id));
	}

	@Override
	public HireEntity getHire(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(HireEntity.class, id);
	}

	@Override
	public List<HireEntity> getAllHires() {
		// TODO Auto-generated method stub
		return hibernateTemplate.loadAll(HireEntity.class);
	}

}
