package org.crazydog.serviceI.impl.searchmodel;

import java.sql.Timestamp;

/**
 * Created by never on 2015/8/28.
 */
public class ContractSearchModel extends SearchModel {

    private String empCode;
    private String name;
    private String unitName;
    private Timestamp hireStart;
    private Timestamp hireFinish;

    public ContractSearchModel(String empCode, String name, String unitName, Timestamp hireStart, Timestamp hireFinish) {
        this.empCode = empCode;
        this.name = name;
        this.unitName = unitName;
        this.hireStart = hireStart;
        this.hireFinish = hireFinish;
    }

    @Override
    public StringBuffer advanceSearch() {
        if (name == null && unitName == null && empCode == null && hireStart == null && hireFinish == null)
            return null;
        buffer.append("from ContractEntity con,PositionChangeEntity pos where ");
        if (empCode != null)
            buffer.append(" con.employeeByEmpId.empCode='" + empCode + "' and");
        if (name != null)
            buffer.append(" con.employeeByEmpId.empName='" + name + "' and");
        if (unitName != null)
            buffer.append(" con.employeeByEmpId.unitByUnitId.unitName='" + unitName + "' and");
        if (hireStart != null)
            buffer.append(" pos.joinDate>='" + hireStart + "' and");
        if (hireFinish != null)
            buffer.append(" pos.leaveDate<='" + hireFinish + "' and");
        return buffer;
    }
}
