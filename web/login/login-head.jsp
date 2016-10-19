<%--
  Created by IntelliJ IDEA.
  User: hurong1993
  Date: 2016/10/19
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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
            padding-left: 40px;
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
            height: 30px;
            float: left;
            margin-top: 50px;
            color: rgb(154, 153, 153);
            font-size: 18px;
            text-decoration: none;
            text-align: right;
            padding: 0 20px;
            margin-left: 570px;
        }
        .store{
            display: block;
            float: left;
            font-size: 18px;
            height: 30px;
            text-decoration: none;
            color: rgb(154, 153, 153);
            margin-top: 50px;
            padding: 0 20px;
        }
        a:link{
            font-size: 18px;
            height: 30px;
        }
        a:active{
            border-bottom: 2px solid blue;
            color: blue;
        }
        hr{
            clear: both;
            width: 60%;
            height: 2px;
            background-color: #999999;
            margin-left: 260px;
            margin-top: 96px;
            border-radius: 2px;
        }
    </style>
</head>
<body>
<div id="head">
    <p>远程打印系统</p>
    <div class="img"></div>
</div>
<a class="custom" href="customer-login.jsp" target="main">用户登陆</a>
<a class="store" href="store-login.jsp" target="main">商家登陆</a>
<hr>
</body>
</html>