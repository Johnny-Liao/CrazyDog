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

        if (empCode != null ? !empCode.equals(that.empCode) : that.empCode != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (unitName != null ? !unitName.equals(that.unitName) : that.unitName != null) return false;
        if (hireStart != null ? !hireStart.equals(that.hireStart) : that.hireStart != null) return false;
        return !(hireFinish != null ? !hireFinish.equals(that.hireFinish) : that.hireFinish != null);

    }

    @Override
    public int hashCode() {
        int result = empCode != null ? empCode.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (unitName != null ? unitName.hashCode() : 0);
        result = 31 * result + (hireStart != null ? hireStart.hashCode() : 0);
        result = 31 * result + (hireFinish != null ? hireFinish.hashCode() : 0);
        return result;
    }
}
