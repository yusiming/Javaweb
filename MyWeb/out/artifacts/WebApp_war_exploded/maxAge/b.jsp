<%--
  Created by IntelliJ IDEA.
  User: 虞四明
  Date: 2018/7/26
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
</body>
</html>
<%
    Cookie cookie = new Cookie("aaa","AAA");
    cookie.setMaxAge(0);
    response.addCookie(cookie);
%>