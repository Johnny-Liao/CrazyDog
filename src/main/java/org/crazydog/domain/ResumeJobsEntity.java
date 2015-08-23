package org.crazydog.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by never on 2015/8/23.
 */
@Entity
@Table(name = "resume_jobs", schema = "", catalog = "crazydog")
public class ResumeJobsEntity {
    private Integer id;
    private Integer resumeId;
    private Timestamp startTime;
    private Timestamp endTime;
    private String departmennt;
    private String post;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "resume_id", nullable = false, insertable = true, updatable = true)
    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    @Basic
    @Column(name = "start_time", nullable = false, insertable = true, updatable = true)
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time", nullable = false, insertable = true, updatable = true)
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "departmennt", nullable = false, insertable = true, updatable = true, length = 255)
    public String getDepartmennt() {
        return departmennt;
    }

    public void setDepartmennt(String departmennt) {
        this.departmennt = departmennt;
    }

    @Basic
    @Column(name = "Post", nullable = false, insertable = true, updatable = true, length = 255)
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResumeJobsEntity that = (ResumeJobsEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (resumeId != null ? !resumeId.equals(that.resumeId) : that.resumeId != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (departmennt != null ? !departmennt.equals(that.departmennt) : that.departmennt != null) return false;
        if (post != null ? !post.equals(that.post) : that.post != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (resumeId != null ? resumeId.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (departmennt != null ? departmennt.hashCode() : 0);
        result = 31 * result + (post != null ? post.hashCode() : 0);
        return result;
    }
}
