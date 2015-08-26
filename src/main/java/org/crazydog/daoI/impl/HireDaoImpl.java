package org.crazydog.daoI.impl;

import org.crazydog.daoI.Basedao;
import org.crazydog.domain.HireEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class HireDaoImpl extends Basedao<HireEntity> {

    /**
     * 增加录取信息
     *
     * @param entity 录取信息实例
     */
    public void addEntity(HireEntity entity) {
        hibernateTemplate.save(entity);
    }

    /**
     * 修改录取信息
     *
     * @param entity 录取信息实例
     */
    public void modifyEntity(HireEntity entity) {
        hibernateTemplate.update(entity);
    }

    /**
     * 删除录取信息
     *
     * @param hireEntity 录取信息
     */
    public void deleteEntity(HireEntity hireEntity) {
        hibernateTemplate.delete(hireEntity);
    }

    /**
     * 通过get的方式获取录取信息
     *
     * @param id 录取信息id
     * @return 拿到指定ID的录取信息
     */
    public HireEntity getEntity(int id) {
        return hibernateTemplate.get(HireEntity.class, id);
    }

    /**
     * 拿到所有的录取信息
     *
     * @return 拿到所有的录取信息
     */
    public List<HireEntity> getAllEntities() {
        return hibernateTemplate.loadAll(HireEntity.class);
    }

    /**
     * 通过load的方式拿到指定的录取信息
     *
     * @param id 录取信息id
     * @return 指定ID的录取信息
     */
    public HireEntity loadEntity(int id) {
        return hibernateTemplate.load(HireEntity.class, id);
    }
   

}
