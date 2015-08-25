package org.crazydog.daoI.impl;

import org.crazydog.daoI.EmployeedaoI;
import org.crazydog.domain.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Johnny on 2015/8/23.
 */
@Component
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
        return hibernateTemplate.get(EmployeeEntity.class, id);
    }

    public List<EmployeeEntity> getEmployeeByName(String name) {
        List<?> list = hibernateTemplate.find("from employeeEntity where employeeEntity.emp_name like ?", name);
        return (List<EmployeeEntity>) list;
    }

    public List<EmployeeEntity> getAllEmployees() {
        return hibernateTemplate.loadAll(EmployeeEntity.class);
    }
}
