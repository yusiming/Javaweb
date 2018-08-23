<%--
  Created by IntelliJ IDEA.
  User: 虞四明
  Date: 2018/7/30
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    out.print("bbb");
    request.setCharacterEncoding("utf-8");
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    out.print(username);
    out.print(password);
%>
