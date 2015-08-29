package org.crazydog.domain;

import org.crazydog.domain.tmp.ContractChangeEntity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by never on 2015/8/29.
 */
@Entity
@Table(name = "contract", schema = "", catalog = "crazydog")
public class ContractEntity {
    private Integer id;
    private Integer empId;
    private Date contractStart;
    private Date contractEnd;

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
    @Column(name = "contract_start")
    public Date getContractStart() {
        return contractStart;
    }

    public void setContractStart(Date contractStart) {
        this.contractStart = contractStart;
    }

    @Basic
    @Column(name = "contract_end")
    public Date getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(Date contractEnd) {
        this.contractEnd = contractEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContractEntity that = (ContractEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (empId != null ? !empId.equals(that.empId) : that.empId != null) return false;
        if (contractStart != null ? !contractStart.equals(that.contractStart) : that.contractStart != null)
            return false;
        if (contractEnd != null ? !contractEnd.equals(that.contractEnd) : that.contractEnd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (empId != null ? empId.hashCode() : 0);
        result = 31 * result + (contractStart != null ? contractStart.hashCode() : 0);
        result = 31 * result + (contractEnd != null ? contractEnd.hashCode() : 0);
        return result;
    }

    private EmployeeEntity employeeByEmpId;
    private Collection<ContractChangeEntity> contractChangesById;

    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "id", nullable = false)
    public EmployeeEntity getEmployeeByEmpId() {
        return employeeByEmpId;
    }

    public void setEmployeeByEmpId(EmployeeEntity employeeByEmpId) {
        this.employeeByEmpId = employeeByEmpId;
    }

    @OneToMany(mappedBy = "contractByContractId")
    public Collection<ContractChangeEntity> getContractChangesById() {
        return contractChangesById;
    }

    public void setContractChangesById(Collection<ContractChangeEntity> contractChangesById) {
        this.contractChangesById = contractChangesById;
    }
}
