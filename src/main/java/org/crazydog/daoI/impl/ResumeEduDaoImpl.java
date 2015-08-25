package org.crazydog.daoI.impl;

import org.crazydog.daoI.ResumeEduDaoI;
import org.crazydog.domain.ResumeEduEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("resumeEduDaoImpl")
public class ResumeEduDaoImpl implements ResumeEduDaoI {
    @Autowired(required = true)
    @Qualifier(value = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    public void addResumeEdu(ResumeEduEntity entity) {
        hibernateTemplate.save(entity);
    }

    public void modifyResumeEdu(ResumeEduEntity entity) {
        hibernateTemplate.update(entity);
    }

    public void deleteResumeEdu(int id) {

    }

    public ResumeEduEntity getResumeEdu(int id) {
        return (ResumeEduEntity) hibernateTemplate.get(ResumeEduEntity.class, id);
    }

    public List<ResumeEduEntity> getAllResumeEdus() {
        return hibernateTemplate.loadAll(ResumeEduEntity.class);
    }

}
