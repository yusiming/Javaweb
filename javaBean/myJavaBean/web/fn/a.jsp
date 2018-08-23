<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: 虞四明
  Date: 2018/7/30
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> </title>
</head>
<body>

</body>
</html>
<%
    String[] arr = {"a","b","c"};
    pageContext.setAttribute("arr",arr);
%>
${fn:length(arr)}