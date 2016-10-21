<%--
  Created by IntelliJ IDEA.
  User: hurong1993
  Date: 2016/10/19
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <title>我的文件</title>
    <meta charset="utf-8">
    <style type="text/css">
        *{
            font-family: "Microsoft YaHei" ! important;
        }
        label{
            width: 100%;
            height: 50px;
            display: block;
            line-height: 50px;
            margin-left: 20px;
        }
        .print{
            float: left;
            width: 90px;
            height: 40px;
            font-size: 18px;
            font-weight: 600;
            background-color: #69c2ec;
            border-radius: 6px;
            border: none;
            margin-top: 200px;
        }
        .add{
            float: left;
            width: 90px;
            height: 40px;
            font-size: 18px;
            font-weight: 600;
            background-color: #69c2ec;
            border-radius: 6px;
            margin-left: 100px;
            border: none;
            margin-top: 200px;
        }
        .doc{
            width: 100%;
            height: 60px;
            margin-top: 8px;
            border-left: 0.01em solid #777;
            border-bottom: 0.01em solid #777;
            box-shadow: -0.02em 0.01em 0.02em #777;
            border-radius: 3px;
        }
        .doc:hover{
            border: 1px solid #777;
        }
    </style>
    <script type="text/javascript">
        function print(){
            window.open ('selectstore.jsp','newwindow','height=400,width=300,top=200,left=600,toolbar=no,menubar=no,scrollbars=yes,resizable=no,location=no, status=no,')
        };
    </script>
</head>
<body>
<form action="mydoc.action" method="post">
    <div class="doc">
        <label><input name="document" type="checkbox" value="" />综合素质课作业 <span>word</span> </label>
    </div>
    <div class="doc">
        <label><input name="document" type="checkbox" value="" />桃子 <span></span></label>
    </div>
    <input class="print" type="button" onclick="print()" value="打 印">
    <input class="add" type="button" value="上传文档">
</form>
</body>
</html>