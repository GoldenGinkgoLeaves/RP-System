<%--
  Created by IntelliJ IDEA.
  User: hurong1993
  Date: 2016/10/19
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>远程打印系统</title>
    <meta charset="utf-8">
    <style type="text/css">
        #top {
            width: 100%;
            height: 90px;
            background-color: #69c2ec;
        }

        #top .welcome {
            float: left;
            height: 90px;
            width: 50%;
            color: white;
            padding-left: 30px;
            line-height: 90px;
            font-weight: 600;
            font-size: 36px;
        }

        * {
            margin: 0;
            font-family: "Microsoft YaHei" ! important;
        }

        #top .hello {
            float: right;
            height: 90px;
            color: white;
            line-height: 90px;
            font-weight: 600;
            font-size: 16px;
            padding-right: 20px;
        }
    </style>
</head>
<body>
<div id="top">
    <p class="welcome">欢迎使用远程打印系统</p>
    <p class="hello">用户名 你好！</p>
</div>
</body>
</html>