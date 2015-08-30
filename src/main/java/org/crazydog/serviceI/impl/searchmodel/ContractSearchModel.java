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
    protected StringBuffer advanceSearch() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContractSearchModel that = (ContractSearchModel) o;

        if (!empCode.equals(that.empCode)) return false;
        if (!name.equals(that.name)) return false;
        if (!unitName.equals(that.unitName)) return false;
        if (!hireStart.equals(that.hireStart)) return false;
        return hireFinish.equals(that.hireFinish);

    }

    @Override
    public int hashCode() {
        int result = empCode.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + unitName.hashCode();
        result = 31 * result + hireStart.hashCode();
        result = 31 * result + hireFinish.hashCode();
        return result;
    }
}
