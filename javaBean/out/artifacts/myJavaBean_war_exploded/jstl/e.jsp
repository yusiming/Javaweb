<%@ page import="java.util.Date" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 虞四明
  Date: 2018/8/1
  Time: 14:20
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
    Date date = new Date();
    double n = 3.1;
    request.setAttribute("date",date);
    request.setAttribute("num1",n);
%>
<fmt:formatDate value="${requestScope.date}" pattern="yyyy-MM-dd HH:mm:ss"/><br/>
<fmt:formatNumber value="${num1}" pattern="0.000"/><br/>
<fmt:formatNumber value="${num1}" pattern="#.###"/>