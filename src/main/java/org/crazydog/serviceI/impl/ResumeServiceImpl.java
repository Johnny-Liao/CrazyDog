package org.crazydog.serviceI.impl;

import org.crazydog.daoI.Basedao;
import org.crazydog.domain.EmployeeEntity;
import org.crazydog.domain.ResumeEntity;
import org.crazydog.serviceI.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Created by never on 2015/8/26.
 */
public class ResumeServiceImpl implements BaseService<ResumeEntity> {

    @Autowired
    @Qualifier("resumedaoImpl")
    private Basedao<ResumeEntity> resumedao;


    /**
     * 通过员工的信息来查询简历实体
     *
     * @param employeeEntity
     * @return
     */
    public ResumeEntity getEntityByEmployee(EmployeeEntity employeeEntity) {
        int resumeId = employeeEntity.getResumeId();
        ResumeEntity resumeEntity = resumedao.getEntity(resumeId);
        return resumeEntity;
    }

    /**
     * 添加实体
     *
     * @param resumeEntity 实体对象
     */
    public void addEntity(ResumeEntity resumeEntity) {
        resumedao.addEntity(resumeEntity);
    }

    /**
     * 修改实体
     *
     * @param resumeEntity 实体对象
     */
    public void modifyEntity(ResumeEntity resumeEntity) {
        resumedao.modifyEntity(resumeEntity);
    }

    /**
     * load具有懒加载效果，获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    public ResumeEntity loadEntity(int id) {
        return resumedao.loadEntity(id);
    }

    /**
     * 获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    public ResumeEntity getEntity(int id) {
        return resumedao.getEntity(id);
    }

    /**
     * 获得所有的实体类
     *
     * @return
     */
    public List<ResumeEntity> getAllEntities() {
        return resumedao.getAllEntities();
    }

    /**
     * 删除指定的某个实体
     *
     * @param resumeEntity 实体对象
     * @return
     */
    public void deleteEntity(ResumeEntity resumeEntity) {
        resumedao.deleteEntity(resumeEntity);
    }
}
