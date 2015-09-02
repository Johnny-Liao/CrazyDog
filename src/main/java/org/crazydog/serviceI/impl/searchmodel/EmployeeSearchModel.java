package org.crazydog.serviceI.impl.searchmodel;

/**
 * Changed by Johnny on 2015/9/01.
 */
public class EmployeeSearchModel extends SearchModel {
    private String id;
    private String name;


    public EmployeeSearchModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    protected StringBuffer advanceSearch() {
        if (id == null && name == null)
            return null;
        buffer.append("from EmployeeEntity emp where ");
        if (id != null)
            buffer.append(" emp.empCode=" + id + " and");
        if (name != null)
            buffer.append(" emp.empName='" + name + "' and");

        return buffer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeSearchModel that = (EmployeeSearchModel) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        return result;
    }
}
