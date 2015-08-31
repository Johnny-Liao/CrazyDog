package org.crazydog.daoI.impl;

import org.crazydog.daoI.Basedao;
import org.crazydog.domain.HireInfoEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HireInfodaoImpl extends Basedao<HireInfoEntity> {

    /**
     * 增加录取信息
     *
     * @param entity 录取信息实例
     */
    public void addEntity(HireInfoEntity entity) {
        hibernateTemplate.save(entity);
    }

    /**
     * 修改录取信息
     *
     * @param entity 录取信息实例
     */
    public void modifyEntity(HireInfoEntity entity) {
        hibernateTemplate.update(entity);
    }

    /**
     * 删除录取信息
     *
     * @param hireEntity 录取信息
     */
    public void deleteEntity(HireInfoEntity hireEntity) {
        hibernateTemplate.delete(hireEntity);
    }

    /**
     * 通过get的方式获取录取信息
     *
     * @param id 录取信息id
     * @return 拿到指定ID的录取信息
     */
    public HireInfoEntity getEntity(int id) {
        return hibernateTemplate.get(HireInfoEntity.class, id);
    }

    /**
     * 拿到所有的录取信息
     *
     * @return 拿到所有的录取信息
     */
    public List<HireInfoEntity> getAllEntities() {
        return hibernateTemplate.loadAll(HireInfoEntity.class);
    }

    /**
     * 通过load的方式拿到指定的录取信息
     *
     * @param id 录取信息id
     * @return 指定ID的录取信息
     */
    public HireInfoEntity loadEntity(int id) {
        return hibernateTemplate.load(HireInfoEntity.class, id);
    }

    /**
     * 通过resume的id获取录取信息
     *
     * @return id 查询的resume的id
     */
    public HireInfoEntity getEntitybyreumeid(int resume_id) {
        String hql = "from HireInfoEntity hire where hire.resumeEntity.id='" + resume_id
                + "'";
        return (HireInfoEntity) find(hql).get(0);
    }


}
