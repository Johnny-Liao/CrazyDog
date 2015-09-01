package org.crazydog.daoI.impl;

import org.crazydog.daoI.Basedao;
import org.crazydog.domain.ResumeEduEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 操作简历中的教育信息的dao
 */
@Component
public class ResumeEdudaoImpl extends Basedao<ResumeEduEntity> {

    /**
     * 增加教育经历
     *
     * @param entity 教育经历实例
     */
    public void addEntity(ResumeEduEntity entity) {
        hibernateTemplate.save(entity);
    }

    /**
     * 修改教育经历
     *
     * @param entity 教育经历实例
     */
    public void modifyEntity(ResumeEduEntity entity) {
        hibernateTemplate.update(entity);
    }

    /**
     * 删除教育经历
     *
     * @param entity 指定删除
     */
    public void deleteEntity(ResumeEduEntity entity) {
        hibernateTemplate.delete(entity);
    }

    /**
     * 获取教育经历
     *
     * @param id 指定需要获取的id
     * @return id所表示的教育经历
     */
    public ResumeEduEntity getEntity(int id) {
        return hibernateTemplate.get(ResumeEduEntity.class, id);
    }

    /**
     * 获取所有教育经历
     *
     * @return 教育经历的list集合
     */
    public List<ResumeEduEntity> getAllEntities() {
        return hibernateTemplate.loadAll(ResumeEduEntity.class);
    }

    /**
     * 通过load获取指定的教育经历实例
     *
     * @param id 教育经历的实例
     * @return id指定的教育经历实例
     */
    public ResumeEduEntity loadEntity(int id) {
        return hibernateTemplate.load(ResumeEduEntity.class, id);
    }

}
