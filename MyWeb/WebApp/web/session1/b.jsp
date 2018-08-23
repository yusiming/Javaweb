<%--
  Created by IntelliJ IDEA.
  User: 虞四明
  Date: 2018/7/26
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>获取session域中的数据</h1>
<%
    String s = (String) session.getAttribute("aaa");
    out.print(s);
%>
</body>
</html>