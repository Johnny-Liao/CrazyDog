package org.crazydog.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by never on 2015/8/29.
 */
@Entity
@Table(name = "hire_info", schema = "", catalog = "crazydog")
public class HireInfoEntity {
    private Integer id;
    private String state;
    private String comment;
    private Date operateTime;
    private String operator;
    private ResumeEntity resumeEntity;

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
    @Column(name = "STATE")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "COMMENT")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "operate_time")
    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    @Basic
    @Column(name = "OPERATOR")
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Fetch(FetchMode.SELECT)
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "resume_id", insertable = true, unique = true)
    public ResumeEntity getResumeEntity() {
        return resumeEntity;
    }

    public void setResumeEntity(ResumeEntity resumeEntity) {
        this.resumeEntity = resumeEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HireInfoEntity that = (HireInfoEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (operateTime != null ? !operateTime.equals(that.operateTime) : that.operateTime != null) return false;
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (operateTime != null ? operateTime.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HireInfoEntity{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", comment='" + comment + '\'' +
                ", operateTime=" + operateTime +
                ", operator='" + operator + '\'' +
                '}';
    }
}
