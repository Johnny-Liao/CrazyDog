package org.crazydog.daoI.impl;

import org.crazydog.daoI.EmployeedaoI;
import org.crazydog.domain.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;

/**
 * Created by Johnny on 2015/8/23.
 */
public class EmployeedaoImpl implements EmployeedaoI {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void addEmployee(EmployeeEntity entity) {
        hibernateTemplate.save(EmployeeEntity.class);
    }

    public void modifyEmployee(EmployeeEntity entity) {
        hibernateTemplate.update(EmployeeEntity.class);
    }

    public void deleteEmployee(int id) {
        hibernateTemplate.delete(EmployeeEntity.class);
    }

    public EmployeeEntity getEmployee(int id) {
        return hibernateTemplate.load(EmployeeEntity.class, id);
    }

    public List<EmployeeEntity> getAllEmployees() {
        return hibernateTemplate.loadAll(EmployeeEntity.class);
    }
}
