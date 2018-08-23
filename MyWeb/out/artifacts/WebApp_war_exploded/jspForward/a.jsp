<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: 虞四明
  Date: 2018/7/30
  Time: 14:16
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
<%-- 动态包含 --%>
<%
    out.print("aaa");
    String s = URLEncoder.encode("虞四明", "utf-8");
    request.setCharacterEncoding("utf-8");
%>
<jsp:forward page="b.jsp">
    <jsp:param name="username" value="虞四明"/>
    <jsp:param name="password" value="123"/>
</jsp:forward>