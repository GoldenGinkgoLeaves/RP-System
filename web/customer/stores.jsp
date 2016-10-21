<%--
  Created by IntelliJ IDEA.
  User: hurong1993
  Date: 2016/10/21
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>常用店家</title>
    <meta charset="utf-8">
    <style type="text/css">
        *{
            font-family: "Microsoft YaHei" ! important;
        }
        .default{
            width: 100%;
            height: 60px;
            margin-top: 5px;
            border-right: 0.02em solid #777;
            box-shadow: 0.01em -0.01em 0.02em #777,-0.01em 0.01em 0.02em #777;
            border-radius: 3px;
        }
        .store{
            width: 100%;
            height: 60px;
            margin-top: 8px;
            border-right: 0.02em solid #777;
            box-shadow: 0.01em -0.01em 0.02em #777,-0.01em 0.01em 0.02em #777;
            border-radius: 3px;
        }
        .name{
            margin-left: 37%;
            float: left;
            display: block;
            margin-top: 10px;
            font-size: 20px;
            text-align: right;
        }
        .price{
            float: left;
            display: block;
            margin-top: 10px;
            font-size: 20px;
            padding-left: 10px
        }
        .address{
            clear: both;
            width: 100%;
            height: 18px;
            margin-top: 0px;
            text-align: center;
            font-size: 15px;
            color: #777;
        }
        .delf{
            color: red;
        }
        h2{
            margin-left: 20px;
            color: #69c2ec;
            font-family: "Microsoft YaHei";
        }
    </style>
</head>
<body>
<h2>常用店家</h2>
<div class="default">
    <span class="name">快点印务</span>
    <span class="price">(黑白xx元/张，彩色xx元/张)--<span class="delf">默认店家</span> </span>
    <p class="address">南门</p>
</div>
<div class="store">
    <span class="name">快点印务</span>
    <span class="price">(黑白xx元/张，彩色xx元/张)</span>
    <p class="address">南门</p>
</div>
<div class="store">
    <span class="name">快点印务</span>
    <span class="price">(黑白xx元/张，彩色xx元/张)</span>
    <p class="address">地址：南门</p>
</div>
</body>
</html>
