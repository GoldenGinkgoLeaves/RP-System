<%--
  Created by IntelliJ IDEA.
  User: hurong1993
  Date: 2016/10/20
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>支付</title>
    <meta charset="utf-8">
    <style type="text/css">
        *{
            font-family: "Microsoft YaHei" ! important;
        }
        .price{
            font-size: 18px;
            font-weight: 600;
            text-align: center;
            margin-top: 30px;
        }
        input[type="text"]{
            display: block;
            height: 30px;
            width: 185px;
            font-size: 16px;
            border: 1px solid #D2D2D2;
            margin-left: auto;
            margin-right: auto;
        }
        .notice{
            font-size: 16px;
            color: #777;
            width: 100%;
            text-align: center;
        }
        input[type="button"]{
            display: block;
            height: 30px;
            width: 80px;
            font-size: 18px;
            font-weight: 600;
            background-color: #33CCFF;
            margin-left: auto;
            margin-right: auto;
            border: none;
            border-radius: 5px;
            margin-top: 30px;
        }
        hr{
            margin-top: 30px;
        }
    </style>
</head>
<body>
<form action="pay.action" method="post">
    <p class="price">总计： xx元</p>
    <hr>
    <p class="notice">请输入支付密码</p>
    <input type="text" name="">
    <hr>
    <input type="button" value="确定">
</form>

</body>
</html>
