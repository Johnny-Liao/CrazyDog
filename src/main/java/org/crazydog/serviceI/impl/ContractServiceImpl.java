<<<<<<< HEAD
package org.crazydog.serviceI.impl;

import org.crazydog.daoI.*;
import org.crazydog.domain.ContractEntity;
import org.crazydog.domain.EmployeeEntity;
import org.crazydog.serviceI.ContractServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by never on 2015/8/23.
 */
@Service
public class ContractServiceImpl implements ContractServiceI {

	@Override
	public void modifyContractEntity(ContractEntity contractEntity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ContractEntity getContractEntity(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContractEntity> getAllContractEntity() {
		// TODO Auto-generated method stub
		return null;
	}

//    @Autowired
//    private EmployeedaoI employeedao;
//
//    @Autowired
//    private DepartmentdaoI departmentdao;
//
//    @Autowired
//    private UnitdaoI unitdao;
//
//    @Autowired
//    private PositiondaoI positiondao;
//
//    @Autowired
//    private ResumedaoI resumedao;
//
//    @Autowired
//    private ContractdaoI contractdao;
//
//    public void modifyContractEntity(ContractEntity contractEntity) {
//
//    }
//
//    public ContractEntity getContractEntity(int id) {
//        return null;
//    }
//
//    public List<ContractEntity> getAllContractEntity() {
//        List<EmployeeEntity> employeeEntities = employeedao.getAllEmployees();
//
//        List<Timestamp> hireDates = new ArrayList<Timestamp>(employeeEntities.size());
//        List<String> departments = new ArrayList<String>(employeeEntities.size());
//        List<String> units = new ArrayList<String>(employeeEntities.size());
//        List<Timestamp> startDates = new ArrayList<Timestamp>(employeeEntities.size());
//        List<Timestamp> endDates = new ArrayList<Timestamp>(employeeEntities.size());
//
//        for (EmployeeEntity employeeEntity : employeeEntities) {
//            units.add(unitdao.getUnit(employeeEntity.getUnitId()).getUnitName());
//            departments.add(departmentdao.getDepartmentEntity(employeeEntity.getDepId()).getDeptName());
//            resumedao.getResume(employeeEntity.getResumeId()).get
//            positiondao.
//            ContractEntity contractEntity = contractdao.getContractEntity(employeeEntity);
//            Timestamp startTimestamp = contractEntity.getContractStart();
//            Timestamp endTimestamp = contractEntity.getContractEnd();
//            startDates.add(startTimestamp);
//            endDates.add(endTimestamp);
//        }
//        return null;
//    }
}
=======
package org.crazydog.serviceI.impl;

import org.crazydog.daoI.*;
import org.crazydog.domain.ContractEntity;
import org.crazydog.domain.EmployeeEntity;
import org.crazydog.serviceI.ContractServiceI;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by never on 2015/8/23.
 */
//@Service
public class ContractServiceImpl implements ContractServiceI {

    @Autowired
    private EmployeedaoI employeedao;

    @Autowired
    private DepartmentdaoI departmentdao;

    @Autowired
    private UnitdaoI unitdao;

    @Autowired
    private PositiondaoI positiondao;

    @Autowired
    private ResumedaoI resumedao;

    @Autowired
    private ContractdaoI contractdao;

    public void modifyContractEntity(ContractEntity contractEntity) {

    }

    public ContractEntity getContractEntity(int id) {
        return null;
    }

    public List<ContractEntity> getAllContractEntity() {
        List<EmployeeEntity> employeeEntities = employeedao.getAllEmployees();

        List<Timestamp> hireDates = new ArrayList<Timestamp>(employeeEntities.size());
        List<String> departments = new ArrayList<String>(employeeEntities.size());
        List<String> units = new ArrayList<String>(employeeEntities.size());
        List<Timestamp> startDates = new ArrayList<Timestamp>(employeeEntities.size());
        List<Timestamp> endDates = new ArrayList<Timestamp>(employeeEntities.size());

        for (EmployeeEntity employeeEntity : employeeEntities) {
//            units.add(unitdao.getUnit(employeeEntity.getUnitId()).getUnitName());
//            departments.add(departmentdao.getDepartmentEntity(employeeEntity.getDepId()).getDeptName());
//            resumedao.getResume(employeeEntity.getResumeId()).get
//            positiondao.
            ContractEntity contractEntity = contractdao.getContractEntity(employeeEntity);
            Timestamp startTimestamp = contractEntity.getContractStart();
            Timestamp endTimestamp = contractEntity.getContractEnd();
            startDates.add(startTimestamp);
            endDates.add(endTimestamp);
        }
        return null;
    }
}
>>>>>>> bcd33826cccc6660b1d060c59ac9e26753337c6e
