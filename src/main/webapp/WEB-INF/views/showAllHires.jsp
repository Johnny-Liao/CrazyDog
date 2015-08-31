<%--
  Created by IntelliJ IDEA.
  User: never
  Date: 2015/8/31
  Time: 20:07
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
                    <form method="post">
                        <td><input type="text" name="unitCode" id="textfield" class="s_input" value="服务单位编码"
                                   onfocus="javascript:this.style.color='#000000';if(this.value=='服务单位编码')this.value='';"
                                   onblur="javascript:if(this.value==''){this.value='服务单位编码';this.style.color='#CCCCCC';}"/>
                        </td>
                        <td><input type="text" name="unitName" id="textfield2" class="s_input" value="服务单位名称"
                                   onfocus="javascript:this.style.color='#000000';if(this.value=='服务单位名称')this.value='';"
                                   onblur="javascript:if(this.value==''){this.value='服务单位名称';this.style.color='#CCCCCC';}"/>
                        </td>
                        <td><input type="submit" name="button" id="button" value="查询" class="s_btn"
                                   onclick="javascript:this.form.action='/unit?action=search'"/></td>
                        <td><input type="button" name="btnAdd" id="btnAdd" value="增加行" class="s_btn"
                                   onclick="addunit()"/>
                        </td>
                        <td><input type="button" name="button2" id="confirmBtn" value="确定" class="s_btn"
                                   onclick='javascript:$("#addUnit").submit()'/></td>
                    </form>
                </tr>
            </table>
        </div>

        <div class=" tum">
            <div class="contlist">
                <form id="addUnit" method="post" action="/unit?action=addUnit">
                    <table border="0" cellspacing="0" cellpadding="0" style="width:100%;">
                        <tbody id="mytable">
                        <%--显示表头标题--%>
                        <tr style="color:#000; font-size:14px; padding:10px 0;">
                            <c:forEach var="column" items="<%=ResourceString.hireToEmployeeShow%>">
                                <td align="center" bgcolor="#fff8f8"><c:out value="${column}"/></td>
                            </c:forEach>
                        </tr>

                        <%--显示表内容--%>
                        <c:forEach var="entity" items="${hireInfoEntities}">
                            <tr>
                                <td align="center" bgcolor="#ffffff"><c:out
                                        value="${entity.id}"/></td>
                                <td align="center" bgcolor="#ffffff"><c:out
                                        value="${entity.resumeEntity.name}"/></td>
                                <td align="center" bgcolor="#ffffff"><c:out
                                        value="${entity.resumeEntity.gender}"/></td>
                                <td align="center" bgcolor="#ffffff"><c:out
                                        value="${entity.resumeEntity.nation}"/></td>
                                <td align="center" bgcolor="#ffffff"><c:out
                                        value="${entity.resumeEntity.hukouAddress}"/></td>
                                <td align="center" bgcolor="#ffffff"><c:out
                                        value="${entity.resumeEntity.hyzk}"/></td>
                                <td align="center" bgcolor="#ffffff"><c:out
                                        value="${entity.resumeEntity.zzmm}"/></td>
                                <td align="center" bgcolor="#ffffff"><c:out
                                        value="${entity.resumeEntity.education}"/></td>
                                <td align="center" bgcolor="#ffffff"><a href='employeePage?action=buildRecord&&resumeId=<c:out
                                    value="${entity.id}"/>'>建档</a></td>
                                <%--<td align="center" bgcolor="#ffffff"><a--%>
                                        <%--href='unit?action=unitDelete&&unitId=<c:out--%>
                                    <%--value="${entity.id}"/>'>取消录取</a></td>--%>
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
