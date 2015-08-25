package org.crazydog.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by never on 2015/8/24.
 */
@Entity
@javax.persistence.Table(name = "resume", schema = "", catalog = "crazydog")
public class ResumeEntity {
    private Integer id;

    @Id
    @javax.persistence.Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String name;

    @Basic
    @javax.persistence.Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Timestamp birthday;

    @Basic
    @javax.persistence.Column(name = "birthday")
    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    private String nation;

    @Basic
    @javax.persistence.Column(name = "nation")
    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    private String gender;

    @Basic
    @javax.persistence.Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String zzmm;

    @Basic
    @javax.persistence.Column(name = "zzmm")
    public String getZzmm() {
        return zzmm;
    }

    public void setZzmm(String zzmm) {
        this.zzmm = zzmm;
    }

    private String hyzk;

    @Basic
    @javax.persistence.Column(name = "hyzk")
    public String getHyzk() {
        return hyzk;
    }

    public void setHyzk(String hyzk) {
        this.hyzk = hyzk;
    }

    private String education;

    @Basic
    @javax.persistence.Column(name = "education")
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    private Timestamp workTime;

    @Basic
    @javax.persistence.Column(name = "work_time")
    public Timestamp getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Timestamp workTime) {
        this.workTime = workTime;
    }

    private String jjsp;

    @Basic
    @javax.persistence.Column(name = "jjsp")
    public String getJjsp() {
        return jjsp;
    }

    public void setJjsp(String jjsp) {
        this.jjsp = jjsp;
    }

    private String profession;

    @Basic
    @javax.persistence.Column(name = "profession")
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    private Integer zipCode;

    @Basic
    @javax.persistence.Column(name = "zip_code")
    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    private String homeTown;

    @Basic
    @javax.persistence.Column(name = "home_town")
    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    private String foreignLang;

    @Basic
    @javax.persistence.Column(name = "foreign_lang")
    public String getForeignLang() {
        return foreignLang;
    }

    public void setForeignLang(String foreignLang) {
        this.foreignLang = foreignLang;
    }

    private String specialty;

    @Basic
    @javax.persistence.Column(name = "specialty")
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    private String yysp;

    @Basic
    @javax.persistence.Column(name = "yysp")
    public String getYysp() {
        return yysp;
    }

    public void setYysp(String yysp) {
        this.yysp = yysp;
    }

    private Integer jndj;

    @Basic
    @javax.persistence.Column(name = "jndj")
    public Integer getJndj() {
        return jndj;
    }

    public void setJndj(Integer jndj) {
        this.jndj = jndj;
    }

    private Double height;

    @Basic
    @javax.persistence.Column(name = "height")
    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    private Integer tel;

    @Basic
    @javax.persistence.Column(name = "tel")
    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    private String idCard;

    @Basic
    @javax.persistence.Column(name = "id_card")
    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    private String hukou;

    @Basic
    @javax.persistence.Column(name = "hukou")
    public String getHukou() {
        return hukou;
    }

    public void setHukou(String hukou) {
        this.hukou = hukou;
    }

    private String hukouAddress;

    @Basic
    @javax.persistence.Column(name = "hukou_address")
    public String getHukouAddress() {
        return hukouAddress;
    }

    public void setHukouAddress(String hukouAddress) {
        this.hukouAddress = hukouAddress;
    }

    private Integer homePhone;

    @Basic
    @javax.persistence.Column(name = "home_phone")
    public Integer getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(Integer homePhone) {
        this.homePhone = homePhone;
    }

    private String address;

    @Basic
    @javax.persistence.Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String reportCard;

    @Basic
    @javax.persistence.Column(name = "report_card")
    public String getReportCard() {
        return reportCard;
    }

    public void setReportCard(String reportCard) {
        this.reportCard = reportCard;
    }

    private String email;

    @Basic
    @javax.persistence.Column(name = "email")
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

	@Override
	public String toString() {
		return "ResumeEntity [id=" + id + ", name=" + name + ", birthday="
				+ birthday + ", nation=" + nation + ", gender=" + gender
				+ ", zzmm=" + zzmm + ", hyzk=" + hyzk + ", education="
				+ education + ", workTime=" + workTime + ", jjsp=" + jjsp
				+ ", profession=" + profession + ", zipCode=" + zipCode
				+ ", homeTown=" + homeTown + ", foreignLang=" + foreignLang
				+ ", specialty=" + specialty + ", yysp=" + yysp + ", jndj="
				+ jndj + ", height=" + height + ", tel=" + tel + ", idCard="
				+ idCard + ", hukou=" + hukou + ", hukouAddress="
				+ hukouAddress + ", homePhone=" + homePhone + ", address="
				+ address + ", reportCard=" + reportCard + ", email=" + email
				+ "]";
	}
    
}