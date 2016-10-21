<%--
  Created by IntelliJ IDEA.
  User: hurong1993
  Date: 2016/10/20
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>选择店家</title>
    <meta charset="utf-8">
    <style type="text/css">
        .select{
            font-size: 18px;
            color: blue;
            width: 100%;
            font-weight: 600;
            text-align: center;
        }
        .one{
            font-size: 20px;
            font-weight: 600;
            color: #777;
            border-radius: 5px;
            box-shadow: 0.01em -0.01em 0.02em #777,-0.01em 0.01em 0.02em #777
        }
        .one span{
            margin-left: 15px;
            color: red;
            font-size: 16px;
        }
        .one p{
            margin-left:20px;
            margin-top: 2px;
            font-size: 14px;
        }
        input[type="button"]{
            margin-left: 32%;
            height: 35px;
            width: 80px;
            font-size: 20px;
            font-weight: 600;
            background-color: #69c2ec;
            border: none;
            border-radius: 5px;
        }
    </style>
    <script type="text/javascript">
        function pay(){
            window.open ('pay.jsp','newwindow','height=400,width=300,top=200,left=600,toolbar=no,menubar=no,scrollbars=yes,resizable=no,location=no, status=no')
        };
    </script>
</head>
<body>
<form action="selectstore.action" method="post">
    <p class="select">请选择一个店家</p>
    <div class="one">
        <input type="radio" name="store" value="id">顺江打印店
        <span>合计3元</span>
        <p>电子科大南门</p>
    </div>
    <div class="one">
        <input type="radio" name="store" value="id">快点印务
        <span>合计3元</span>
        <p>电子科大南门</p>
    </div>
    <div class="one">
        <input type="radio" name="store" value="id">龙湖打印店
        <span>合计3元</span>
        <p>电子科大南门</p>
    </div>
    <input type="button" onclick="pay()" value="付 款">
</form>
</body>
</html>
