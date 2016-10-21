<%--
  Created by IntelliJ IDEA.
  User: hurong1993
  Date: 2016/10/19
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>我的文件</title>
    <meta charset="utf-8">
    <style type="text/css">
        label {
            width: 100%;
            height: 50px;
            display: block;
            line-height: 50px;
        }
    </style>
</head>
<body>
<form action="mydoc.action" method="post">
    <label><input name="Fruit" type="checkbox" value=""/>综合素质课作业 <span>word</span> </label>
    <label><input name="Fruit" type="checkbox" value=""/>桃子 <span></span> </label>
    <label><input name="Fruit" type="checkbox" value=""/>香蕉 <span></span> </label>
    <label><input name="Fruit" type="checkbox" value=""/>梨 <span></span> </label>
    <input type="button" name="" value="打印">
</form>
<button name="" value="">上传文档</button>
</body>
</html>
