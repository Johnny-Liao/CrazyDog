package org.crazydog.serviceI.impl;

import org.crazydog.daoI.Basedao;
import org.crazydog.domain.PositionEntity;
import org.crazydog.serviceI.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Created by never on 2015/8/26.
 */
public class PositionServiceImpl implements BaseService<PositionEntity> {

    @Autowired
    @Qualifier("positiondaoImpl")
    private Basedao positiondao;

    /**
     * 添加实体
     *
     * @param positionEntity 实体对象
     */
    public void addEntity(PositionEntity positionEntity) {
        positiondao.addEntity(positionEntity);
    }

    /**
     * 修改实体
     *
     * @param positionEntity 实体对象
     */
    public void modifyEntity(PositionEntity positionEntity) {
        positiondao.modifyEntity(positionEntity);
    }

    /**
     * load具有懒加载效果，获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    public PositionEntity loadEntity(int id) {
        return (PositionEntity) positiondao.loadEntity(id);
    }

    /**
     * 获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    public PositionEntity getEntity(int id) {
        return (PositionEntity) positiondao.getEntity(id);
    }

    /**
     * 获得所有的实体类
     *
     * @return
     */
    public List<PositionEntity> getAllEntities() {
        return positiondao.getAllEntities();
    }

    /**
     * 删除指定的某个实体
     *
     * @param positionEntity 实体对象
     * @return
     */
    public void deleteEntity(PositionEntity positionEntity) {
        positiondao.deleteEntity(positionEntity);
    }
}
