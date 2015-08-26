package org.crazydog.serviceI.impl;

public class SearchModel {

    enum Edu {
        小学, 初中, 高中, 专科, 本科, 硕士, 博士
    }

    enum Luqu {
        通过, 三审, 二审, 一审, 简历审核
    }

    private String name;
    private String highestEdu;
    private String luquState;

    public SearchModel(String name, String highestEdu, String luqu) {
        super();
        this.name = name;
        this.highestEdu = highestEdu;
        this.luquState = luqu;
    }

    public String advanceSearch() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("from ResumeEntity res where ");
        if (luquState != null && (null != Luqu.valueOf(luquState))) {
            buffer.delete(0, buffer.length());
            buffer.append("from ResumeEntity res , HireEntity hire where hire.state='"
                    + luquState + "' and ");
        }
        if (name != null)
            buffer.append("res.name='" + name + "'");
        if (highestEdu != null && (null != Edu.valueOf(highestEdu)))
            buffer.append(" and res.education='" + highestEdu + "'");
        return buffer.toString();
    }
}
