<%--
  Created by IntelliJ IDEA.
  User: hurong1993
  Date: 2016/10/19
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>login</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../css/customer-login.css">
</head>
<body>
<form action="customer-login.Action" method="post">
    <div id="login">
        <div id="name">
            <span>用户名</span>
            <input type="text" name="customer.account">
        </div>
        <div id="paw">
            <span>密码</span>
            <input type="password" name="customer.password">
        </div>
        <input type="submit" value="登陆">
        <div id="notice"><span>没有通行账号？<a href="../regist/regist.jsp" target="_parent">立即注册</a></span></div>
    </div>
</form>
</body>
</html>
