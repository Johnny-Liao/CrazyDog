package org.crazydog.daoI.impl;

import org.crazydog.daoI.ResumeFamilyDaoI;
import org.crazydog.domain.ResumeFamilyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("resumeFamilyDaoImpl")
public class ResumeFamilyDaoImpl implements ResumeFamilyDaoI {
    @Autowired(required = true)
    @Qualifier(value = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    public void addResumeFamily(ResumeFamilyEntity entity) {
        hibernateTemplate.save(entity);
    }

    public void modifyResumeFamily(ResumeFamilyEntity entity) {
        hibernateTemplate.update(entity);
    }

    public void deleteResumeFamily(int id) {

    }

    public List<ResumeFamilyEntity> getAllResumeFamilys() {
        // TODO Auto-generated method stub
        return hibernateTemplate.loadAll(ResumeFamilyEntity.class);
    }

    public ResumeFamilyEntity getResumeFamily(int id) {
        // TODO Auto-generated method stub
        return hibernateTemplate.get(ResumeFamilyEntity.class, id);
    }


}
