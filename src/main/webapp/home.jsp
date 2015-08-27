<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>My JSP 'home.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<frameset rows="12.5%,87.5%" >
  <frame src="top.jsp" name="topFrame" frameborder="0" border="0" framespacing="0" scrolling="NO" noresize>
  <frameset cols="200,*" frameborder="0" border="0" framespacing="0" >
		<frame src="left.jsp" name="leftFrame" frameborder="0" border="0" framespacing="0" noresize scrolling="YES">
		<frame src="index.jsp" name="rightFrame" frameborder="0" border="0" framespacing="0" scrolling="NO"  noresize>
  </frameset>
</frameset>
</html>