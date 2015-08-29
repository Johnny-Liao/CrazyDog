package org.crazydog.daoI.impl;

import org.crazydog.daoI.Basedao;
import org.crazydog.domain.ResumeEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ResumedaoImpl extends Basedao<ResumeEntity> {


    /**
     * 增加简历
     *
     * @param entity 简历实例
     */
    public void addEntity(ResumeEntity entity) {
        hibernateTemplate.save(entity);
    }

    /**
     * 修改简历
     *
     * @param entity 简历实例
     */
    public void modifyEntity(ResumeEntity entity) {
        hibernateTemplate.update(entity);
    }

    /**
     * 删除简历
     *
     * @param resumeEntity 简历的
     */
    public void deleteEntity(ResumeEntity resumeEntity) {
        hibernateTemplate.delete(resumeEntity);
    }

    /**
     * 获取指定的简历
     *
     * @param id 简历的id
     * @return
     */
    public ResumeEntity getEntity(int id) {
        return hibernateTemplate.get(ResumeEntity.class, id);
    }

    /**
     * 获取所有的简历
     *
     * @param
     * @return
     */
    public List<ResumeEntity> getAllEntities() {
        return hibernateTemplate.loadAll(ResumeEntity.class);
    }

    /**
     * 通过load获取指定的简历
     *
     * @param id 简历的id
     * @return
     */
    public ResumeEntity loadEntity(int id) {
        return hibernateTemplate.load(ResumeEntity.class, id);
    }

    /**
     * 通过名字查询简历
     *
     * @param name 指定查询的名字
     * @return 指定名字的简历实例
     */
    public List<?> getEntityByName(String name) {
        Map<String, Object> map = new HashMap<String, Object>(1);
        map.put("name", name);
        return find("from ResumeEntity resume where resume.name=:name", map);
    }

}
