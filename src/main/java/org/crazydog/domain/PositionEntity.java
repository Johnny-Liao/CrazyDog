package org.crazydog.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by never on 2015/8/23.
 */
@Entity
@Table(name = "position", schema = "", catalog = "crazydog")
public class PositionEntity {
    private Integer id;
    private Integer empId;
    private Timestamp joinDate;
    private Timestamp leaveDate;
    private String leaveInfo;
    private String leaveComment;
    private EmployeeEntity employeeByEmpId;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "emp_id", nullable = false, insertable = true, updatable = true)
    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @Basic
    @Column(name = "join_date", nullable = false, insertable = true, updatable = true)
    public Timestamp getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Timestamp joinDate) {
        this.joinDate = joinDate;
    }

    @Basic
    @Column(name = "leave_date", nullable = true, insertable = true, updatable = true)
    public Timestamp getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Timestamp leaveDate) {
        this.leaveDate = leaveDate;
    }

    @Basic
    @Column(name = "leave_info", nullable = true, insertable = true, updatable = true, length = 20)
    public String getLeaveInfo() {
        return leaveInfo;
    }

    public void setLeaveInfo(String leaveInfo) {
        this.leaveInfo = leaveInfo;
    }

    @Basic
    @Column(name = "leave_comment", nullable = true, insertable = true, updatable = true, length = 200)
    public String getLeaveComment() {
        return leaveComment;
    }

    public void setLeaveComment(String leaveComment) {
        this.leaveComment = leaveComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PositionEntity that = (PositionEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (empId != null ? !empId.equals(that.empId) : that.empId != null) return false;
        if (joinDate != null ? !joinDate.equals(that.joinDate) : that.joinDate != null) return false;
        if (leaveDate != null ? !leaveDate.equals(that.leaveDate) : that.leaveDate != null) return false;
        if (leaveInfo != null ? !leaveInfo.equals(that.leaveInfo) : that.leaveInfo != null) return false;
        if (leaveComment != null ? !leaveComment.equals(that.leaveComment) : that.leaveComment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (empId != null ? empId.hashCode() : 0);
        result = 31 * result + (joinDate != null ? joinDate.hashCode() : 0);
        result = 31 * result + (leaveDate != null ? leaveDate.hashCode() : 0);
        result = 31 * result + (leaveInfo != null ? leaveInfo.hashCode() : 0);
        result = 31 * result + (leaveComment != null ? leaveComment.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "id", nullable = false)
    public EmployeeEntity getEmployeeByEmpId() {
        return employeeByEmpId;
    }

    public void setEmployeeByEmpId(EmployeeEntity employeeByEmpId) {
        this.employeeByEmpId = employeeByEmpId;
    }
}
