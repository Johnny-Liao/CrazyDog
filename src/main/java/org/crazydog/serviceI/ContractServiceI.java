package org.crazydog.serviceI;

import org.crazydog.domain.ContractEntity;

import java.util.List;

/**
 * Created by never on 2015/8/23.
 */
public interface ContractServiceI {
//    /**
//     * 增加合同
//     *
//     * @param contractEntity 合同
//     */
//    void addContractEntity(ContractEntity contractEntity);

    /**
     * 合同变更
     *
     * @param contractEntity 合同
     */
    void modifyContractEntity(ContractEntity contractEntity);

//    /**
//     * 删除合同
//     *
//     * @param id 合同id
//     */
//    void deleteContractEntity(int id);

    /**
     * 根据合同的id来获取合同信息
     *
     * @param id 合同id
     * @return
     */
    ContractEntity getContractEntity(int id);

    /**
     * 根据所有的合同信息
     *
     * @return
     */
    List<ContractEntity> getAllContractEntity();
}
