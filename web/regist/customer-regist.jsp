<%--
  Created by IntelliJ IDEA.
  User: hurong1993
  Date: 2016/10/19
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>注册</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../css/customer-regist.css">
</head>
<body>
<form action="customer-regist.action" method="post" target="_parent">
    <div id="box">
        <div id="name">
            <span class="word">用户名</span>
            <input type="text" name="customer.account">
        </div>
        <div id="paw">
            <span class="word">密码</span>
            <input type="password" name="customer.password">
            <span class="notice">请设置6位以上密码</span>
        </div>
        <div id="paw1">
            <span class="word">确认密码</span>
            <input type="password" name="password1">
        </div>
        <div id="tel">
            <span class="word">手机</span>
            <input type="text" name="customer.telephone">
            <span class="notice">请输入有效的号码</span>
        </div>
        <input type="submit" value="注册">
    </div>
    <p class="statment">All Copyrights Reserved © 电子科技大学计算机科学与工程学院--远程打印系统组</p>
</form>
</body>
</html>