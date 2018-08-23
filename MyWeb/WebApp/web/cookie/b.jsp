<%--
  Created by IntelliJ IDEA.
  User: 虞四明
  Date: 2018/7/25
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>获取Cookie</h1>
<%
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie:cookies) {
        out.println(cookie.getName() + " = " + cookie.getValue() + "<br/>");
    }
%>
</body>
</html>
