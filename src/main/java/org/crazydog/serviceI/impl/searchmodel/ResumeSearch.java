package org.crazydog.serviceI.impl.searchmodel;

/**
 * Created by never on 2015/8/28.
 */
public class ResumeSearch extends Search<ResumeSearch> {

    /**
     * 学历水平
     */
    public enum Edu {
        小学, 初中, 高中, 专科, 本科, 硕士, 博士
    }

    /**
     * 录取状态
     */
    public enum Luqu {
        通过, 三审, 二审, 一审, 简历审核
    }

    private String name;
    private Edu highestEdu;
    private Luqu luquState;

    public ResumeSearch(String name, Edu highestEdu, Luqu luquState) {
        this.name = name;
        this.highestEdu = highestEdu;
        this.luquState = luquState;
    }

    public String advanceSearch(ResumeSearch model) {
        //记录缓存数据
        if (model.equals(this))
            return buffer.toString();

        this.name = model.name;
        this.highestEdu = model.highestEdu;
        this.luquState = model.luquState;

        buffer.delete(0, buffer.capacity());

        buffer.append("from ResumeEntity res where ");
        if (luquState != null) {
            buffer.delete(0, buffer.length());
            buffer.append("from ResumeEntity res , HireEntity hire where hire.state='"
                    + luquState + "' ");
        }
        if (name != null) {
            if (luquState != null) {
                buffer.append(" and ");
            }
            buffer.append("res.name='" + name + "' ");
        }

        if (highestEdu != null) {
            if (name != null || luquState != null) {
                buffer.append(" and ");
            }
            buffer.append(" res.education='" + highestEdu + "'");
        }

        return buffer.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResumeSearch that = (ResumeSearch) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (highestEdu != that.highestEdu) return false;
        return luquState == that.luquState;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (highestEdu != null ? highestEdu.hashCode() : 0);
        result = 31 * result + (luquState != null ? luquState.hashCode() : 0);
        return result;
    }
}
