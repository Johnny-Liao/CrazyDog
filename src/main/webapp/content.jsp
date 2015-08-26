<%--
  Created by IntelliJ IDEA.
  User: never
  Date: 2015/8/26
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>综合业务管理系统</title>
  <link href="style/style.css" rel="stylesheet" type="text/css" />
  <script src="js/jquery-1.3.2.js" type="text/javascript"></script>
  <script type="text/javascript">
    $(function(){
      $(".subNav").click(function(){
        $(this).toggleClass("currentDd").siblings(".subNav").removeClass("currentDd")
        $(this).toggleClass("currentDt").siblings(".subNav").removeClass("currentDt")

        // 修改数字控制速度， slideUp(500)控制卷起速度
        $(this).next(".navContent").slideToggle(500).siblings(".navContent").slideUp(500);
      })
    })
  </script>
</head>

<body>
<div class="head">
  <div class="logo"><a href="#">综合业务管理系统</a></div>
  <div class="headright">
    <div><a href="#"><span><img src="images/person.png" width="17" height="19" /></span><span>您好！管理员</span></a></div>
    <div><a href="#"><span><img src="images/password.png" width="15" height="21" /></span><span>修改密码</span></a></div>
    <div><a href="#"><span><img src="images/colse.png" width="19" height="20" /></span><span>注销</span></a></div>
  </div>
