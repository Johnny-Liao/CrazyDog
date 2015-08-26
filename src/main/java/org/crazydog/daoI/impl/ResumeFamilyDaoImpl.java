package org.crazydog.daoI.impl;

import org.crazydog.daoI.Basedao;
import org.crazydog.domain.ResumeFamilyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResumeFamilyDaoImpl extends Basedao<ResumeFamilyEntity> {

    /**
     * 添加家庭成员
     *
     * @param entity 家庭成员实体
     */
    public void addEntity(ResumeFamilyEntity entity) {
        hibernateTemplate.save(entity);
    }

    /**
     * 修改家庭成员
     *
     * @param entity 家庭成员实例
     */
    public void modifyEntity(ResumeFamilyEntity entity) {
        hibernateTemplate.update(entity);
    }

    /**
     * 删除家庭成员
     *
     * @param entity 家庭成员
     */
    public void deleteEntity(ResumeFamilyEntity entity) {
        hibernateTemplate.delete(entity);
    }

    /**
     * 获取所有的家庭成员
     *
     * @param
     * @return
     */
    public List<ResumeFamilyEntity> getAllEntities() {
        return hibernateTemplate.loadAll(ResumeFamilyEntity.class);
    }

    /**
     * 获取所有的家庭成员
     *
     * @return
     */
    public ResumeFamilyEntity getEntity(int id) {
        return hibernateTemplate.get(ResumeFamilyEntity.class, id);
    }

    /**
     * 通过load获取指定的家庭成员实例
     *
     * @param id 家庭成员的id
     * @return id指定的家庭成员
     */
    public ResumeFamilyEntity loadEntity(int id) {
        return hibernateTemplate.load(ResumeFamilyEntity.class, id);
    }
}
