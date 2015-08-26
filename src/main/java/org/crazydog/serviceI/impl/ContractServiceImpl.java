package org.crazydog.serviceI.impl;

import org.crazydog.daoI.Basedao;
import org.crazydog.domain.ContractEntity;
import org.crazydog.serviceI.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by never on 2015/8/23.
 */
@Service
public class ContractServiceImpl implements BaseService<ContractEntity> {

    @Autowired
//    @Qualifier("employeeServiceImpl")
    private EmployeeServiceImpl employeeService;

    @Autowired
    @Qualifier("contractdaoImpl")
    private Basedao<ContractEntity> contractdao;

    public void getEmployeeEntityByCode(String code) {
        employeeService.getEmployeeByCode(code);
    }

    /**
     * 添加实体
     *
     * @param contractEntity 实体对象
     */
    public void addEntity(ContractEntity contractEntity) {
        contractdao.addEntity(contractEntity);
    }

    /**
     * 修改实体
     *
     * @param contractEntity 实体对象
     */
    public void modifyEntity(ContractEntity contractEntity) {
        contractdao.modifyEntity(contractEntity);
    }

    /**
     * load具有懒加载效果，获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    public ContractEntity loadEntity(int id) {
        return contractdao.loadEntity(id);
    }

    /**
     * 获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    public ContractEntity getEntity(int id) {
        return contractdao.getEntity(id);
    }

    /**
     * 获得所有的实体类
     *
     * @return
     */
    public List<ContractEntity> getAllEntities() {
        return contractdao.getAllEntities();
    }

    /**
     * 删除指定的某个实体
     *
     * @param contractEntity 实体对象
     * @return
     */
    public void deleteEntity(ContractEntity contractEntity) {
        contractdao.deleteEntity(contractEntity);
    }
}