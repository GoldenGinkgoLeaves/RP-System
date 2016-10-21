<%--
  Created by IntelliJ IDEA.
  User: hurong1993
  Date: 2016/10/20
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script language="JavaScript">
    function MyAutoRun()
    {
        alert("用户名或密码错误");
        window.open('/login/login.jsp',"_parent");
    }
    window.onload=MyAutoRun();
</script>
