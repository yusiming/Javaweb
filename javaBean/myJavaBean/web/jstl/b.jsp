<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 虞四明
  Date: 2018/8/1
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="a" value="yusiming" scope="application" />
<%--scope的默认值是全域--%>
<c:remove var="a" scope="request"/>
<c:out value="${a}"/><br/>
<c:remove var="a"/>
<c:out value="${a}" default="没有对应的值"/>
</body>
</html>
