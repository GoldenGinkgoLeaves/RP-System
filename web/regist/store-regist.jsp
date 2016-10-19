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
<form action="store-regist.Action" method="post">
    <div id="box">
        <div id="name">
            <span class="word">用户名</span>
            <input type="text" name="store.account">
        </div>
        <div id="paw">
            <span class="word">密码</span>
            <input type="password" name="store.password">
            <span class="notice">请设置6位以上密码</span>
        </div>
        <div id="paw1">
            <span class="word">确认密码</span>
            <input type="password" name="password1">
        </div>
        <div id="tel">
            <span class="word">电话</span>
            <input type="text" name="store.telephone">
            <span class="notice">请输入有效的号码</span>
        </div>
        <div id="sto-name">
            <span class="word">想取店名</span>
            <input type="text" name="store.name">
        </div>
        <input type="submit" value="注册">
    </div>
    <p class="statment">All Copyrights Reserved © 电子科技大学计算机科学与工程学院--远程打印系统组</p>
</form>
</body>
</html>
