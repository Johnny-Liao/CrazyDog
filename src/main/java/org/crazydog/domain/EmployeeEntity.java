<<<<<<< HEAD
package org.crazydog.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by never on 2015/8/23.
 */
@Entity
@Table(name = "employee", schema = "", catalog = "crazydog")
public class EmployeeEntity {
    private Integer id;
    private String empCode;
    private String empName;
    private String gender;
    private String idNum;
    private Integer tel;
    private String education;
    private Collection<ContractEntity> contractsById;
    private DepartmentEntity departmentByDepId;
    private UnitEntity unitByUnitId;
    private Collection<PositionEntity> positionsById;
    private ResumeEntity resumeByResumeId;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "emp_code", nullable = false, insertable = true, updatable = true, length = 255)
    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    @Basic
    @Column(name = "emp_name", nullable = false, insertable = true, updatable = true, length = 255)
    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Basic
    @Column(name = "gender", nullable = false, insertable = true, updatable = true, length = 2)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "id_num", nullable = false, insertable = true, updatable = true, length = 20)
    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    @Basic
    @Column(name = "tel", nullable = true, insertable = true, updatable = true)
    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "education", nullable = true, insertable = true, updatable = true, length = 3)
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }


   
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeEntity that = (EmployeeEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (empCode != null ? !empCode.equals(that.empCode) : that.empCode != null) return false;
        if (empName != null ? !empName.equals(that.empName) : that.empName != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (idNum != null ? !idNum.equals(that.idNum) : that.idNum != null) return false;
        if (tel != null ? !tel.equals(that.tel) : that.tel != null) return false;
        if (education != null ? !education.equals(that.education) : that.education != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (empCode != null ? empCode.hashCode() : 0);
        result = 31 * result + (empName != null ? empName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (idNum != null ? idNum.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "employeeByEmpId")
    public Collection<ContractEntity> getContractsById() {
        return contractsById;
    }

    public void setContractsById(Collection<ContractEntity> contractsById) {
        this.contractsById = contractsById;
    }

    @ManyToOne
    @JoinColumn(name = "dep_id", referencedColumnName = "id", nullable = false)
    public DepartmentEntity getDepartmentByDepId() {
        return departmentByDepId;
    }

    public void setDepartmentByDepId(DepartmentEntity departmentByDepId) {
        this.departmentByDepId = departmentByDepId;
    }

    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "id", nullable = false)
    public UnitEntity getUnitByUnitId() {
        return unitByUnitId;
    }

    public void setUnitByUnitId(UnitEntity unitByUnitId) {
        this.unitByUnitId = unitByUnitId;
    }

    @OneToMany(mappedBy = "employeeByEmpId")
    public Collection<PositionEntity> getPositionsById() {
        return positionsById;
    }

    public void setPositionsById(Collection<PositionEntity> positionsById) {
        this.positionsById = positionsById;
    }

    @ManyToOne
    @JoinColumn(name = "resume_id", referencedColumnName = "id", nullable = false)
    public ResumeEntity getResumeByResumeId() {
        return resumeByResumeId;
    }

    public void setResumeByResumeId(ResumeEntity resumeByResumeId) {
        this.resumeByResumeId = resumeByResumeId;
    }
}
=======
package org.crazydog.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by never on 2015/8/24.
 */
@Entity
@Table(name = "employee", schema = "", catalog = "crazydog")
public class EmployeeEntity {
    private Integer id;
    private String empCode;
    private String empName;
    private String gender;
    private String idNum;
    private Integer tel;
    private String education;
    private Integer resumeId;
    private Collection<ContractEntity> contractsById;
    private DepartmentEntity departmentByDepId;
    private UnitEntity unitByUnitId;
    private Collection<PositionEntity> positionsById;

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
    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    @Basic
    @Column(name = "emp_name")
    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "id_num")
    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    @Basic
    @Column(name = "tel")
    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "education")
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }


    @Basic
    @Column(name = "resume_id")
    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeEntity that = (EmployeeEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (empCode != null ? !empCode.equals(that.empCode) : that.empCode != null) return false;
        if (empName != null ? !empName.equals(that.empName) : that.empName != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (idNum != null ? !idNum.equals(that.idNum) : that.idNum != null) return false;
        if (tel != null ? !tel.equals(that.tel) : that.tel != null) return false;
        if (education != null ? !education.equals(that.education) : that.education != null) return false;
        if (resumeId != null ? !resumeId.equals(that.resumeId) : that.resumeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (empCode != null ? empCode.hashCode() : 0);
        result = 31 * result + (empName != null ? empName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (idNum != null ? idNum.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (resumeId != null ? resumeId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "employeeByEmpId")
    public Collection<ContractEntity> getContractsById() {
        return contractsById;
    }

    public void setContractsById(Collection<ContractEntity> contractsById) {
        this.contractsById = contractsById;
    }

    @ManyToOne
    @JoinColumn(name = "dep_id", referencedColumnName = "id", nullable = false)
    public DepartmentEntity getDepartmentByDepId() {
        return departmentByDepId;
    }

    public void setDepartmentByDepId(DepartmentEntity departmentByDepId) {
        this.departmentByDepId = departmentByDepId;
    }

    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "id", nullable = false)
    public UnitEntity getUnitByUnitId() {
        return unitByUnitId;
    }

    public void setUnitByUnitId(UnitEntity unitByUnitId) {
        this.unitByUnitId = unitByUnitId;
    }

    @OneToMany(mappedBy = "employeeByEmpId")
    public Collection<PositionEntity> getPositionsById() {
        return positionsById;
    }

    public void setPositionsById(Collection<PositionEntity> positionsById) {
        this.positionsById = positionsById;
    }
}
>>>>>>> bcd33826cccc6660b1d060c59ac9e26753337c6e
