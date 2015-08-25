package org.crazydog.daoI.impl;

import org.crazydog.domain.HireEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HireDaoImpl implements HireDaoI {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void addHire(HireEntity entity) {
        hibernateTemplate.save(entity);
    }

    public void modifyHire(HireEntity entity) {
        hibernateTemplate.update(entity);
    }

    public void deleteHire(int id) {
        hibernateTemplate.delete(this.getHire(id));
    }

    public HireEntity getHire(int id) {
        return hibernateTemplate.get(HireEntity.class, id);
    }

    public List<HireEntity> getAllHires() {
        return hibernateTemplate.loadAll(HireEntity.class);
    }

}
