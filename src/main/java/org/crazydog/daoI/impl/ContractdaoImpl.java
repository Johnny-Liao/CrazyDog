package org.crazydog.daoI.impl;

import org.crazydog.daoI.ContractdaoI;
import org.crazydog.domain.ContractEntity;
import org.crazydog.domain.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.util.List;

/**
 * Created by never on 2015/8/23.
 */
public class ContractdaoImpl implements ContractdaoI {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void addContractEntity(ContractEntity contractEntity) {
        hibernateTemplate.save(contractEntity);
    }

    public void modifyContractEntity(ContractEntity contractEntity) {
        hibernateTemplate.saveOrUpdate(contractEntity);
    }

    public void deleteContractEntity(ContractEntity contractEntity) {
        hibernateTemplate.delete(contractEntity);
    }

    public ContractEntity getContractEntity(int id) {
        return hibernateTemplate.load(ContractEntity.class, id);
    }

    public ContractEntity getContractEntity(EmployeeEntity employeeEntity) {
        List<?> list = hibernateTemplate.find("from contractEntity where contractEntity.employeeByEmpId.id=?", employeeEntity.getId());
        if (list.size() == 1)
            return (ContractEntity) list.get(0);
        else throw new RuntimeException("没有" + employeeEntity.getEmpName() + "的合同");
    }

    public List<ContractEntity> getAllContractEntity() {
        return hibernateTemplate.loadAll(ContractEntity.class);
    }
}
