package org.crazydog.serviceI.impl.searchmodel;

import java.sql.Timestamp;

/**
 * Created by never on 2015/8/28.
 */
public class ContractSearch extends Search<ContractSearch> {

    private String empCode;
    private String name;
    private String unitName;
    private Timestamp hireStart;
    private Timestamp hireFinish;

    public ContractSearch(String empCode, String name, String unitName, Timestamp hireStart, Timestamp hireFinish) {
        this.empCode = empCode;
        this.name = name;
        this.unitName = unitName;
        this.hireStart = hireStart;
        this.hireFinish = hireFinish;
    }

    @Override
    public String advanceSearch(ContractSearch model) {
        //记录缓存数据
        if (model.equals(this))
            return buffer.toString();

        this.empCode = model.empCode;
        this.name = model.name;
        this.unitName = model.unitName;
        this.hireStart = model.hireStart;
        this.hireFinish = model.hireFinish;

        buffer.delete(0, buffer.capacity());
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
        buffer.delete(buffer.capacity() - 3, buffer.capacity());

        return buffer.toString();
    }
}
