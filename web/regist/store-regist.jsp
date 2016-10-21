<%--
  Created by IntelliJ IDEA.
  User: hurong1993
  Date: 2016/10/19
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../css/store-regist.css">
</head>
<body>
<form action="store-regist.Action" method="post" target="_parent">
    <div id="box">
        <div id="name">
            <span class="word">用户名</span>
            <input type="text" name="store.account" placeholder="请输入用户名">
            <span class="notice">请设置6位以上用户名</span>
        </div>
        <div id="paw">
            <span class="word">密码</span>
            <input type="password" name="store.password" placeholder="请输入密码">
            <span class="notice">请设置6位以上密码</span>
        </div>
        <div id="paw1">
            <span class="word">确认密码</span>
            <input type="password" name="password1" placeholder="请确认密码">
        </div>
        <div id="sto-name">
            <span class="word">店名</span>
            <input type="text" name="store.name" placeholder="请输入想取的店名">
        </div>
        <input type="submit" value="注册">
    </div>
    <p class="statment">All Copyrights Reserved © 电子科技大学计算机科学与工程学院--远程打印系统组</p>
</form>
</body>
</html>
