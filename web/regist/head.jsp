<%--
  Created by IntelliJ IDEA.
  User: hurong1993
  Date: 2016/10/19
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <meta charset="utf-8">
    <style type="text/css">
        #head{
            margin: 0;
            width: 100%;
            height: 90px;
            background-color: #69c2ec;
            font-family: "Microsoft YaHei";
        }
        #head p{
            float: left;
            height: 90px;
            width: 50%;
            color: white;
            padding-left: 50px;
            line-height: 90px;
            font-weight: 600;
            font-size: 40px;
        }
        .img{
            float: left;
            background-image: url("../images/logo.jpg");
            background-repeat: no-repeat;
            height: 90px;
            margin-left: 400px;
            margin-top: 2px;
            width: 120px;
        }
        *{
            margin: 0;
            font-family: "Microsoft YaHei";
        }
        .custom{
            display: block;
            float: left;
            height: 30px;
            margin-left: 565px;
            margin-top: 30px;
            color: rgb(154, 153, 153);
            font-size: 18px;
            text-decoration: none;
            padding: 0 20px;
        }
        .store{
            display: block;
            float: left;
            height: 30px;
            font-size: 18px;
            text-decoration: none;
            color: rgb(154, 153, 153);
            margin-top: 30px;
            padding: 0 20px;
        }
        a:active{
            color: blue;
            border-bottom: 2px solid blue;
        }
        hr{
            clear: both;
            width: 60%;
            height: 2px;
            background-color: #999999;
            margin-left: 260px;
            margin-top: 70px;
            border-radius: 2px;
        }
    </style>
</head>
<body>
<div id="head">
    <p>远程打印系统</p>
    <div class="img"></div>
</div>
<a class="custom" href="customer-regist.jsp" target="main">用户注册</a>
<a class="store" href="store-regist.jsp" target="main">商家注册</a>
<hr>
</body>
</html>
