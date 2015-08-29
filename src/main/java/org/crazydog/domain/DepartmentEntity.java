package org.crazydog.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by never on 2015/8/29.
 */
@Entity
@Table(name = "department", schema = "", catalog = "crazydog")
public class DepartmentEntity {
    private Integer id;
    private String deptName;
    private UnitEntity unitByUnitId;
    private Collection<PositionChangeEntity> positionChangesByBeforeId;
    private Collection<PositionChangeEntity> positionChangesByAfterId;

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
    @Column(name = "dept_name")
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentEntity that = (DepartmentEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (deptName != null ? !deptName.equals(that.deptName) : that.deptName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (deptName != null ? deptName.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "id", nullable = false)
    public UnitEntity getUnitByUnitId() {
        return unitByUnitId;
    }

    public void setUnitByUnitId(UnitEntity unitByUnitId) {
        this.unitByUnitId = unitByUnitId;
    }

    @OneToMany(mappedBy = "departmentByBeforDeptId")
    public Collection<PositionChangeEntity> getPositionChangesByBeforeId() {
        return positionChangesByBeforeId;
    }

    public void setPositionChangesByBeforeId(Collection<PositionChangeEntity> positionChangesByBeforeId) {
        this.positionChangesByBeforeId = positionChangesByBeforeId;
    }

    @OneToMany(mappedBy = "departmentByAfterDeptId")
    public Collection<PositionChangeEntity> getPositionChangesByAfterId() {
        return positionChangesByAfterId;
    }

    public void setPositionChangesByAfterId(Collection<PositionChangeEntity> positionChangesByAfterId) {
        this.positionChangesByAfterId = positionChangesByAfterId;
    }

    @Override
    public String toString() {
        return "DepartmentEntity{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", unitByUnitId=" + unitByUnitId +
                ", positionChangesByBeforeId=" + positionChangesByBeforeId +
                ", positionChangesByAfterId=" + positionChangesByAfterId +
                '}';
    }
}
