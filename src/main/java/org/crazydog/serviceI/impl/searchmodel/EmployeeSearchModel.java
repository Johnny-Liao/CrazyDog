package org.crazydog.serviceI.impl.searchmodel;

/**
 * Created by never on 2015/8/28.
 */
public class EmployeeSearchModel extends SearchModel {
    private String name;
    private String unitName;
    private ResumeSearchModel.Edu edu;


    public EmployeeSearchModel(String name, String unitName, ResumeSearchModel.Edu edu) {
        this.name = name;
        this.unitName = unitName;
        this.edu = edu;
    }

    @Override
    protected StringBuffer advanceSearch() {
        if (name == null && unitName == null && edu == null)
            return null;
        buffer.append("from EmployeeEntity emp where ");
        if (name != null)
            buffer.append(" emp.empName='" + name + "' and");
        if (unitName != null)
            buffer.append(" emp.unitByUnitId.unitName='" + unitName + "' and");
        if (edu != null)
            buffer.append(" emp.education='" + edu + "' and");

        return buffer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeSearchModel that = (EmployeeSearchModel) o;

        if (!name.equals(that.name)) return false;
        if (!unitName.equals(that.unitName)) return false;
        return edu == that.edu;

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + unitName.hashCode();
        result = 31 * result + edu.hashCode();
        return result;
    }
}
