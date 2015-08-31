package org.crazydog.serviceI.impl;

import org.crazydog.daoI.Basedao;
import org.crazydog.domain.HireInfoEntity;
import org.crazydog.domain.ResumeEntity;
import org.crazydog.serviceI.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by never on 2015/8/26.
 */
@Service
public class HireInfoServiceImpl implements BaseService<HireInfoEntity> {

    @Autowired
    @Qualifier("hireInfodaoImpl")
    private Basedao<HireInfoEntity> hiredao;

    /**
     * 通过简历实体获得录取实体
     *
     * @param resumeEntity
     * @return
     */
    @SuppressWarnings("unchecked")
    public HireInfoEntity getHireInfoEntityByResume(ResumeEntity resumeEntity) {
        Map<String, Object> map = new HashMap<String, Object>(1);
        map.put("resumeId", resumeEntity.getId());
        List<HireInfoEntity> list = (List<HireInfoEntity>) hiredao.find("from HireInfoEntity hire where hire.resumeId=:resumeId", map);
        if (list != null && list.size() == 1)
            return list.get(0);
        return null;
    }

    @SuppressWarnings("unchecked")
    public List<HireInfoEntity> getAllHireEnitities() {
        Map<String, Object> map = new HashMap<String, Object>(1);
        map.put("state", "录取");
        return (List<HireInfoEntity>) hiredao.find("from HireInfoEntity hire where hire.state=:state", map);
    }

    /**
     * 添加实体
     *
     * @param hireEntity 实体对象
     */
    public void addEntity(HireInfoEntity hireEntity) {
        hiredao.addEntity(hireEntity);
    }

    /**
     * 修改实体
     *
     * @param hireEntity 实体对象
     */
    public void modifyEntity(HireInfoEntity hireEntity) {
        hiredao.modifyEntity(hireEntity);
    }

    /**
     * load具有懒加载效果，获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    public HireInfoEntity loadEntity(int id) {
        return hiredao.loadEntity(id);
    }

    /**
     * 获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    public HireInfoEntity getEntity(int id) {
        return hiredao.getEntity(id);
    }

    /**
     * 获得所有的实体类
     *
     * @return
     */
    public List<HireInfoEntity> getAllEntities() {
        return hiredao.getAllEntities();
    }

    /**
     * 删除指定的某个实体
     *
     * @param hireEntity 实体对象
     * @return
     */
    public void deleteEntity(HireInfoEntity hireEntity) {
        hiredao.deleteEntity(hireEntity);
    }
}
