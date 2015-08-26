package org.crazydog.daoI.impl;

import org.crazydog.daoI.Basedao;
import org.crazydog.domain.PositionEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by never on 2015/8/26.
 */
@Component
public class PositiondaoImpl extends Basedao<PositionEntity> {

    /**
     * 添加实体
     *
     * @param positionEntity 实体对象
     */
    @Override
    public void addEntity(PositionEntity positionEntity) {
        hibernateTemplate.save(positionEntity);
    }

    /**
     * 修改实体
     *
     * @param positionEntity 实体对象
     */
    @Override
    public void modifyEntity(PositionEntity positionEntity) {
        hibernateTemplate.update(positionEntity);
    }

    /**
     * load具有懒加载效果，获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    @Override
    public PositionEntity loadEntity(int id) {
        return hibernateTemplate.load(PositionEntity.class, id);
    }

    /**
     * 获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    @Override
    public PositionEntity getEntity(int id) {
        return hibernateTemplate.get(PositionEntity.class, id);
    }

    /**
     * 获得所有的实体类
     *
     * @return
     */
    @Override
    public List<PositionEntity> getAllEntities() {
        return hibernateTemplate.loadAll(PositionEntity.class);
    }

    /**
     * 删除指定的某个实体
     *
     * @param positionEntity 实体对象
     * @return
     */
    @Override
    public void deleteEntity(PositionEntity positionEntity) {
        hibernateTemplate.delete(positionEntity);
    }
}
