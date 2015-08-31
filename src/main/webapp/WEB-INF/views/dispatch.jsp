<%--
  Created by IntelliJ IDEA.
  User: johnny
  Date: 15-8-28
  Time: 下午19:52
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.crazydog.util.ResourceString" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>调岗人员管理</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="综合业务管理系统">
    <meta http-equiv="Content-Language" content="zh-cn">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="../../style/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="cont left">
    <div class="content">
        <jsp:include page="/WEB-INF/fragments/contentTop.jsp"/>
        <div class="ctop"><a href="#">首页</a> &gt; <a href="#">综合业务管理系统</a> &gt; <a href="#">调岗办理</a></div>

        <div class="tum">
            <div class="contlist">
                <table border="0" cellspacing="0" cellpadding="0" style="width:100%;">
                    <%--显示表头标题--%>
                    <tr style="color:#000; font-size:14px; padding:10px 0;">
                        <c:forEach var="column" items="<%=ResourceString.dispatch%>">
                            <td align="center" bgcolor="#fff8f8"><c:out value="${column}"/></td>
                        </c:forEach>
                    </tr>
                    <tr>
                        <%--
                          `id`                  INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          `emp_id`              INT          NOT NULL COMMENT '员工外键',
                          `befor_unit_id`       INT          NOT NULL COMMENT '以前单位id',
                          `befor_dept_id`       INT          NOT NULL COMMENT '以前部门id',
                          `change_time`         DATE         NOT NULL COMMENT '调岗时间',
                          `after_unit_id`       INT          NOT NULL COMMENT '之后单位id',
                          `after_dept_id`       INT          NOT NULL COMMENT '之后部门id',
                          `change_cause`        VARCHAR(100) NOT NULL COMMENT '更改原因',

                          request.setAttribute("empid", empid);
                            request.setAttribute("empname", empname);
                            request.setAttribute("unit", unit);
                            request.setAttribute("dept", dept);



                          --%>

                        <form action="/dispatch" method="post">
                            <td align="center" bgcolor="#ffffff"><input type="text" id="empid" name="empid"
                                                                        value="${emp.id}" readonly="true"
                                                                        class="s_input"/></td>
                            <td align="center" bgcolor="#ffffff"><input type="text" id="empname" name="empname"
                                                                        value="${emp.empName}" readonly="true"
                                                                        class="s_input"/></td>
                            <td align="center" bgcolor="#ffffff"><input type="text" id="unit" name="unit"
                                                                        value="${emp.unitEntity.unitName}" readonly="true"
                                                                        class="s_input"/></td>
                            <td align="center" bgcolor="#ffffff"><input type="text" id="dept" name="dept"
                                                                        value="${emp.departmentEntity.deptName}" readonly="true"
                                                                        class="s_input"/></td>
                            <td align="center" bgcolor="#ffffff"><input type="text" id="date" name="date"
                                                                        value="${date}" class="s_input"/></td>


                            <!--  `after_unit_id`       INT          NOT NULL COMMENT '之后单位id',
                          `after_dept_id`       INT          NOT NULL COMMENT '之后部门id',   not do -->
                            <td align="center" bgcolor="#ffffff"><input type="text" id="afterunit" name="afterunit"
                                                                        value="${date}" class="s_input"/></td>
                            <td align="center" bgcolor="#ffffff"><input type="text" id="afterdept" name="afterdept"
                                                                        value="${date}" class="s_input"/></td>


                            <td align="center" bgcolor="#ffffff"><input type="text" id="reason" name="reason"
                                                                        value="填写调岗原因" class="s_input"/></td>
                            <td align="center"><input type="submit" value="提交" class="s_btn"></td>
                        </form>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>