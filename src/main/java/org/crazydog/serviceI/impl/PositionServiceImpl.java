package org.crazydog.serviceI.impl;

import org.crazydog.daoI.Basedao;
import org.crazydog.domain.PositionChangeEntity;
import org.crazydog.serviceI.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Created by never on 2015/8/26.
 */
public class PositionServiceImpl implements BaseService<PositionChangeEntity> {

    @Autowired
    @Qualifier("positiondaoImpl")
    private Basedao<PositionChangeEntity> positiondao;

    /**
     * 添加实体
     *
     * @param positionChangeEntity 实体对象
     */
    public void addEntity(PositionChangeEntity positionChangeEntity) {
        positiondao.addEntity(positionChangeEntity);
    }

    /**
     * 修改实体
     *
     * @param positionChangeEntity 实体对象
     */
    public void modifyEntity(PositionChangeEntity positionChangeEntity) {
        positiondao.modifyEntity(positionChangeEntity);
    }

    /**
     * load具有懒加载效果，获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    public PositionChangeEntity loadEntity(int id) {
        return positiondao.loadEntity(id);
    }

    /**
     * 获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    public PositionChangeEntity getEntity(int id) {
        return positiondao.getEntity(id);
    }

    /**
     * 获得所有的实体类
     *
     * @return
     */
    public List<PositionChangeEntity> getAllEntities() {
        return positiondao.getAllEntities();
    }

    /**
     * 删除指定的某个实体
     *
     * @param positionChangeEntity 实体对象
     * @return
     */
    public void deleteEntity(PositionChangeEntity positionChangeEntity) {
        positiondao.deleteEntity(positionChangeEntity);
    }
}
