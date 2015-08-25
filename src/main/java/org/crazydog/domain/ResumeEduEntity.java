package org.crazydog.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by never on 2015/8/24.
 */
@Entity
@Table(name = "resume_edu", schema = "", catalog = "crazydog")
public class ResumeEduEntity {
    private Integer id;
    private Integer resumeId;
    private Timestamp startTime;
    private Timestamp endTime;
    private String school;
    private String discipline;

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
    @Column(name = "resume_id")
    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    @Basic
    @Column(name = "start_time")
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time")
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "school")
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Basic
    @Column(name = "discipline")
    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResumeEduEntity that = (ResumeEduEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (resumeId != null ? !resumeId.equals(that.resumeId) : that.resumeId != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (school != null ? !school.equals(that.school) : that.school != null) return false;
        if (discipline != null ? !discipline.equals(that.discipline) : that.discipline != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (resumeId != null ? resumeId.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (school != null ? school.hashCode() : 0);
        result = 31 * result + (discipline != null ? discipline.hashCode() : 0);
        return result;
    }
}