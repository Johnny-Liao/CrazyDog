package org.crazydog.daoI.impl;

import org.crazydog.domain.ResumeFamilyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResumeFamilyDaoImpl implements ResumeFamilyDaoI {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void addResumeFamily(ResumeFamilyEntity entity) {
        hibernateTemplate.save(entity);
    }

    public void modifyResumeFamily(ResumeFamilyEntity entity) {
        hibernateTemplate.update(entity);
    }

    public void deleteResumeFamily(int id) {
        hibernateTemplate.delete(this.getResumeFamily(id));
    }


    public List<ResumeFamilyEntity> getAllResumeFamilys() {
        return hibernateTemplate.loadAll(ResumeFamilyEntity.class);
    }

    public ResumeFamilyEntity getResumeFamily(int id) {
        return hibernateTemplate.get(ResumeFamilyEntity.class, id);
    }
}
