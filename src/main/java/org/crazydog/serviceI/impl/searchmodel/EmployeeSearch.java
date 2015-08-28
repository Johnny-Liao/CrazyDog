package org.crazydog.serviceI.impl.searchmodel;

/**
 * Created by never on 2015/8/28.
 */
public class EmployeeSearch extends Search<EmployeeSearch> {
    private String name;
    private String unitName;
    private ResumeSearch.Edu edu;


    public EmployeeSearch(String name, String unitName, ResumeSearch.Edu edu) {
        this.name = name;
        this.unitName = unitName;
        this.edu = edu;
    }

    @Override
    public String advanceSearch(EmployeeSearch model) {
        //记录缓存数据
        if (model.equals(this))
            return buffer.toString();

        this.name = model.name;
        this.unitName = model.unitName;
        this.edu = model.edu;

        buffer.delete(0, buffer.capacity());
        if (name == null && unitName == null && edu == null)
            return null;
        buffer.append("from EmployeeEntity emp where ");
        if (name != null)
            buffer.append(" emp.empName='" + name + "' and");
        if (unitName != null)
            buffer.append(" emp.unitByUnitId.unitName='" + unitName + "' and");
        if (edu != null)
            buffer.append(" emp.education='" + edu + "' and");
        buffer.delete(buffer.capacity() - 3, buffer.capacity());

        return buffer.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeSearch that = (EmployeeSearch) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (unitName != null ? !unitName.equals(that.unitName) : that.unitName != null) return false;
        return edu == that.edu;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (unitName != null ? unitName.hashCode() : 0);
        result = 31 * result + (edu != null ? edu.hashCode() : 0);
        return result;
    }


}
