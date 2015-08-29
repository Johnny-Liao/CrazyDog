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
    private Integer empId;
    private Integer beforUnitId;
    private Integer beforDeptId;
    private Date changeTime;
    private Integer afterUnitId;
    private Integer afterDeptId;
    private String changeCause;
    private UnitEntity unitByBeforUnitId;
    private DepartmentEntity departmentByBeforDeptId;
    private UnitEntity unitByAfterUnitId;
    private DepartmentEntity departmentByAfterDeptId;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "emp_id")
    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @Basic
    @Column(name = "befor_unit_id")
    public Integer getBeforUnitId() {
        return beforUnitId;
    }

    public void setBeforUnitId(Integer beforUnitId) {
        this.beforUnitId = beforUnitId;
    }

    @Basic
    @Column(name = "befor_dept_id")
    public Integer getBeforDeptId() {
        return beforDeptId;
    }

    public void setBeforDeptId(Integer beforDeptId) {
        this.beforDeptId = beforDeptId;
    }

    @Basic
    @Column(name = "change_time")
    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    @Basic
    @Column(name = "after_unit_id")
    public Integer getAfterUnitId() {
        return afterUnitId;
    }

    public void setAfterUnitId(Integer afterUnitId) {
        this.afterUnitId = afterUnitId;
    }

    @Basic
    @Column(name = "after_dept_id")
    public Integer getAfterDeptId() {
        return afterDeptId;
    }

    public void setAfterDeptId(Integer afterDeptId) {
        this.afterDeptId = afterDeptId;
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
        if (empId != null ? !empId.equals(that.empId) : that.empId != null) return false;
        if (beforUnitId != null ? !beforUnitId.equals(that.beforUnitId) : that.beforUnitId != null) return false;
        if (beforDeptId != null ? !beforDeptId.equals(that.beforDeptId) : that.beforDeptId != null) return false;
        if (changeTime != null ? !changeTime.equals(that.changeTime) : that.changeTime != null) return false;
        if (afterUnitId != null ? !afterUnitId.equals(that.afterUnitId) : that.afterUnitId != null) return false;
        if (afterDeptId != null ? !afterDeptId.equals(that.afterDeptId) : that.afterDeptId != null) return false;
        if (changeCause != null ? !changeCause.equals(that.changeCause) : that.changeCause != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (empId != null ? empId.hashCode() : 0);
        result = 31 * result + (beforUnitId != null ? beforUnitId.hashCode() : 0);
        result = 31 * result + (beforDeptId != null ? beforDeptId.hashCode() : 0);
        result = 31 * result + (changeTime != null ? changeTime.hashCode() : 0);
        result = 31 * result + (afterUnitId != null ? afterUnitId.hashCode() : 0);
        result = 31 * result + (afterDeptId != null ? afterDeptId.hashCode() : 0);
        result = 31 * result + (changeCause != null ? changeCause.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "befor_unit_id", referencedColumnName = "id", nullable = false)
    public UnitEntity getUnitByBeforUnitId() {
        return unitByBeforUnitId;
    }

    public void setUnitByBeforUnitId(UnitEntity unitByBeforUnitId) {
        this.unitByBeforUnitId = unitByBeforUnitId;
    }

    @OneToOne
    @JoinColumn(name = "befor_dept_id", referencedColumnName = "id", nullable = false)
    public DepartmentEntity getDepartmentByBeforDeptId() {
        return departmentByBeforDeptId;
    }

    public void setDepartmentByBeforDeptId(DepartmentEntity departmentByBeforDeptId) {
        this.departmentByBeforDeptId = departmentByBeforDeptId;
    }

    @OneToOne
    @JoinColumn(name = "after_unit_id", referencedColumnName = "id", nullable = false)
    public UnitEntity getUnitByAfterUnitId() {
        return unitByAfterUnitId;
    }

    public void setUnitByAfterUnitId(UnitEntity unitByAfterUnitId) {
        this.unitByAfterUnitId = unitByAfterUnitId;
    }

    @OneToOne
    @JoinColumn(name = "after_dept_id", referencedColumnName = "id", nullable = false)
    public DepartmentEntity getDepartmentByAfterDeptId() {
        return departmentByAfterDeptId;
    }

    public void setDepartmentByAfterDeptId(DepartmentEntity departmentByAfterDeptId) {
        this.departmentByAfterDeptId = departmentByAfterDeptId;
    }
}
