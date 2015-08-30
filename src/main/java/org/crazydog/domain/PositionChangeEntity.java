package org.crazydog.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by never on 2015/8/29.
 */
@Entity
@Table(name = "position_change", schema = "", catalog = "crazydog")
public class PositionChangeEntity {
    private Integer id;
    //    private Integer empId;
    private Date changeTime;
    private String changeCause;
    private UnitEntity unitByBeforUnitId;
    private DepartmentEntity departmentByBeforDeptId;
    private UnitEntity unitByAfterUnitId;
    private DepartmentEntity departmentByAfterDeptId;
    private EmployeeEntity employeeEntity;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    @Basic
//    @Column(name = "emp_id")
//    public Integer getEmpId() {
//        return empId;
//    }
//
//    public void setEmpId(Integer empId) {
//        this.empId = empId;
//    }


    @Basic
    @Column(name = "change_time")
    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    @Basic
    @Column(name = "change_cause")
    public String getChangeCause() {
        return changeCause;
    }

    public void setChangeCause(String changeCause) {
        this.changeCause = changeCause;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PositionChangeEntity that = (PositionChangeEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
//        if (empId != null ? !empId.equals(that.empId) : that.empId != null) return false;
        if (changeTime != null ? !changeTime.equals(that.changeTime) : that.changeTime != null) return false;
        if (changeCause != null ? !changeCause.equals(that.changeCause) : that.changeCause != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
//        result = 31 * result + (empId != null ? empId.hashCode() : 0);
        result = 31 * result + (changeTime != null ? changeTime.hashCode() : 0);
        result = 31 * result + (changeCause != null ? changeCause.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "befor_unit_id", referencedColumnName = "id", nullable = false)
    public UnitEntity getUnitByBeforUnitId() {
        return unitByBeforUnitId;
    }

    public void setUnitByBeforUnitId(UnitEntity unitByBeforUnitId) {
        this.unitByBeforUnitId = unitByBeforUnitId;
    }

    @ManyToOne
    @JoinColumn(name = "befor_dept_id", referencedColumnName = "id", nullable = false)
    public DepartmentEntity getDepartmentByBeforDeptId() {
        return departmentByBeforDeptId;
    }

    public void setDepartmentByBeforDeptId(DepartmentEntity departmentByBeforDeptId) {
        this.departmentByBeforDeptId = departmentByBeforDeptId;
    }

    @ManyToOne
    @JoinColumn(name = "after_unit_id", referencedColumnName = "id", nullable = false)
    public UnitEntity getUnitByAfterUnitId() {
        return unitByAfterUnitId;
    }

    public void setUnitByAfterUnitId(UnitEntity unitByAfterUnitId) {
        this.unitByAfterUnitId = unitByAfterUnitId;
    }

    @ManyToOne
    @JoinColumn(name = "after_dept_id", referencedColumnName = "id", nullable = false)
    public DepartmentEntity getDepartmentByAfterDeptId() {
        return departmentByAfterDeptId;
    }

    public void setDepartmentByAfterDeptId(DepartmentEntity departmentByAfterDeptId) {
        this.departmentByAfterDeptId = departmentByAfterDeptId;
    }

    @Override
    public String toString() {
        return "PositionChangeEntity{" +
                "id=" + id +
//                ", empId=" + empId +
                ", changeTime=" + changeTime +
                ", changeCause='" + changeCause + '\'' +
                ", unitByBeforUnitId=" + unitByBeforUnitId +
                ", departmentByBeforDeptId=" + departmentByBeforDeptId +
                ", unitByAfterUnitId=" + unitByAfterUnitId +
                ", departmentByAfterDeptId=" + departmentByAfterDeptId +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "id", nullable = false)
    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }
}
