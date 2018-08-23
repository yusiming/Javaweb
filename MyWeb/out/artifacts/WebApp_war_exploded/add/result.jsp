<%--
  Created by IntelliJ IDEA.
  User: 虞四明
  Date: 2018/7/25
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Integer result = (Integer) request.getAttribute("result");
%>
<%=
  result
%>
</body>
</html>
