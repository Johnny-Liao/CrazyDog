package org.crazydog.daoI.impl;

import org.crazydog.daoI.Basedao;
import org.crazydog.domain.PositionChangeEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by never on 2015/8/26.
 */
@Component
public class PositionChangedaoImpl extends Basedao<PositionChangeEntity> {

    /**
     * 添加实体
     *
     * @param positionChangeEntity 实体对象
     */
    @Override
    public void addEntity(PositionChangeEntity positionChangeEntity) {
        hibernateTemplate.save(positionChangeEntity);
    }

    /**
     * 修改实体
     *
     * @param positionChangeEntity 实体对象
     */
    @Override
    public void modifyEntity(PositionChangeEntity positionChangeEntity) {
        hibernateTemplate.update(positionChangeEntity);
    }

    /**
     * load具有懒加载效果，获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    @Override
    public PositionChangeEntity loadEntity(int id) {
        return hibernateTemplate.load(PositionChangeEntity.class, id);
    }

    /**
     * 获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    @Override
    public PositionChangeEntity getEntity(int id) {
        return hibernateTemplate.get(PositionChangeEntity.class, id);
    }

    /**
     * 获得所有的实体类
     *
     * @return
     */
    @Override
    public List<PositionChangeEntity> getAllEntities() {
        return hibernateTemplate.loadAll(PositionChangeEntity.class);
    }

    /**
     * 删除指定的某个实体
     *
     * @param positionChangeEntity 实体对象
     * @return
     */
    @Override
    public void deleteEntity(PositionChangeEntity positionChangeEntity) {
        hibernateTemplate.delete(positionChangeEntity);
    }
}