</div>
<div class="main clearfix">
  <div class="side left">

    <div class="leftlist">
      <!-- 代码 开始 -->
      <div class="subNavBox">
        <div style="padding-bottom:50px;">
          <div class="subs"><a href="#">监管助理人事管理 </a></div>
          <div class="subNav currentDd currentDt">基础数据维护</div>
          <ul class="navContent " style="display:block">
            <li><a href="#">会员管理</a></li>
            <li><a href="#">资质管理</a></li>
          </ul>
          <div class="subNav">社会招聘管理</div>
          <ul class="navContent">
            <li><a href="#">会员管理</a></li>
            <li><a href="#">身份管理</a></li>
          </ul>
          <div class="subNav">人事信息管理</div>
          <ul class="navContent">
            <li><a href="#">人员信息管理</a></li>
            <li><a href="#">离职管理</a></li>
            <li><a href="#">调岗管理</a></li>
            <li><a href="#">离职人员</a></li>
            <li><a href="#">调岗人员</a></li>
          </ul>
          <div class="subNav">合同管理</div>
          <ul class="navContent">
            <li><a href="#">合同续签管理</a></li>
            <li><a href="#">续签合同记录</a></li>
          </ul>
          <div class="subNav">工资管理</div>
          <ul class="navContent">
            <li><a href="#">发布职位</a></li>
            <li><a href="#">已发职位</a></li>
            <li><a href="#">历史信息</a></li>
          </ul>
          <div class="subNav">统计查询</div>
          <ul class="navContent">
            <li><a href="#">花名册</a></li>
          </ul>

          <div class="subs"><a href="#">监管助理物品管理</a></div>
          <div class="subNav">基础数据维护</div>
          <ul class="navContent ">
            <li><a href="#">会员管理</a></li>
            <li><a href="#">资质管理</a></li>
          </ul>
          <div class="subNav">社会招聘管理</div>
          <ul class="navContent">
            <li><a href="#">会员管理</a></li>
            <li><a href="#">身份管理</a></li>
          </ul>
          <div class="subNav">人事信息管理</div>
          <ul class="navContent">
            <li><a href="#">人员信息管理</a></li>
            <li><a href="#">离职管理</a></li>
            <li><a href="#">调岗管理</a></li>
            <li><a href="#">离职人员</a></li>
            <li><a href="#">调岗人员</a></li>
          </ul>
          <div class="subNav">合同管理</div>
          <ul class="navContent">
            <li><a href="#">合同续签管理</a></li>
            <li><a href="#">续签合同记录</a></li>
          </ul>
          <div class="subNav">工资管理</div>
          <ul class="navContent">
            <li><a href="#">发布职位</a></li>
            <li><a href="#">已发职位</a></li>
            <li><a href="#">历史信息</a></li>
          </ul>
          <div class="subNav">统计查询</div>
          <ul class="navContent">
            <li><a href="#">花名册</a></li>
          </ul>
        </div>
      </div>
      <!-- 代码 结束 -->

    </div>
  </div>

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
              <td width="18%"><input type="text" name="textfield" id="textfield" class="s_inputss"/></td>
              <td width="8%" align="right"><span class="red">*</span> 性别：</td>
              <td width="21%"><select name="select4" id="select4" class="s_inputs" >
                <option>男</option>
                <option>女</option>
              </select></td>
              <td colspan="2" rowspan="7" bgcolor="#fafafa">&nbsp;</td>
            </tr>
            <tr>
              <td align="right">出生年月：</td>
              <td><input type="text" name="textfield2" id="textfield2" class="s_inputss"/></td>
              <td align="right"><span class="red">*</span> 民族：</td>
              <td><input type="text" name="textfield3" id="textfield3" class="s_inputss"/></td>
            </tr>
            <tr>
              <td align="right"><span class="red">* </span>政治面貌：</td>
              <td><select name="select" id="select" class="s_inputs" >
                <option>党员</option>
                <option>团员</option>
              </select></td>
              <td align="right"><span class="red">*</span> 婚姻状况：</td>
              <td><select name="select2" id="select2" class="s_inputs" >
                <option>未婚</option>
                <option>已婚</option>
              </select></td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span> 最高学历：</td>
              <td><select name="select3" id="select3" class="s_inputs" >
                <option>研究生</option>
                <option>本科</option>
                <option>大专</option>
              </select></td>
              <td align="right">计算机水平：</td>
              <td><input type="text" name="textfield6" id="textfield6" class="s_inputss"/></td>
            </tr>
            <tr>
              <td align="right">参加工作时间：</td>
              <td><input type="text" name="textfield4" id="textfield4" class="s_inputss"/></td>
              <td align="right">专业：</td>
              <td><input type="text" name="textfield5" id="textfield5" class="s_inputss"/></td>
            </tr>
            <tr>
              <td align="right">邮政编码：</td>
              <td><input type="text" name="textfield15" id="textfield15" class="s_inputss"/></td>
              <td align="right">籍贯：</td>
              <td><input type="text" name="textfield7" id="textfield7" class="s_inputss"/></td>
            </tr>
            <tr>
              <td align="right">外语语种：</td>
              <td><input type="text" name="textfield18" id="textfield18" class="s_inputss"/></td>
              <td align="right">特长：</td>
              <td><input type="text" name="textfield8" id="textfield8" class="s_inputss"/></td>
            </tr>
            <tr>
              <td align="right">外语水平：</td>
              <td><input type="text" name="textfield17" id="textfield17" class="s_inputss"/></td>
              <td align="right">技能等级：</td>
              <td><input type="text" name="textfield9" id="textfield9" class="s_inputss"/></td>
              <td width="8%" align="right">职称/专业资格：</td>
              <td width="36%"><input type="text" name="textfield19" id="textfield19" class="s_inputss"/></td>
            </tr>
            <tr>
              <td align="right">身高：</td>
              <td><input type="text" name="textfield16" id="textfield16" class="s_inputss"/></td>
              <td align="right">手机号：</td>
              <td><input type="text" name="textfield10" id="textfield10" class="s_inputss"/></td>
              <td align="right"> <span class="red">*</span> 身份证：</td>
              <td><input type="text" name="textfield20" id="textfield20" class="s_inputss"/></td>
            </tr>
            <tr>
              <td align="right">户口性质：</td>
              <td><select name="select5" id="select5" class="s_inputs" >
                <option>城镇户口</option>
                <option>农村户口</option>
              </select></td>
              <td align="right">户口所在地：</td>
              <td colspan="3"><table width="574" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="110" align="left"><input type="text" name="textfield11" id="textfield11" class="s_inputs"/></td>
                  <td width="12" align="left">省</td>
                  <td width="110" align="left"><input type="text" name="textfield22" id="textfield22" class="s_inputs"/></td>
                  <td width="18" align="left">市</td>
                  <td width="324" align="left"><input type="text" name="textfield23" id="textfield23" class="s_input01"/></td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td align="right">家庭电话：</td>
              <td><input type="text" name="textfield13" id="textfield13" class="s_inputss"/></td>
              <td align="right">通讯地址：</td>
              <td><input type="text" name="textfield12" id="textfield12" class="s_inputss"/></td>
              <td align="right">是否具有报道证：</td>
              <td><input type="text" name="textfield21" id="textfield21" class="s_inputss"/></td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span> 电子邮箱：</td>
              <td><input type="text" name="textfield14" id="textfield14" class="s_inputss"/></td>
              <td align="right">&nbsp;</td>
              <td>&nbsp;</td>
              <td colspan="2">&nbsp;</td>
            </tr>
          </table>
          <table border="0" cellspacing="0" cellpadding="0" style="width:100%;">
            <tr>
              <td colspan="6" align="left" bgcolor="#fff8f8" style="font-size:14px; font-weight:bold; padding-left:18px; border-top:2px solid #db0000;">录取信息</td>
            </tr>
            <tr  style=" padding:10px 0; font-weight:bold;  ">
              <td align="center" bgcolor="#ffffff">员工编号</td>
              <td align="center" bgcolor="#ffffff">姓名</td>
              <td align="center" bgcolor="#ffffff">性别</td>
              <td align="center" bgcolor="#ffffff">政治面貌</td>
              <td align="center" bgcolor="#ffffff">英语水平</td>
              <td align="center" bgcolor="#ffffff">技能等级</td>
            </tr>
            <tr>
              <td align="center" bgcolor="#ffffff">18721657776</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">北京市昌平区</td>
              <td align="center" bgcolor="#ffffff">073000</td>
              <td align="center" bgcolor="#ffffff">163@163.com</td>
            </tr>
            <tr>
              <td align="center" bgcolor="#ffffff">18721657776</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">北京市昌平区</td>
              <td align="center" bgcolor="#ffffff">073000</td>
              <td align="center" bgcolor="#ffffff">163@163.com</td>
            </tr>
            <tr>
              <td align="center" bgcolor="#ffffff">18721657776</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">北京市昌平区</td>
              <td align="center" bgcolor="#ffffff">073000</td>
              <td align="center" bgcolor="#ffffff">163@163.com</td>
            </tr>
            <tr>
              <td align="center" bgcolor="#ffffff">18721657776</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">北京市昌平区</td>
              <td align="center" bgcolor="#ffffff">073000</td>
              <td align="center" bgcolor="#ffffff">163@163.com</td>
            </tr><tr>
            <td align="center" bgcolor="#ffffff">18721657776</td>
            <td align="center" bgcolor="#ffffff">河北省定州市</td>
            <td align="center" bgcolor="#ffffff">河北省定州市</td>
            <td align="center" bgcolor="#ffffff">北京市昌平区</td>
            <td align="center" bgcolor="#ffffff">073000</td>
            <td align="center" bgcolor="#ffffff">163@163.com</td>
          </tr>
            <tr>
              <td align="center" bgcolor="#ffffff">18721657776</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">河北省定州市</td>
              <td align="center" bgcolor="#ffffff">北京市昌平区</td>
              <td align="center" bgcolor="#ffffff">073000</td>
              <td align="center" bgcolor="#ffffff">163@163.com</td>
            </tr>

          </table>

        </div>

      </div>

    </div>
  </div>
</div>
<div class="footer">
  <p>Copyright ©2014 Siansoft. All Rights Reserved.</p>
</div>
</body>
</html>
