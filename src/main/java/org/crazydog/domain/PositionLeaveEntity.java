package org.crazydog.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by never on 2015/8/29.
 */
@Entity
@Table(name = "position_leave", schema = "", catalog = "crazydog")
public class PositionLeaveEntity {
    private Integer id;
    private Integer empCode;
    private String name;
    private Date leaveDate;
    private String leaveComment;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "emp_code")
    public Integer getEmpCode() {
        return empCode;
    }

    public void setEmpCode(Integer empCode) {
        this.empCode = empCode;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "leave_date")
    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }


    @Basic
    @Column(name = "leave_comment")
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

        PositionLeaveEntity that = (PositionLeaveEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (empCode != null ? !empCode.equals(that.empCode) : that.empCode != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (leaveDate != null ? !leaveDate.equals(that.leaveDate) : that.leaveDate != null) return false;
        if (leaveComment != null ? !leaveComment.equals(that.leaveComment) : that.leaveComment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (empCode != null ? empCode.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (leaveDate != null ? leaveDate.hashCode() : 0);
        result = 31 * result + (leaveComment != null ? leaveComment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PositionLeaveEntity{" +
                "id=" + id +
                ", empCode=" + empCode +
                ", name='" + name + '\'' +
                ", leaveDate=" + leaveDate +
                ", leaveComment='" + leaveComment + '\'' +
                '}';
    }

    private EmployeeEntity employeeEntity;

    @OneToOne(mappedBy = "positionLeaveEntity")
    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }
}
