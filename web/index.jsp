<%--
  Created by IntelliJ IDEA.
  User: 92019
  Date: 2016/10/15
  Time: 1:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>主页</title>
    <style type="text/css">
        *{
            margin: 0;
        }
        #top{
            width: 100%;
            height: 70px;
            border-bottom: 1px solid blue;
            text-align: center;
            line-height: 70px;
            font-weight: 600;
            font-size: 30px;
            color: 	#FF0033;
            background-color: #99FF00;
        }
        #logo{
            width: 74%;
            height: 581px;
            border-right: 1px solid blue;
            float: left;
            background-image: url("/images/index.jpg");
            background-repeat: no-repeat;
            border-radius: 8px;
            margin-top: 8px;
        }
        #content{
            margin-top: 8px;
            border-radius: 8px;
            float: left;
            width: 25.7%;
            height: 581px;
            background-color:#666600;
        }
        #content #one{
            margin-top: 200px;
            margin-bottom: 10px;
        }
        #content p{
            display: block;
            width: 60%;
            height: 60px;
        }
        #content #one a{
            background-color: red;
        }
        #content a{
            display: block;
            width: 60%;
            height: 60px;
            line-height: 60px;
            text-align: center;
            font-weight: 600;
            background-color: blue;
            text-decoration: none;
            border-radius: 6px;
            font-size: 20px;
            margin-left: 60px;
            color: white;
        }
        #content a:hover{
            color: white;
            font-size: 23px;
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div id="top">欢迎来到远程打印系统</div>
<div id="logo"></div>
<div id="content">
    <p id="one"><a href="login.html">登陆</a></p>
    <p><a href="regist.html">注册</a></p>
</div>
</body>
</html>
