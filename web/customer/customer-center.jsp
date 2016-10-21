<%--
  Created by IntelliJ IDEA.
  User: hurong1993
  Date: 2016/10/19
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>远程打印系统</title>
    <meta charset="utf-8">
</head>
<frameset rows="90,*" border="none">
    <frame src="/customer/customer-centerhead.jsp" name="top">
    <frameset cols="15%,*">
        <frame src="/customer/customer-centerleft.jsp" name="left">
        <frame src="/customer/customer-document.jsp" name="main">
    </frameset>
</frameset>
</html>
