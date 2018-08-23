<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 虞四明
  Date: 2018/8/1
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<c:url value='/index.jsp'/>">点击这里回到主页</a>

</body>
</html>
<c:url value="/index.jsp">
    <%--自动url编码 name=%e8%99%9e%e5%9b%9b%e6%98%8e--%>
    <c:param name="name" value="虞四明"/>
</c:url>