package org.crazydog.serviceI.impl.searchmodel;

/**
 * Created by never on 2015/8/28.
 */
public class ResumeSearchModel extends SearchModel {

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

        等待审核, 录取, 未录取

    }

    private String name;
    private Edu highestEdu;
    private Luqu luquState;

    public ResumeSearchModel(String name, Edu highestEdu, Luqu luquState) {
        this.name = name;
        this.highestEdu = highestEdu;
        this.luquState = luquState;
    }


	
    public StringBuffer advanceSearch() {
        buffer.append("from ResumeEntity res, HireInfoEntity hire where res.id=hire.resumeId and ");
        if (luquState != null)
            buffer.append("hire.state='" + luquState + "' and");
        if (name != null)
            buffer.append("res.name='" + name + "' and");
        if (highestEdu != null)
        {buffer.append(" res.education='" + highestEdu + "' and");}


//        buffer.append("from ResumeEntity res where ");
//        if (luquState != null) {
//            buffer.delete(0, buffer.length());
//            buffer.append("from ResumeEntity res , HireEntity hire where hire.state='"
//                    + luquState + "' ");
//        }
//        if (name != null) {
//            if (luquState != null) {
//                buffer.append(" and ");
//            }
//            buffer.append("res.name='" + name + "' ");
//        }
//
//        if (highestEdu != null) {
//            if (name != null || luquState != null) {
//                buffer.append(" and ");
//            }
//            buffer.append(" res.education='" + highestEdu + "'");
//        }

        return buffer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResumeSearchModel that = (ResumeSearchModel) o;

        if (!name.equals(that.name)) return false;
        if (highestEdu != that.highestEdu) return false;
        return luquState == that.luquState;

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + highestEdu.hashCode();
        result = 31 * result + luquState.hashCode();
        return result;
    }
}
