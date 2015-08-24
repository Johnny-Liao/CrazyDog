package org.crazydog.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by never on 2015/8/23.
 */
@Entity
@Table(name = "resume", schema = "", catalog = "crazydog")
public class ResumeEntity {
    private Integer id;
    private String name;
    private Timestamp birthday;
    private String nation;
    private String gender;
    private String zzmm;
    private String hyzk;
    private String education;
    private Timestamp workTime;
    private String jjsp;
    private String profession;
    private Integer zipCode;
    private String homeTown;
    private String foreignLang;
    private String specialty;
    private String yysp;
    private Integer jndj;
    private Double height;
    private Integer tel;
    private String idCard;
    private String hukou;
    private String hukouAddress;
    private Integer homePhone;
    private String address;
    private String reportCard;
    private String email;
    private Collection<EmployeeEntity> employeesById;
    private Collection<HireEntity> hiresById;
    private Collection<ResumeEduEntity> resumeEdusById;
    private Collection<ResumeFamilyEntity> resumeFamiliesById;
    private Collection<ResumeJobsEntity> resumeJobsesById;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "birthday", nullable = true, insertable = true, updatable = true)
    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "nation", nullable = false, insertable = true, updatable = true, length = 20)
    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Basic
    @Column(name = "gender", nullable = true, insertable = true, updatable = true, length = 2)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "zzmm", nullable = true, insertable = true, updatable = true, length = 3)
    public String getZzmm() {
        return zzmm;
    }

    public void setZzmm(String zzmm) {
        this.zzmm = zzmm;
    }

    @Basic
    @Column(name = "hyzk", nullable = true, insertable = true, updatable = true, length = 3)
    public String getHyzk() {
        return hyzk;
    }

    public void setHyzk(String hyzk) {
        this.hyzk = hyzk;
    }

    @Basic
    @Column(name = "education", nullable = true, insertable = true, updatable = true, length = 3)
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Basic
    @Column(name = "work_time", nullable = true, insertable = true, updatable = true)
    public Timestamp getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Timestamp workTime) {
        this.workTime = workTime;
    }

    @Basic
    @Column(name = "jjsp", nullable = true, insertable = true, updatable = true, length = 3)
    public String getJjsp() {
        return jjsp;
    }

    public void setJjsp(String jjsp) {
        this.jjsp = jjsp;
    }

    @Basic
    @Column(name = "profession", nullable = true, insertable = true, updatable = true, length = 10)
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Basic
    @Column(name = "zip_code", nullable = true, insertable = true, updatable = true)
    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    @Basic
    @Column(name = "home_town", nullable = true, insertable = true, updatable = true, length = 50)
    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    @Basic
    @Column(name = "foreign_lang", nullable = true, insertable = true, updatable = true, length = 50)
    public String getForeignLang() {
        return foreignLang;
    }

    public void setForeignLang(String foreignLang) {
        this.foreignLang = foreignLang;
    }

    @Basic
    @Column(name = "specialty", nullable = true, insertable = true, updatable = true, length = 30)
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Basic
    @Column(name = "yysp", nullable = true, insertable = true, updatable = true, length = 20)
    public String getYysp() {
        return yysp;
    }

    public void setYysp(String yysp) {
        this.yysp = yysp;
    }

    @Basic
    @Column(name = "jndj", nullable = true, insertable = true, updatable = true)
    public Integer getJndj() {
        return jndj;
    }

    public void setJndj(Integer jndj) {
        this.jndj = jndj;
    }

    @Basic
    @Column(name = "height", nullable = true, insertable = true, updatable = true, precision = 0)
    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Basic
    @Column(name = "tel", nullable = false, insertable = true, updatable = true)
    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "id_card", nullable = false, insertable = true, updatable = true, length = 20)
    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Basic
    @Column(name = "hukou", nullable = true, insertable = true, updatable = true, length = 5)
    public String getHukou() {
        return hukou;
    }

    public void setHukou(String hukou) {
        this.hukou = hukou;
    }

    @Basic
    @Column(name = "hukou_address", nullable = true, insertable = true, updatable = true, length = 50)
    public String getHukouAddress() {
        return hukouAddress;
    }

    public void setHukouAddress(String hukouAddress) {
        this.hukouAddress = hukouAddress;
    }

    @Basic
    @Column(name = "home_phone", nullable = true, insertable = true, updatable = true)
    public Integer getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(Integer homePhone) {
        this.homePhone = homePhone;
    }

    @Basic
    @Column(name = "address", nullable = true, insertable = true, updatable = true, length = 30)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "report_card", nullable = true, insertable = true, updatable = true, length = 2)
    public String getReportCard() {
        return reportCard;
    }

    public void setReportCard(String reportCard) {
        this.reportCard = reportCard;
    }

    @Basic
    @Column(name = "email", nullable = false, insertable = true, updatable = true, length = 20)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResumeEntity that = (ResumeEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (nation != null ? !nation.equals(that.nation) : that.nation != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (zzmm != null ? !zzmm.equals(that.zzmm) : that.zzmm != null) return false;
        if (hyzk != null ? !hyzk.equals(that.hyzk) : that.hyzk != null) return false;
        if (education != null ? !education.equals(that.education) : that.education != null) return false;
        if (workTime != null ? !workTime.equals(that.workTime) : that.workTime != null) return false;
        if (jjsp != null ? !jjsp.equals(that.jjsp) : that.jjsp != null) return false;
        if (profession != null ? !profession.equals(that.profession) : that.profession != null) return false;
        if (zipCode != null ? !zipCode.equals(that.zipCode) : that.zipCode != null) return false;
        if (homeTown != null ? !homeTown.equals(that.homeTown) : that.homeTown != null) return false;
        if (foreignLang != null ? !foreignLang.equals(that.foreignLang) : that.foreignLang != null) return false;
        if (specialty != null ? !specialty.equals(that.specialty) : that.specialty != null) return false;
        if (yysp != null ? !yysp.equals(that.yysp) : that.yysp != null) return false;
        if (jndj != null ? !jndj.equals(that.jndj) : that.jndj != null) return false;
        if (height != null ? !height.equals(that.height) : that.height != null) return false;
        if (tel != null ? !tel.equals(that.tel) : that.tel != null) return false;
        if (idCard != null ? !idCard.equals(that.idCard) : that.idCard != null) return false;
        if (hukou != null ? !hukou.equals(that.hukou) : that.hukou != null) return false;
        if (hukouAddress != null ? !hukouAddress.equals(that.hukouAddress) : that.hukouAddress != null) return false;
        if (homePhone != null ? !homePhone.equals(that.homePhone) : that.homePhone != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (reportCard != null ? !reportCard.equals(that.reportCard) : that.reportCard != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (nation != null ? nation.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (zzmm != null ? zzmm.hashCode() : 0);
        result = 31 * result + (hyzk != null ? hyzk.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (workTime != null ? workTime.hashCode() : 0);
        result = 31 * result + (jjsp != null ? jjsp.hashCode() : 0);
        result = 31 * result + (profession != null ? profession.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (homeTown != null ? homeTown.hashCode() : 0);
        result = 31 * result + (foreignLang != null ? foreignLang.hashCode() : 0);
        result = 31 * result + (specialty != null ? specialty.hashCode() : 0);
        result = 31 * result + (yysp != null ? yysp.hashCode() : 0);
        result = 31 * result + (jndj != null ? jndj.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (idCard != null ? idCard.hashCode() : 0);
        result = 31 * result + (hukou != null ? hukou.hashCode() : 0);
        result = 31 * result + (hukouAddress != null ? hukouAddress.hashCode() : 0);
        result = 31 * result + (homePhone != null ? homePhone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (reportCard != null ? reportCard.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "resumeByResumeId")
    public Collection<EmployeeEntity> getEmployeesById() {
        return employeesById;
    }

    public void setEmployeesById(Collection<EmployeeEntity> employeesById) {
        this.employeesById = employeesById;
    }

    @OneToMany(mappedBy = "resumeByResumeId")
    public Collection<HireEntity> getHiresById() {
        return hiresById;
    }

    public void setHiresById(Collection<HireEntity> hiresById) {
        this.hiresById = hiresById;
    }

    @OneToMany(mappedBy = "resumeByResumeId")
    public Collection<ResumeEduEntity> getResumeEdusById() {
        return resumeEdusById;
    }

    public void setResumeEdusById(Collection<ResumeEduEntity> resumeEdusById) {
        this.resumeEdusById = resumeEdusById;
    }

    @OneToMany(mappedBy = "resumeByResumeId")
    public Collection<ResumeFamilyEntity> getResumeFamiliesById() {
        return resumeFamiliesById;
    }

    public void setResumeFamiliesById(Collection<ResumeFamilyEntity> resumeFamiliesById) {
        this.resumeFamiliesById = resumeFamiliesById;
    }

    @OneToMany(mappedBy = "resumeByResumeId")
    public Collection<ResumeJobsEntity> getResumeJobsesById() {
        return resumeJobsesById;
    }

    public void setResumeJobsesById(Collection<ResumeJobsEntity> resumeJobsesById) {
        this.resumeJobsesById = resumeJobsesById;
    }
}
