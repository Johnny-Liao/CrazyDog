package org.crazydog.daoI.impl;

import org.crazydog.daoI.ResumedaoI;
import org.crazydog.domain.ResumeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("resumedaoImpl")
public class ResumedaoImpl implements ResumedaoI {

    @Autowired(required = true)
    @Qualifier(value = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    public void addResume(ResumeEntity entity) {
        hibernateTemplate.save(entity);
    }

    @Transactional(readOnly = false)
    public void modifyResume(ResumeEntity entity) {
        hibernateTemplate.update(entity);
    }

    public void deleteResume(int id) {
        hibernateTemplate.delete(this.getResume(id));
    }

    public ResumeEntity getResume(int id) {
        return hibernateTemplate.get(ResumeEntity.class, id);
    }

    public List<ResumeEntity> getAllResumes() {
        return hibernateTemplate.loadAll(ResumeEntity.class);
    }
}
