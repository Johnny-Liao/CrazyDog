<%--
  Created by IntelliJ IDEA.
  User: johnny
  Date: 15-8-28
  Time: 下午3:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.crazydog.util.ResourceString" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>离职人员管理</title>

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
        <div class="ctop"><a href="#">首页</a> &gt; <a href="#">综合业务管理系统</a> &gt; <a href="#">离职办理</a></div>

        <div class="tum">
            <div class="contlist">
                <table border="0" cellspacing="0" cellpadding="0" style="width:100%;">
                    <%--显示表头标题--%>
                    <tr style="color:#000; font-size:14px; padding:10px 0;">
                        <c:forEach var="column" items="<%=ResourceString.leave%>">
                            <td align="center" bgcolor="#fff8f8"><c:out value="${column}"/></td>
                        </c:forEach>
                    </tr>
                    <tr>
                        <%--
                            `emp_code`        INT           NOT NULL,
                            `name`            VARCHAR(20)   COMMENT '离职员工',
                            `leave_date`      DATE          COMMENT '离职日期',
                            `leave_comment`   VARCHAR(200)  COMMENT '离职原因', --%>

                        <form action="/leave" method="post">
                            <td align="center" bgcolor="#ffffff"><input type="text" id="empid" name="empid" value="${empid}" readonly="true" class="s_input"/></td>
                            <td align="center" bgcolor="#ffffff"><input type="text" id="empname" name="empname" value="${empname}" readonly="true" class="s_input"/></td>
                            <td align="center" bgcolor="#ffffff"><input type="text" id="date" name="date" value="${date}" class="s_input"/></td>
                            <td align="center" bgcolor="#ffffff"><input type="text" id="reason" name="reason" value="填写离职原因" class="s_input"/></td>
                            <td align="center"><input type="submit" value="提交" class="s_btn" ></td>
                        </form>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>