<%--
  Created by IntelliJ IDEA.
  User: hurong1993
  Date: 2016/10/18
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script language="JavaScript">
    function MyAutoRun()
    {
        alert("用户名不能为空");
        window.open("/customer/regist/regist.jsp","_parent");
    }
    window.onload=MyAutoRun();
</script>
