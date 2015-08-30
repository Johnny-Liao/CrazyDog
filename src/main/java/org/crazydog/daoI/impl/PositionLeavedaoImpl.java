package org.crazydog.daoI.impl;

import org.crazydog.daoI.Basedao;
import org.crazydog.domain.PositionLeaveEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by never on 2015/8/26.
 */
@Component
public class PositionLeavedaoImpl extends Basedao<PositionLeaveEntity> {

    /**
     * 添加实体
     *
     * @param positionLeaveEntity 实体对象
     */
    @Override
    public void addEntity(PositionLeaveEntity positionLeaveEntity) {
        hibernateTemplate.save(positionLeaveEntity);
    }

    /**
     * 修改实体
     *
     * @param positionLeaveEntity 实体对象
     */
    @Override
    public void modifyEntity(PositionLeaveEntity positionLeaveEntity) {
        hibernateTemplate.update(positionLeaveEntity);
    }

    /**
     * load具有懒加载效果，获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    @Override
    public PositionLeaveEntity loadEntity(int id) {
        return hibernateTemplate.load(PositionLeaveEntity.class, id);
    }

    /**
     * 获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    @Override
    public PositionLeaveEntity getEntity(int id) {
        return hibernateTemplate.get(PositionLeaveEntity.class, id);
    }

    /**
     * 获得所有的实体类
     *
     * @return
     */
    @Override
    public List<PositionLeaveEntity> getAllEntities() {
        return hibernateTemplate.loadAll(PositionLeaveEntity.class);
    }

    /**
     * 删除指定的某个实体
     *
     * @param positionLeaveEntity 实体对象
     * @return
     */
    @Override
    public void deleteEntity(PositionLeaveEntity positionLeaveEntity) {
        hibernateTemplate.delete(positionLeaveEntity);
    }
}
