<%--
  Created by IntelliJ IDEA.
  User: hurong1993
  Date: 2016/10/21
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>我的订单</title>
    <meta charset="utf-8">
    <style type="text/css">
        *{
            font-family: "Microsoft YaHei" ! important;
        }
        .order{
            width: 100%;
            height: 150px;
            border-radius: 5px;
            box-shadow: 0.01em -0.01em 0.02em #777,-0.01em 0.01em 0.02em #777;
        }
        .order:hover{
            box-shadow: 0.05em -0.05em 0.03em black,-0.05em 0.05em 0.03em black;
        }
        .time{
            width: 97%;
            height: 30px;
            font-size: 20px;
            font-weight: 600;
            padding-left: 3%;
            border-radius: 5px;
            background-color: #CCFFCC;
        }
        .time span{
            margin-left: 300px;
            font-size: 18px;
            font-weight: 500;
        }
        .main{
            height: 100px;
            width: 100%;
            margin-top: 0;
        }
        .img{
            width: 93px;
            height: 87px;
            float: left;
            margin-left: 30px;
            background-image: url("../images/logo.jpg");
        }
        .doc{
            width: 280px;
            float: left;
            margin-left: 20px;
        }
        .price{
            float: left;
            margin-left: 100px;
        }
    </style>
</head>
<body>
<div class="order">
    <p class="time">2016年10月21日 <span>友佳图文 店</span></p>
    <div class="main">
        <div class="img"></div>
        <p class="doc">凤凰卡机的哈空间看东方开房间</p>
        <p class="price">xx元</p>
    </div>
</div>
<div class="order">
    <p class="time">2016年10月21日 <span>快点印务 店</span></p>
    <div class="main">
        <div class="img"></div>
        <p class="doc">凤凰卡机的哈空间看东方开更快乐就爱看了发到空间法啊</p>
        <p class="price">xx元</p>
    </div>
</div>
<div class="order">
    <p class="time">2016年10月21日 <span>顺江打印店 店</span></p>
    <div class="main">
        <div class="img"></div>
        <p class="doc">凤凰卡机的哈空间看东方开房间发的发大发安抚</p>
        <p class="price">xx元</p>
    </div>
</div>
</body>
</html>
