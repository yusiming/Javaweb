<%--
  Created by IntelliJ IDEA.
  User: 虞四明
  Date: 2018/7/27
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String name = (String) session.getAttribute("name");
    if (name != null) {
        out.print("<h1>" + "欢迎登陆!" + name + "</h1>");
    } else {
        request.setAttribute("message","您还未登陆");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(request,response);
    }
%>
</body>
</html>
