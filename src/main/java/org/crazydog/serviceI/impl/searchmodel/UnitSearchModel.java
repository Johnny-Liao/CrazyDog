package org.crazydog.serviceI.impl.searchmodel;

/**
 * 必须保证传递进来的对象的所有字段不全都为空
 * Created by never on 2015/8/28.
 */
public class UnitSearchModel extends SearchModel {
    //单位编码
    private String unitCode;
    //单位名称
    private String unitName;

    public UnitSearchModel(String unitCode, String unitName) {
        this.unitCode = unitCode;
        this.unitName = unitName;
    }

    public StringBuffer advanceSearch() {
        if (unitName == null && unitCode == null)
            return null;

        buffer.append("from UnitEntity unit where ");
        if (unitName != null)
            buffer.append(" unit.unitName='" + unitName + "' and");
        if (unitCode != null)
            buffer.append(" unit.unitName='" + unitCode + "' and");

        return buffer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnitSearchModel that = (UnitSearchModel) o;

        if (!unitCode.equals(that.unitCode)) return false;
        return unitName.equals(that.unitName);

    }

    @Override
    public int hashCode() {
        int result = unitCode.hashCode();
        result = 31 * result + unitName.hashCode();
        return result;
    }
}
