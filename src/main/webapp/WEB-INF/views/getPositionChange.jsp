<%--
  Created by IntelliJ IDEA.
  User: never
  Date: 2015/8/30
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.crazydog.util.ResourceString" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>服务单位管理</title>

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
        <div class="ctop"><a href="#">首页</a> &gt; <a href="#">综合业务管理系统</a> &gt; <a href="#">待办申请</a></div>
        <div class="search">
            <table border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td>
                        员工编号<span class="red">*</span><input type="text" name="code" value="${unitEntity.unitCode}"
                                                             class="s_input">
                    </td>
                    <td>
                        员工姓名<span class="red">*</span><input type="text" name="name" value="${unitEntity.unitName}"
                                                             class="s_input">
                    </td>
                    <td>
                        岗位变更日期<span class="red">*</span><input type="text" name="date" value="${unitEntity.unitName}"
                                                               class="s_input">
                    </td>
                    <td><input type="button" name="button" id="button" value="搜索" class="s_btn"/></td>
                </tr>
            </table>
        </div>

        <div class="tum">
            <span class="red">调岗信息</span>

            <div class="contlist">
                <table border="0" cellspacing="0" cellpadding="0" style="width:100%;">

                    <%--显示表头标题--%>
                    <tr style="color:#000; font-size:14px; padding:10px 0;">
                        <c:forEach var="column" items="<%=ResourceString.positionChangeShow%>">
                            <td align="center" bgcolor="#fff8f8"><c:out value="${column}"/></td>
                        </c:forEach>
                    </tr>

                    <%--显示表内容--%>
                    <c:forEach var="entity" items="${positionChangeEntities}">
                        <tr>
                            <td align="center" bgcolor="#ffffff"><c:out value="${entity.id}"/></td>
                            <td align="center" bgcolor="#ffffff"><c:out value="${entity.employeeEntity.empCode}"/></td>
                            <td align="center" bgcolor="#ffffff"><c:out value="${entity.employeeEntity.empName}"/></td>
                            <td align="center" bgcolor="#ffffff"><c:out value="${entity.changeTime}"/></td>
                            <td align="center" bgcolor="#ffffff"><c:out value="${entity.changeCause}"/></td>
                            <td align="center" bgcolor="#ffffff"><c:out
                                    value="${entity.unitByBeforUnitId.unitName}"/></td>
                            <td align="center" bgcolor="#ffffff"><c:out
                                    value="${entity.departmentByBeforDeptId.deptName}"/></td>
                            <td align="center" bgcolor="#ffffff"><c:out
                                    value="${entity.unitByAfterUnitId.unitName}"/></td>
                            <td align="center" bgcolor="#ffffff"><c:out
                                    value="${entity.departmentByAfterDeptId.deptName}"/></td>
                            <td align="center" bgcolor="#ffffff">删除</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td align="center"><input type="submit" value="确定" class="s_btn"></td>
                        <td align="center"><input type="submit" value="取消" class="s_btns"></td>
                    </tr>
                </table>
            </div>
        </div>

    </div>
</div>
</body>
</html>
