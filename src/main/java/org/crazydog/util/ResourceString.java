package org.crazydog.util;

/**
 * Created by never on 2015/8/28.
 */
public final class ResourceString {
    /**
     * 这是服务单位维护的列
     */
    public final static String[] unitShow = {"序号", "服务单位编码", "服务单位名称", "修改", "删除"};

    /**
     * 这是合同变更维护的列
     */
    public final static String[] contractExtensionShow = {"员工编号", "姓名", "身份证号", "入职日期", "服务单位", "服务部门", "合同起始日", "合同终止日", "合同变更"};

    /**
     * 人员维护
     */
    public final static String[] employeeShow = {"员工编号", "姓名", "性别", "身份证号", "手机", "最高学历", "服务单位", "服务部门", "合同起始日", "合同终止日", "离职操作", "调岗操作"};

    /**
     * 离职操作
     */
    public final static String[] leave = {"员工编号", "姓名", "离职日期", "离职原因", "提交"};

    /**
     * 调岗操作
     */
    public final static String[] dispatch = {"员工编号", "姓名", "调岗前单位", "调岗前部门", "调岗时间", "调岗后单位", "调岗后部门", "调岗原因", "操作"};

    /**
     * 这是合同变更维护的列
     */
    public final static String[] contractExtensionRecordShow = {"员工编号", "姓名", "性别", "身份证号", "手机", "服务单位", "服务部门", "合同起始日", "合同终止日", "是否续约"};
    /**
     * 这是简历数据维护的列
     */
    public final static String[] resumeShow = {"选择", "姓名", "性别", "民族", "出生年月", "最高学历", "婚否", "政治面貌", "户口所在地", "手机号码", "录取状态", "邮箱", "操作"};

    /**
     * 这是岗位变更维护的列
     */
    public final static String[] positionChangeShow = {"序号", "员工编号", "员工姓名", "更改时间", "更改原因", "之前单位", "之前部门", "之后单位", "之后部门", "删除记录"};

    /**
     * 这是离职查看维护的列
     */
    public final static String[] positionOffShow = {"序号", "员工编号", "员工姓名", "员工离职日期", "离职备注", "删除记录"};

    /**
     * 这是对录取人员进行建档维护的列
     */
    public final static String[] hireToEmployeeShow = {"序号", "姓名", "性别", "民族", "户口所在地", "婚否", "政治面貌", "学历", "录取状态", "建立档案"};

    /**
     * 这是简历录取状态的列
     */
    public final static String[] hireShow = {"序号", "录取状态", "备注", "操作时间", "操作人"};
    /**
     * 这是简历家庭成员的列
     */
    public final static String[] familyShow = {"与本人关系", "姓名", "工作单位"};
    /**
     * 这是简历工作经历的列
     */
    public final static String[] jodShow = {"开始时间", "辞职时间", "职务", "工作部门"};
    /**
     * 这是简历教育经历的列
     */
    public final static String[] eudShow = {"开始时间", "毕业时间", "学校", "专业"};
    /**
     * 取消录取或建档
     */
    public final static String[] cancelResume = {"选择", "姓名", "性别", "民族", "出生年月", "最高学历", "婚否", "政治面貌", "户口所在地", "手机号码", "录取状态", "邮箱", "建档","操作"};
}
