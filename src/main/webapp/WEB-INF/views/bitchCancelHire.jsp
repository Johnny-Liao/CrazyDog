<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.crazydog.util.ResourceString" %>
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
    <div class="ctop"><a href="#">首页</a> &gt; <a href="#">社会招聘管理</a> &gt; <a href="#">简历管理</a></div>
    <form>
      <div class="search">
        <input type="submit" name="button" id="button" value="批量取消录取"  class="s_btn"   onclick="javascript:this.form.action='/resume?action=bitchHire'"/>
      </div>
    <div  class="tum">
      <div class="contlist">
        <table border="0" cellspacing="0" cellpadding="0" style="width:100%;">
          <%--显示表头标题--%>
            <tr style="color:#000; font-size:14px; padding:10px 0;">
              <c:forEach var="column" items="<%=ResourceString.resumeshow%>">
                <td align="center" bgcolor="#fff8f8"><c:out value="${column}"/></td>
              </c:forEach>
            </tr>
            <%--显示表内容--%>
            <c:forEach var="column" items="${resumes1}">
              <tr style="color:#000; font-size:14px; padding:10px 0;">
                <td align="center" bgcolor="#fff8f8"><input name="selectes" type="checkbox" value="${column.id}" /></td>
                <td align="center" bgcolor="#fff8f8"><c:out value="${column.name}"/></td>
                <td align="center" bgcolor="#fff8f8"><c:out value="${column.gender}"/></td>
                <td align="center" bgcolor="#fff8f8"><c:out value="${column.nation}"/></td>
                <td align="center" bgcolor="#fff8f8"><c:out value="${column.gender}"/></td>
                <td align="center" bgcolor="#fff8f8"><c:out value="${column.birthday}"/></td><td align="center" bgcolor="#fff8f8"><c:out value="${column.hyzk}"/></td>
                <td align="center" bgcolor="#fff8f8"><c:out value="${column.zzmm}"/></td>
                <td align="center" bgcolor="#fff8f8"><c:out value="${column.hukouAddress}"/></td>
                <td align="center" bgcolor="#fff8f8"><c:out value="${column.tel}"/></td>
                <td align="center" bgcolor="#fff8f8"><c:out value="${column.hireById.state}"/></td>
                <td align="center" bgcolor="#fff8f8"><c:out value="${column.email}"/></td>
                <td align="center" bgcolor="#fff8f8"><a href="#"/>查看详细简历信息</td>
              </tr>
            </c:forEach>
        </table>
      </div>
    </div>
    </form>
  </div>
</div>
</div>
</body>
</html>