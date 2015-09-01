package org.crazydog.daoI.impl;

import org.crazydog.daoI.Basedao;
import org.crazydog.domain.ContractEntity;
import org.crazydog.domain.EmployeeEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 操作合同的dao
 * Created by never on 2015/8/23.
 */
@Component
public class ContractdaoImpl extends Basedao<ContractEntity> {

    /**
     * 通过人事信息获得合同
     *
     * @param employeeEntity 人事信息（不能为空）
     * @return
     */
    @SuppressWarnings("unchecked")
    public ContractEntity getContractEntity(EmployeeEntity employeeEntity) {
        Map<String, Object> map = new HashMap<String, Object>(1);
        map.put("emp", employeeEntity);
        List<ContractEntity> list = (List<ContractEntity>) find("from ContractEntity con where con.employeeByEmpId=:emp", map);
        if (list != null && list.size() == 1)
            return list.get(0);
        else throw new RuntimeException("没有" + employeeEntity.getEmpName() + "的合同");
    }

    /**
     * 添加实体
     *
     * @param contractEntity 实体对象（不能为空）
     */
    @Override
    public void addEntity(ContractEntity contractEntity) {
        hibernateTemplate.save(contractEntity);
    }

    /**
     * 修改实体
     *
     * @param contractEntity 实体对象（不能为空）
     */
    @Override
    public void modifyEntity(ContractEntity contractEntity) {
        hibernateTemplate.update(contractEntity);
    }

    /**
     * load具有懒加载效果，获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    @Override
    public ContractEntity loadEntity(int id) {
        return hibernateTemplate.load(ContractEntity.class, id);
    }

    /**
     * 获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    @Override
    public ContractEntity getEntity(int id) {
        return hibernateTemplate.get(ContractEntity.class, id);
    }

    /**
     * 获得所有的实体类
     *
     * @return
     */
    @Override
    public List<ContractEntity> getAllEntities() {
        return hibernateTemplate.loadAll(ContractEntity.class);
    }

    /**
     * 删除指定的某个实体
     *
     * @param contractEntity 实体对象
     * @return
     */
    @Override
    public void deleteEntity(ContractEntity contractEntity) {
        hibernateTemplate.delete(contractEntity);
    }
}