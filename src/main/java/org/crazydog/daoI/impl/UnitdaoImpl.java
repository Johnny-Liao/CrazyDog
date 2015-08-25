package org.crazydog.daoI.impl;

import org.crazydog.daoI.Basedao;
import org.crazydog.domain.UnitEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by never on 2015/8/25.
 */
@Component
public class UnitdaoImpl extends Basedao<UnitEntity> {
    /**
     * 添加实体
     *
     * @param unitEntity 实体对象
     */
    @Override
    public void addEntity(UnitEntity unitEntity) {
        hibernateTemplate.save(unitEntity);
    }

    /**
     * 修改实体
     *
     * @param unitEntity 实体对象
     */
    @Override
    public void modifyEntity(UnitEntity unitEntity) {
        hibernateTemplate.update(unitEntity);
    }

    /**
     * 获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    @Override
    public UnitEntity getEntity(int id) {
        return hibernateTemplate.get(UnitEntity.class, id);
    }

    /**
     * 获得所有的实体类
     *
     * @return
     */
    @Override
    public List<UnitEntity> getAllEntities() {
        return hibernateTemplate.loadAll(UnitEntity.class);
    }

    /**
     * load具有懒加载效果，获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    @Override
    public UnitEntity loadEntity(int id) {
        return hibernateTemplate.load(UnitEntity.class, id);
    }

    /**
     * 删除指定的某个实体
     *
     * @param id 实体对象的id
     * @return
     */
    @Override
    public void deleteEntity(int id) {
        UnitEntity unitEntity = new UnitEntity();
        unitEntity.setId(id);
        hibernateTemplate.delete(unitEntity);
    }
}
