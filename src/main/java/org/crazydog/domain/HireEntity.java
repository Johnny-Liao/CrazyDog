package org.crazydog.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by never on 2015/8/24.
 */
@Entity
@Table(name = "hire", schema = "", catalog = "crazydog")
public class HireEntity {
    private Integer id;
    private Integer resumeId;
    private String state;
    private String declineCause;
    private String comment;
    private Timestamp operateTime;
    private String operator;

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
    @Column(name = "STATE")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "decline_cause")
    public String getDeclineCause() {
        return declineCause;
    }

    public void setDeclineCause(String declineCause) {
        this.declineCause = declineCause;
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
    public Timestamp getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Timestamp operateTime) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HireEntity that = (HireEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (resumeId != null ? !resumeId.equals(that.resumeId) : that.resumeId != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (declineCause != null ? !declineCause.equals(that.declineCause) : that.declineCause != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (operateTime != null ? !operateTime.equals(that.operateTime) : that.operateTime != null) return false;
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (resumeId != null ? resumeId.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (declineCause != null ? declineCause.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (operateTime != null ? operateTime.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        return result;
    }
}