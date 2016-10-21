<%--
  Created by IntelliJ IDEA.
  User: hurong1993
  Date: 2016/10/19
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>left</title>
    <meta charset="utf-8">
    <style type="text/css">
        * {
            margin: 0;
        }

        #left {
            width: 203px;
            height: 576px;
            border-right: 1px solid #777;
            background-color: #3399FF;
            border-radius: 6px;
        }

        #left p {
            width: 203px;
            height: 80px;
        }

        #left a {
            display: block;
            width: 203px;
            height: 80px;
            line-height: 80px;
            text-align: center;
            border-bottom: 2px solid #777;
            border-radius: 6px;
            text-decoration: none;
        }

        a:link {
            font-size: 18px;
            font-weight: 800;
            color: #777;
            text-decoration: none;
        }

        a:hover {
            background-color: #33CCFF;
            color: white;
            font-size: 18px;
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div id="left">
    <p><a href="customer-document.jsp" target="main">我的文件</a></p>
    <p><a href="stu-center-doc.html" target="main">常用店家</a></p>
    <p><a href="stu-center-doc.html" target="main">我的订单</a></p>
    <p><a href="stu-center-doc.html" target="main">个人信息</a></p>
</div>
</body>
</html>
