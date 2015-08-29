package org.crazydog.daoI.impl;

import org.crazydog.daoI.Basedao;
import org.crazydog.domain.ResumeJobsEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResumeJobsdaoImpl extends Basedao<ResumeJobsEntity> {

    /**
     * 增加工作经验
     *
     * @param entity 教育工作经验实例
     */
    public void addEntity(ResumeJobsEntity entity) {
        hibernateTemplate.save(entity);
    }

    /**
     * 修改教育经历
     *
     * @param entity 工作经验实例
     */
    public void modifyEntity(ResumeJobsEntity entity) {
        hibernateTemplate.update(entity);
    }

    /**
     * 删除教育经历
     *
     * @param entity 工作经验
     */
    public void deleteEntity(ResumeJobsEntity entity) {
        hibernateTemplate.delete(entity);
    }

    /**
     * 获取指定的工作经验
     *
     * @param id 工作经验的id
     * @return
     */
    public ResumeJobsEntity getEntity(int id) {
        return hibernateTemplate.get(ResumeJobsEntity.class, id);
    }

    /**
     * 获取所有的工作经验
     *
     * @return
     */
    public List<ResumeJobsEntity> getAllEntities() {
        return hibernateTemplate.loadAll(ResumeJobsEntity.class);
    }

    /**
     * 通过load获取指定的共组经历实例
     *
     * @param id 教育经历的实例
     * @return id指定的教育经历实例
     */
    public ResumeJobsEntity loadEntity(int id) {
        return hibernateTemplate.load(ResumeJobsEntity.class, id);
    }

}
