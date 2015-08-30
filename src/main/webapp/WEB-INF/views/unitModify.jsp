<%--
  Created by IntelliJ IDEA.
  User: never
  Date: 2015/8/29
  Time: 20:10
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
    <script src="../../js/jquery-1.3.2.js" type="text/javascript"></script>
    <script src="../../js/tableControl.js" type="text/javascript"></script>
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
                        服务单位编码<span class="red">*</span><input type="text" name="code" value="${unitEntity.unitCode}"
                                                               class="s_input">
                    </td>
                    <td>
                        服务单位名称<span class="red">*</span><input type="text" name="name" value="${unitEntity.unitName}"
                                                               class="s_input">
                    </td>
                    <td><input type="button" name="btnAdd" id="btnAdd" value="增加行" class="s_btn" onclick="addRow()"/>
                    </td>
                    <%--<td><input type="button" name="button2" id="button2" value="删除行" class="s_btns"/></td>--%>
                    <td align="center"><input type="submit" value="确定" class="s_btn"
                                              onclick='javascript:$("#unit").submit()'>
                    </td>
                    <td align="center"><input type="submit" value="返回" class="s_btns"></td>
                </tr>

            </table>
        </div>

        <div class="tum">
            <div><font color="red">服务部门</font></div>
            <div class="contlist">
                <form id="unit" method="post" action="/unit?action=add">
                    <table border="0" cellspacing="0" cellpadding="0" style="width:100%;">

                        <tbody id="mytable">
                        <%--显示表头标题--%>
                        <tr style="color:#000; font-size:14px; padding:10px 0;">
                            <td align="center" bgcolor="#fff8f8">序号</td>
                            <td align="center" bgcolor="#fff8f8">服务部门名称</td>
                            <td align="center" bgcolor="#fff8f8">删除服务部门</td>
                        </tr>

                        <%--显示表内容--%>
                        <c:forEach var="entity" items="${departmentEntities}">
                            <tr>
                                <td align="center" bgcolor="#ffffff"><c:out value="${entity.id}"/></td>
                                <td align="center" bgcolor="#ffffff"><c:out value="${entity.deptName}"/></td>
                                <td align="center" bgcolor="#ffffff">删除</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>

    </div>
</div>
</body>
</html>
