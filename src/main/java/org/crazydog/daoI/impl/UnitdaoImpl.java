package org.crazydog.daoI.impl;

import org.crazydog.daoI.UnitdaoI;
import org.crazydog.domain.UnitEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by never on 2015/8/24.
 */
@Component
public class UnitdaoImpl implements UnitdaoI {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void addUnit(UnitEntity entity) {
        hibernateTemplate.save(entity);
    }

    public void modifyUnit(UnitEntity entity) {
        hibernateTemplate.update(entity);
    }

    public void deleteUnit(UnitEntity entity) {
        hibernateTemplate.delete(entity);
    }

    public UnitEntity getUnit(int id) {
        return hibernateTemplate.load(UnitEntity.class, id);
    }

    public List<UnitEntity> getAllUnits() {
        return hibernateTemplate.loadAll(UnitEntity.class);
    }
}
