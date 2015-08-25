package org.crazydog.daoI;

import org.crazydog.domain.ContractEntity;
import org.crazydog.domain.EmployeeEntity;

import java.util.List;

/**
 * 对合同进行操作
 * Created by never on 2015/8/23.
 */
public interface ContractdaoI {

    /**
     * 增加合同
     *
     * @param contractEntity 合同
     */
    void addContractEntity(ContractEntity contractEntity);

    /**
     * 修改合同
     *
     * @param contractEntity 合同
     */
    void modifyContractEntity(ContractEntity contractEntity);

    /**
     * 删除合同
     *
     * @param contractEntity 合同
     */
    void deleteContractEntity(ContractEntity contractEntity);

    /**
     * 根据合同的id来获取合同信息
     *
     * @param id 合同id
     * @return
     */
    ContractEntity getContractEntity(int id);

    /**
     * 通过用户的id来获取其合同
     *
     * @param employeeEntity
     * @return
     */
    ContractEntity getContractEntity(EmployeeEntity employeeEntity);

    /**
     * 根据所有的合同信息
     *
     * @return
     */
    List<ContractEntity> getAllContractEntity();
}
