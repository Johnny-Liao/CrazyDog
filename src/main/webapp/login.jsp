<%--
  Created by IntelliJ IDEA.
  User: never
  Date: 2015/8/26
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>登陆-综合业务管理系统</title>
</head>
<body>
<form:form method="post" action="login/verify">
    <table>
        <tr>
            <td><form:label path="userName">Name</form:label></td>
            <td><form:input path="userName"/></td>
        </tr>
        <tr>
            <td><form:label path="password">password</form:label></td>
            <td><form:input path="password"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>


</form:form>
</body>
</html>
