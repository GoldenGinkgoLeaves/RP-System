<%--
  Created by IntelliJ IDEA.
  User: hurong1993
  Date: 2016/10/19
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../css/login.css">
</head>
<body>
<div id="head">
    <p>远程打印系统</p>
    <div class="img"></div>
</div>
<p class="custom">登  录</p>
<hr>
<form action="login.action" method="post">
    <div id="login">
        <div id="name">
            <span>用户名</span>
            <input type="text" name="account" placeholder="请输入用户名">
        </div>
        <div id="paw">
            <span>密码</span>
            <input type="password" name="password" placeholder="请输入密码">
        </div>
        <input type="submit" value="登录">
        <div id="notice"><span>没有通行账号？<a href="/regist/regist.jsp" target="_parent">立即注册</a></span></div>
    </div>
</form>
</body>
</html>
