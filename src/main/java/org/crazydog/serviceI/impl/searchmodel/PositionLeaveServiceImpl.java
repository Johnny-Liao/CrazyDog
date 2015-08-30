package org.crazydog.serviceI.impl.searchmodel;

import org.crazydog.daoI.Basedao;
import org.crazydog.domain.PositionLeaveEntity;
import org.crazydog.domain.PositionLeaveEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by johnny on 15-8-30.
 */
@Service
public class PositionLeaveServiceImpl {

    @Autowired
    @Qualifier("positionLeavedaoImpl")
    private Basedao<PositionLeaveEntity> positionLeavedao;


    /**
     * 添加实体
     *
     * @param PositionLeaveEntity 实体对象
     */
    public void addEntity(PositionLeaveEntity PositionLeaveEntity) {
        positionLeavedao.addEntity(PositionLeaveEntity);
    }

    /**
     * 修改实体
     *
     * @param PositionLeaveEntity 实体对象
     */
    public void modifyEntity(PositionLeaveEntity PositionLeaveEntity) {
        positionLeavedao.modifyEntity(PositionLeaveEntity);
    }

    /**
     * load具有懒加载效果，获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    public PositionLeaveEntity loadEntity(int id) {
        return positionLeavedao.loadEntity(id);
    }

    /**
     * 获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    public PositionLeaveEntity getEntity(int id) {
        return positionLeavedao.getEntity(id);
    }

    /**
     * 获得所有的实体类
     *
     * @return
     */
    public List<PositionLeaveEntity> getAllEntities() {
        return positionLeavedao.getAllEntities();
    }

    /**
     * 删除指定的某个实体
     *
     * @param PositionLeaveEntity 实体对象
     * @return
     */
    public void deleteEntity(PositionLeaveEntity PositionLeaveEntity) {
        positionLeavedao.deleteEntity(PositionLeaveEntity);
    }

    

}
