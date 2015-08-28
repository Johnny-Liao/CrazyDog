package org.crazydog.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    private ContractEntity contractsById;
    private DepartmentEntity departmentByDepId;
    private UnitEntity unitByUnitId;
    private Collection<PositionChangeEntity> positionsById;

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
    public String toString() {
        return "EmployeeEntity{" +
                "id=" + id +
                ", empCode='" + empCode + '\'' +
                ", empName='" + empName + '\'' +
                ", gender='" + gender + '\'' +
                ", idNum='" + idNum + '\'' +
                ", tel=" + tel +
                ", education='" + education + '\'' +
                ", resumeId=" + resumeId +
                ", contractsById=" + contractsById +
                ", departmentByDepId=" + departmentByDepId +
                ", unitByUnitId=" + unitByUnitId +
                ", positionsById=" + positionsById +
                '}';
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

    //获取认识信息时顺便把简历信息也读取出来 fetch = FetchType.EAGER
    @OneToOne(mappedBy = "employeeByEmpId", fetch = FetchType.EAGER)
    public ContractEntity getContractsById() {
        return contractsById;
    }

    public void setContractsById(ContractEntity contractsById) {
        this.contractsById = contractsById;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dep_id", referencedColumnName = "id", nullable = false)
    public DepartmentEntity getDepartmentByDepId() {
        return departmentByDepId;
    }

    public void setDepartmentByDepId(DepartmentEntity departmentByDepId) {
        this.departmentByDepId = departmentByDepId;
    }

    //单位就不用取，因为取部门的时候，顺便会取单位的信息，这里在去就是重复查询
    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "id", nullable = false)
    public UnitEntity getUnitByUnitId() {
        return unitByUnitId;
    }

    public void setUnitByUnitId(UnitEntity unitByUnitId) {
        this.unitByUnitId = unitByUnitId;
    }

    //这里添加FetchMode.SUBSELECT，是因为Hibernate默认级联抓取的级数为4级，
    //前面已经多次将FetchType设为EAGER，当这里已经默认已经不允许再取了，这是防止造成大量的数据访问
    //这里的解决方法就是将重新发送一条语句来查，之前所有的值都是在一条语句中使用左连接进行查询
    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "employeeByEmpId", fetch = FetchType.EAGER)
    public Collection<PositionChangeEntity> getPositionsById() {
        return positionsById;
    }

    public void setPositionsById(Collection<PositionChangeEntity> positionsById) {
        this.positionsById = positionsById;
    }
}