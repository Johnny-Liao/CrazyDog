<%--
  Created by IntelliJ IDEA.
  User: never
  Date: 2015/8/28
  Time: 12:32
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
        <div class="contentop">
            <div class="welcome">您好：<a href="#">admin</a>，欢迎登综合业务管理系统！</div>
            <div class="time"><span>2015年4月21日</span><span>星期二</span></div>
        </div>
        <div class="ctop"><a href="#">首页</a> &gt; <a href="#">综合业务管理系统</a> &gt; <a href="#">待办申请</a></div>
        <div class="search">
            <table border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td><input type="text" name="textfield" id="textfield" class="s_input" value="人员编号"
                               onfocus="javascript:this.style.color='#000000';if(this.value=='人员编号')this.value='';"
                               onblur="javascript:if(this.value==''){this.value='人员编号';this.style.color='#CCCCCC';}"/>
                    </td>
                    <td><input type="text" name="textfield2" id="textfield2" class="s_input" value="姓名"
                               onfocus="javascript:this.style.color='#000000';if(this.value=='姓名')this.value='';"
                               onblur="javascript:if(this.value==''){this.value='姓名';this.style.color='#CCCCCC';}"/>
                    </td>
                    <td><input type="submit" name="button" id="button" value="查询" class="s_btn"/></td>
                    <td><input type="submit" name="button2" id="button2" value="新建服务单位" class="s_btns"/></td>
                </tr>
            </table>
        </div>

        <div class="tum">
            <div class="contlist">
                <table border="0" cellspacing="0" cellpadding="0" style="width:100%;" scrolling="yes">
                    <%--显示表头标题--%>
                    <tr style="color:#000; font-size:14px; padding:10px 0;">
                        <c:forEach var="column" items="<%=ResourceString.contractExtensionRecordShow%>">
                            <td align="center" bgcolor="#fff8f8"><c:out value="${column}"/></td>
                        </c:forEach>
                    </tr>
                    <%--显示表内容--%>
                    <c:forEach var="entity" items="${contractEntities}">
                        <tr>
                            <td align="center" bgcolor="#ffffff"><c:out value="${entity.employeeByEmpId.empCode}"/></td>
                            <td align="center" bgcolor="#ffffff"><c:out value="${entity.employeeByEmpId.empName}"/></td>
                            <td align="center" bgcolor="#ffffff"><c:out value="${entity.employeeByEmpId.gender}"/></td>
                            <td align="center" bgcolor="#ffffff"><c:out value="${entity.employeeByEmpId.idNum}"/></td>
                            <td align="center" bgcolor="#ffffff"><c:out value="${entity.employeeByEmpId.tel}"/></td>
                            <td align="center" bgcolor="#ffffff"><c:out
                                    value="${entity.employeeByEmpId.unitByUnitId.unitName}"/></td>
                            <td align="center" bgcolor="#ffffff"><c:out
                                    value="${entity.employeeByEmpId.departmentByDepId.deptName}"/></td>
                            <td align="center" bgcolor="#ffffff"><c:out value="${entity.contractStart}"/></td>
                            <td align="center" bgcolor="#ffffff"><c:out value="${entity.contractEnd}"/></td>
                            <td align="center" bgcolor="#ffffff"><c:out value="否"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
