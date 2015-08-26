<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>--%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>综合业务管理系统</title>
    <link href="style/style.css" rel="stylesheet" type="text/css"/>
    <script src="js/jquery-1.3.2.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
            $(".subNav").click(function () {
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
        <div><a href="#"><span><img src="images/person.png" width="17" height="19"/></span><span>您好！管理员</span></a></div>
        <div><a href="#"><span><img src="images/password.png" width="15" height="21"/></span><span>修改密码</span></a></div>
        <div><a href="#"><span><img src="images/colse.png" width="19" height="20"/></span><span>注销</span></a></div>
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

            <div class="tum">
                <div class="colus">
                    <div class="colr1"><a href="#"><img src="images/icon1.png" width="39" height="36"/><br/>单位会员管理</a>
                    </div>
                    <div class="colr2"><a href="#"><img src="images/icon2.png" width="39" height="36"/><br/>个人会员管理</a>
                    </div>
                    <div class="colr3"><a href="#"><img src="images/icon3.png" width="39" height="36"/><br/>系统消息管理</a>
                    </div>
                    <div class="colr4"><a href="#"><img src="images/icon4.png" width="39" height="36"/><br/>储备单位管理</a>
                    </div>
                    <div class="colr5"><a href="#"><img src="images/icon5.png" width="39" height="36"/><br/>系统职位管理</a>
                    </div>
                    <div class="colr6"><a href="#"><img src="images/icon6.png" width="39" height="36"/><br/>信誉评价管理</a>
                    </div>
                </div>
                <div style="overflow:hidden; clear:both;">
                    <div class=" messge">
                        <div class="mess">
                            <div class="messtop">基础数据维护</div>
                            <div class="messlist">
                                <p><a href="#">会员管理：<span class="number">10 </span>个会员</a></p>

                                <p><a href="#">资质管理：暂无提示</a></p>

                                <p><a href="#">我的消息助手：<span class="number">10 </span> 条信息</a></p>

                                <p><a href="#">职位信息管理：<span class="number">10 </span> 条信息处理</a></p>

                                <p><a href="#">人力资源管理：<span class="number">10 </span> 条信息</a></p>
                            </div>
                        </div>
                        <div class="mess">
                            <div class="messtop"><span class="left">工资管理</span><span class="right"><a href="#">更多
                                &gt;</a></span></div>
                            <div class="messlist">
                                <ul>
                                    <li><a href="#">思前软件 公司规模：100-900 公司电话：82896422 </a></li>
                                    <li><a href="#">思前软件 公司规模：100-900 公司电话：82896422 </a></li>
                                    <li><a href="#">思前软件 公司规模：100-900 公司电话：82896422 </a></li>
                                    <li><a href="#">思前软件 公司规模：100-900 公司电话：82896422 </a></li>
                                    <li><a href="#">思前软件 公司规模：100-900 公司电话：82896422 </a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="messge">
                        <div class="mess">
                            <div class="messtop"><span class="left">人事消息管理</span><span class="right"><a href="#">更多
                                &gt;</a></span></div>
                            <div class="messlist">
                                <ul>
                                    <li><a href="#">思前软件 公司规模：100-900 公司电话：82896422 </a></li>
                                    <li><a href="#">思前软件 公司规模：100-900 公司电话：82896422 </a></li>
                                    <li><a href="#">思前软件 公司规模：100-900 公司电话：82896422 </a></li>
                                    <li><a href="#">思前软件 公司规模：100-900 公司电话：82896422 </a></li>
                                    <li><a href="#">思前软件 公司规模：100-900 公司电话：82896422 </a></li>
                                    <li><a href="#">思前软件 公司规模：100-900 公司电话：82896422 </a></li>
                                    <li><a href="#">思前软件 公司规模：100-900 公司电话：82896422 </a></li>
                                    <li><a href="#">思前软件 公司规模：100-900 公司电话：82896422 </a></li>
                                    <li><a href="#">思前软件 公司规模：100-900 公司电话：82896422 </a></li>
                                    <li><a href="#">思前软件 公司规模：100-900 公司电话：82896422 </a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="mess">
                            <div class="messtop"><span class="left">社会招聘管理</span><span class="right"><a href="#">更多
                                &gt;</a></span></div>
                            <div class="messlist">
                                <ul>
                                    <li><a href="#">思前软件 公司规模：100-900 公司电话：82896422 </a></li>
                                    <li><a href="#">思前软件 公司规模：100-900 公司电话：82896422 </a></li>
                                    <li><a href="#">思前软件 公司规模：100-900 公司电话：82896422 </a></li>
                                    <li><a href="#">思前软件 公司规模：100-900 公司电话：82896422 </a></li>
                                    <li><a href="#">思前软件 公司规模：100-900 公司电话：82896422 </a></li>
                                    <li><a href="#">思前软件 公司规模：100-900 公司电话：82896422 </a></li>
                                    <li><a href="#">思前软件 公司规模：100-900 公司电话：82896422 </a></li>
                                    <li><a href="#">思前软件 公司规模：100-900 公司电话：82896422 </a></li>
                                    <li><a href="#">思前软件 公司规模：100-900 公司电话：82896422 </a></li>
                                    <li><a href="#">思前软件 公司规模：100-900 公司电话：82896422 </a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
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
