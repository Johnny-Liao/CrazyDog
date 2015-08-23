package org.crazydog.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by never on 2015/8/23.
 */
@Entity
@Table(name = "contract", schema = "", catalog = "crazydog")
public class ContractEntity {
    private Integer id;
    private Integer empId;
    private Timestamp contractStart;
    private Timestamp contractEnd;
    private Integer length;
    private EmployeeEntity employeeByEmpId;
    private Collection<ContractChangeEntity> contractChangesById;

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
    @Column(name = "contract_start", nullable = false, insertable = true, updatable = true)
    public Timestamp getContractStart() {
        return contractStart;
    }

    public void setContractStart(Timestamp contractStart) {
        this.contractStart = contractStart;
    }

    @Basic
    @Column(name = "contract_end", nullable = false, insertable = true, updatable = true)
    public Timestamp getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(Timestamp contractEnd) {
        this.contractEnd = contractEnd;
    }

    @Basic
    @Column(name = "length", nullable = false, insertable = true, updatable = true)
    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
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
        if (length != null ? !length.equals(that.length) : that.length != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (empId != null ? empId.hashCode() : 0);
        result = 31 * result + (contractStart != null ? contractStart.hashCode() : 0);
        result = 31 * result + (contractEnd != null ? contractEnd.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
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

    @OneToMany(mappedBy = "contractByContractId")
    public Collection<ContractChangeEntity> getContractChangesById() {
        return contractChangesById;
    }

    public void setContractChangesById(Collection<ContractChangeEntity> contractChangesById) {
        this.contractChangesById = contractChangesById;
    }
}
