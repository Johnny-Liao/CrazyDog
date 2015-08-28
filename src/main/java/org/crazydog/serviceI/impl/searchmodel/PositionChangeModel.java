package org.crazydog.serviceI.impl.searchmodel;

import java.sql.Timestamp;

/**
 * Created by never on 2015/8/28.
 */
public class PositionChangeModel extends Search<PositionChangeModel> {

    //职位这个字段在应用中基本没用到，基本没有指定一个职员的职位
    //    private String position;
    private Timestamp hireStart;
    private Timestamp hirefinish;
    private String leaveInfo;
    private String unitName;
    private String name;

    public PositionChangeModel(String name, String unitName /*,String position,*/, String leaveInfo, Timestamp hireStart, Timestamp hirefinish) {
//        this.position = position;
        this.name = name;
        this.unitName = unitName;
        this.hireStart = hireStart;
        this.hirefinish = hirefinish;
        this.leaveInfo = leaveInfo;
    }

    @Override
    public String advanceSearch(PositionChangeModel model) {
        //记录缓存数据
        if (model.equals(this))
            return buffer.toString();

//        this.position = model.position;
        this.name = model.name;
        this.unitName = model.unitName;
        this.hireStart = model.hireStart;
        this.hirefinish = model.hirefinish;
        this.leaveInfo = model.leaveInfo;

        buffer.delete(0, buffer.capacity());
        if (/*position == null &&*/ hireStart == null && hirefinish == null)
            return null;
        buffer.append("from EmployeeEntity emp,PositionChangeEntity pos where ");
//        if (position != null)
//            buffer.append(" emp.empName='" + name + "' and");
        if (name != null)
            buffer.append(" emp.empName=='" + name + "' and");
        if (unitName != null)
            buffer.append(" emp.unitByUnitId.unitName='" + unitName + "' and");
        if (leaveInfo != null)
            buffer.append(" pos.leaveInfo='" + leaveInfo + "' and");
        if (hireStart != null)
            buffer.append(" pos.joinDate>='" + hireStart + "' and");
        if (hirefinish != null)
            buffer.append(" emp.leaveDate<='" + hirefinish + "' and");
        buffer.delete(buffer.capacity() - 3, buffer.capacity());

        return buffer.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PositionChangeModel that = (PositionChangeModel) o;

        if (hireStart != null ? !hireStart.equals(that.hireStart) : that.hireStart != null) return false;
        if (hirefinish != null ? !hirefinish.equals(that.hirefinish) : that.hirefinish != null) return false;
        if (leaveInfo != null ? !leaveInfo.equals(that.leaveInfo) : that.leaveInfo != null) return false;
        if (unitName != null ? !unitName.equals(that.unitName) : that.unitName != null) return false;
        return !(name != null ? !name.equals(that.name) : that.name != null);

    }

    @Override
    public int hashCode() {
        int result = hireStart != null ? hireStart.hashCode() : 0;
        result = 31 * result + (hirefinish != null ? hirefinish.hashCode() : 0);
        result = 31 * result + (leaveInfo != null ? leaveInfo.hashCode() : 0);
        result = 31 * result + (unitName != null ? unitName.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
