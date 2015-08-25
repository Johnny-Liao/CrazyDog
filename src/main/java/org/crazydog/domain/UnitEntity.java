package org.crazydog.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by never on 2015/8/24.
 */
@Entity
@Table(name = "unit", schema = "", catalog = "crazydog")
public class UnitEntity {
    private Integer id;
    private String unitCode;
    private String unitName;
    private Collection<ContractChangeEntity> contractChangesById;
    private Collection<DepartmentEntity> departmentsById;
    private Collection<EmployeeEntity> employeesById;

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
    @Column(name = "unit_code")
    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    @Basic
    @Column(name = "unit_name")
    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnitEntity that = (UnitEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (unitCode != null ? !unitCode.equals(that.unitCode) : that.unitCode != null) return false;
        if (unitName != null ? !unitName.equals(that.unitName) : that.unitName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (unitCode != null ? unitCode.hashCode() : 0);
        result = 31 * result + (unitName != null ? unitName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "unitByUnitId")
    public Collection<ContractChangeEntity> getContractChangesById() {
        return contractChangesById;
    }

    public void setContractChangesById(Collection<ContractChangeEntity> contractChangesById) {
        this.contractChangesById = contractChangesById;
    }

    @OneToMany(mappedBy = "unitByUnitId")
    public Collection<DepartmentEntity> getDepartmentsById() {
        return departmentsById;
    }

    public void setDepartmentsById(Collection<DepartmentEntity> departmentsById) {
        this.departmentsById = departmentsById;
    }

    @OneToMany(mappedBy = "unitByUnitId")
    public Collection<EmployeeEntity> getEmployeesById() {
        return employeesById;
    }

    public void setEmployeesById(Collection<EmployeeEntity> employeesById) {
        this.employeesById = employeesById;
    }
}