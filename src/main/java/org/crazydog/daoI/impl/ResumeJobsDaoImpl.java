package org.crazydog.daoI.impl;

import org.crazydog.domain.ResumeJobsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("resumeJobsDaoImpl")
public class ResumeJobsDaoImpl implements ResumeJobsDaoI {
    @Autowired(required = true)
    private HibernateTemplate hibernateTemplate;

    public void addResumeJob(ResumeJobsEntity entity) {
        hibernateTemplate.save(entity);
    }

    public void modifyResumeJob(ResumeJobsEntity entity) {
        hibernateTemplate.update(entity);
    }

    public void deleteResumeJob(int id) {
        hibernateTemplate.delete(this.getResumeJob(id));
    }

    public ResumeJobsEntity getResumeJob(int id) {
        return hibernateTemplate.get(ResumeJobsEntity.class, id);
    }

    public List<ResumeJobsEntity> getAllResumeJobs() {
        return hibernateTemplate.loadAll(ResumeJobsEntity.class);
    }

}
