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
    <div class="ctop"><a href="#">首页</a> &gt; <a href="#">综合业务管理系统</a> &gt; <a href="#">读取简历信息</a></div>
    <div class="search">
      <table border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><input type="submit" name="button" id="button" value="详细信息"  class="s_btn"/></td>
          <td><span width:500px; ></span></td>
        </tr>
      </table>
    </div>

    <div  class="tum">
      <div class="contlist">
        <table border="0" cellspacing="0" cellpadding="0" style="width:100%;">
          <tr>
            <td colspan="6" align="left" bgcolor="#fff8f8" style="font-size:14px; font-weight:bold; padding-left:16px;">简历基本信息</td>
          </tr>
          <tr>
            <td width="9%" align="right"><span class="red">*</span> 姓名：</td>
            <td width="18%"><input type="text" name="textfield" id="textfield" class="s_inputss" value="${resume.name}"/></td>
            <td width="8%" align="right"><span class="red">*</span> 性别：</td>
            <td width="21%"><select name="select4" id="select4" class="s_inputs" >
              <option>${resume.gender}</option>
              <option value="男">男</option>
              <option value="女">女</option>
            </select></td>
            <td colspan="2" rowspan="7" bgcolor="#fafafa">&nbsp;</td>
          </tr>
          <tr>
            <td align="right">出生年月：</td>
            <td><input type="text" name="textfield2" id="textfield2" class="s_inputss" value="${resume.birthday}"/></td>
            <td align="right"><span class="red">*</span> 民族：</td>
            <td><input type="text" name="textfield3" id="textfield3" class="s_inputss" value="${resume.nation}"/></td>
          </tr>
          <tr>
            <td align="right"><span class="red">* </span>政治面貌：</td>
            <td><select name="select" id="select" class="s_inputs" >
              <option>${resume.zzmm}</option>
              <option>党员</option>
              <option>团员</option>
            </select></td>
            <td align="right"><span class="red">*</span> 婚姻状况：</td>
            <td><select name="select2" id="select2" class="s_inputs" >
              <option>${resume.hyzk}</option>
              <option>未婚</option>
              <option>已婚</option>
            </select></td>
          </tr>
          <tr>
            <td align="right"><span class="red">*</span> 最高学历：</td>
            <td><select name="select3" id="select3" class="s_inputs" >
              <option>${resume.education}</option>
              <option>博士</option>
              <option>硕士</option>
              <option>本科</option>
              <option>专科</option>
              <option>高中</option>
              <option>初中</option>
              <option>大学</option>
            </select></td>
            <td align="right">计算机水平：</td>
            <td><input type="text" name="textfield6" id="textfield6" class="s_inputss" value="${resume.jjsp}"/></td>
          </tr>
          <tr>
            <td align="right">专业：</td>
            <td><input type="text" name="textfield5" id="textfield5" class="s_inputss" value="${resume.profession}"/></td>
          </tr>
          <tr>
            <td align="right">邮政编码：</td>
            <td><input type="text" name="textfield15" id="textfield15" class="s_inputss" value="${resume.zipCode}"/></td>
            <td align="right">籍贯：</td>
            <td><input type="text" name="textfield7" id="textfield7" class="s_inputss" value="${resume.homeTown}"/></td>
          </tr>
          <tr>
            <td align="right">外语语种：</td>
            <td><input type="text" name="textfield18" id="textfield18" class="s_inputss" value="${resume.foreignLang}"/></td>
            <td align="right">特长：</td>
            <td><input type="text" name="textfield8" id="textfield8" class="s_inputss" value="${resume.specialty}"/></td>
          </tr>
          <tr>
            <td align="right">外语水平：</td>
            <td><input type="text" name="textfield17" id="textfield17" class="s_inputss" value="${resume.yysp}"/></td>
            <td align="right">技能等级：</td>
            <td><input type="text" name="textfield9" id="textfield9" class="s_inputss" /></td>
            <td width="8%" align="right">职称/专业资格：</td>
            <td width="36%"><input type="text" name="textfield19" id="textfield19" class="s_inputss" value="${resume.jndj}"/></td>
          </tr>
          <tr>
            <td align="right">身高：</td>
            <td><input type="text" name="textfield16" id="textfield16" class="s_inputss" value="${resume.height}"/></td>
            <td align="right">手机号：</td>
            <td><input type="text" name="textfield10" id="textfield10" class="s_inputss" value="${resume.tel}"/></td>
            <td align="right"> <span class="red">*</span> 身份证：</td>
            <td><input type="text" name="textfield20" id="textfield20" class="s_inputss" value="${resume.idNum}"/></td>
          </tr>
          <tr>
            <td align="right">户口性质：</td>
            <td><select name="select5" id="select5" class="s_inputs" >
              <option>${resume.hukou}</option>
              <option>城镇户口</option>
              <option>农村户口</option>
            </select></td>
            <td align="right">户口所在地：</td>
            <td><input type="text" name="textfield13" id="textfield40" class="s_inputss" value="${resume.hukouAddress}"/></td>
          </tr>
          <tr>
            <td align="right">家庭电话：</td>
            <td><input type="text" name="textfield13" id="textfield13" class="s_inputss"  value="${resume.homePhone}"/></td>
            <td align="right">通讯地址：</td>
            <td><input type="text" name="textfield12" id="textfield12" class="s_inputss" value="${resume.address}"/></td>
            <td align="right">是否具有报道证：</td>
            <td><input type="text" name="textfield21" id="textfield21" class="s_inputss" value="${resume.reportCard}"/></td>
          </tr>
          <tr>
            <td align="right"><span class="red">*</span> 电子邮箱：</td>
            <td><input type="text" name="textfield14" id="textfield14" class="s_inputss" value="${resume.email}"/></td>
            <td align="right">&nbsp;</td>
            <td>&nbsp;</td>
            <td colspan="2">&nbsp;</td>
          </tr>
        </table>
        <table border="0" cellspacing="0" cellpadding="0" style="width:100%;">
          <tr style="color:#000; font-size:14px; padding:10px 0;">
            <c:forEach var="column" items="<%=ResourceString.hireshow%>">
              <td align="center" bgcolor="#fff8f8"><c:out value="${column}"/></td>
            </c:forEach>
          </tr>
          <tr style="color:#000; font-size:14px; padding:10px 0;">
            <td align="center" bgcolor="#fff8f8"><c:out value="${resume.id}"/></td>
            <td align="center" bgcolor="#fff8f8"><c:out value="${resume.hireById.state}"/></td>
            <td align="center" bgcolor="#fff8f8"><c:out value="${resume.hireById.comment}"/></td>
            <td align="center" bgcolor="#fff8f8"><c:out value="${resume.hireById.operateTime}"/></td>
            <td align="center" bgcolor="#fff8f8"><c:out value="${resume.hireById.operator}"/></td>
          </tr>
        </table>
      </div>

    </div>

  </div>
</div>
</div>
</body>
</html>