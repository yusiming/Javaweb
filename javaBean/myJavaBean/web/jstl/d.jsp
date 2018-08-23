<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 虞四明
  Date: 2018/8/1
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:out value="${param.name}"/>
<c:if test="${empty param.name}">
    你未给出name参数
</c:if>
<br/>
<c:choose>
    <c:when test="${empty param.name}">
        你未给出name参数的值
    </c:when>
    <c:otherwise>
        你给出了name参数的值
    </c:otherwise>
</c:choose>
<br/>
<c:forEach var="i" begin="1" end="10" step="2">
    ${i}<br/>
</c:forEach>
</body>
</html>
<%
    String[] arr1 = {"aa","bb"};
    int[] a = {1,2,3,4,};
    request.setAttribute("arr1",arr1);
    request.setAttribute("arr2",a);
%>
<c:forEach items="${requestScope.arr1}" var="str">
    ${str}
</c:forEach><br/>
<c:forEach items="${arr2}" varStatus="n">
    ${n.index}  ${n.count} ${n.first} ${n.last} ${n.current} <br/>
</c:forEach>