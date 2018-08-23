<%--
  Created by IntelliJ IDEA.
  User: 虞四明
  Date: 2018/7/25
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>保存Cookie</h1>
<%
    Cookie cookie1 = new Cookie("aaa","AAA");
    response.addCookie(cookie1);
    Cookie cookie2 = new Cookie("bbb","BBB");
    response.addCookie(cookie2);
%>
</body>
</html>