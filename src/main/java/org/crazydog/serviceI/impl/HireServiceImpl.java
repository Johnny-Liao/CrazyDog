package org.crazydog.serviceI.impl;

import org.crazydog.daoI.Basedao;
import org.crazydog.domain.tmp.HireEntity;
import org.crazydog.domain.tmp.ResumeEntity;
import org.crazydog.serviceI.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by never on 2015/8/26.
 */
public class HireServiceImpl implements BaseService<HireEntity> {

    @Autowired
    @Qualifier("hiredaoImpl")
    private Basedao<HireEntity> hiredao;

    /**
     * 通过简历实体获得录取实体
     *
     * @param resumeEntity
     * @return
     */
    public HireEntity getHireEntityByResume(ResumeEntity resumeEntity) {
        Map<String, Object> map = new HashMap<String, Object>(1);
        map.put("resumeId", resumeEntity.getId());
        List<HireEntity> list = hiredao.find("from HireEntity hire where hire.resumeId=:resumeId", map);
        if (list != null && list.size() == 1)
            return list.get(0);
        return null;
    }

    /**
     * 添加实体
     *
     * @param hireEntity 实体对象
     */
    public void addEntity(HireEntity hireEntity) {
        hiredao.addEntity(hireEntity);
    }

    /**
     * 修改实体
     *
     * @param hireEntity 实体对象
     */
    public void modifyEntity(HireEntity hireEntity) {
        hiredao.modifyEntity(hireEntity);
    }

    /**
     * load具有懒加载效果，获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    public HireEntity loadEntity(int id) {
        return hiredao.loadEntity(id);
    }

    /**
     * 获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    public HireEntity getEntity(int id) {
        return hiredao.getEntity(id);
    }

    /**
     * 获得所有的实体类
     *
     * @return
     */
    public List<HireEntity> getAllEntities() {
        return hiredao.getAllEntities();
    }

    /**
     * 删除指定的某个实体
     *
     * @param hireEntity 实体对象
     * @return
     */
    public void deleteEntity(HireEntity hireEntity) {
        hiredao.deleteEntity(hireEntity);
    }
}
