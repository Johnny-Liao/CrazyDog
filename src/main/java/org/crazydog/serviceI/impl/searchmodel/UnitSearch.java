package org.crazydog.serviceI.impl.searchmodel;

/**
 * 必须保证传递进来的对象的所有字段不全都为空
 * Created by never on 2015/8/28.
 */
public class UnitSearch extends Search<UnitSearch> {
    //单位编码
    private String unitCode;
    //单位名称
    private String unitName;

    public UnitSearch(String unitCode, String unitName) {
        this.unitCode = unitCode;
        this.unitName = unitName;
    }

    public String advanceSearch(UnitSearch model) {
        //记录缓存数据
        if (model.equals(this))
            return buffer.toString();

        this.unitCode = model.unitCode;
        this.unitName = model.unitName;

        buffer.delete(0, buffer.capacity());

        if (unitName == null && unitCode == null)
            return null;
        if (unitName == null && unitCode != null)
            buffer.append("from UnitEntity unit where unit.unitCode='" + unitCode + "'");
        if (unitName != null && unitCode == null)
            buffer.append("from UnitEntity unit where unit.unitName='" + unitName + "'");
        if (unitName != null && unitCode != null)
            buffer.append("from UnitEntity unit where unit.unitName='" + unitName + "' and unit.unitCode='" + unitCode + "'");
        return buffer.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnitSearch that = (UnitSearch) o;

        if (unitCode != null ? !unitCode.equals(that.unitCode) : that.unitCode != null) return false;
        if (unitName != null ? !unitName.equals(that.unitName) : that.unitName != null) return false;
        return !(buffer != null ? !buffer.equals(that.buffer) : that.buffer != null);

    }

    @Override
    public int hashCode() {
        int result = unitCode != null ? unitCode.hashCode() : 0;
        result = 31 * result + (unitName != null ? unitName.hashCode() : 0);
        result = 31 * result + (buffer != null ? buffer.hashCode() : 0);
        return result;
    }
}
