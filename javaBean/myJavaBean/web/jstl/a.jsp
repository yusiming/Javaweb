<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 虞四明
  Date: 2018/8/1
  Time: 10:25
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
<%--<%
    request.setAttribute("code","<script>alert('hello');</script>");
%>--%>
<%--使用set标签代替request.setAttribute-- scope的默认值是page%>
<c:set var="code" value="<script>alert('hello');</script>" scope="request"/>
<%--直接使用EL表达式会alert“hello”--%>
${code}
<%--使用c标签的out函数不会直接alert“hello”,会先转义特殊字符--%>
<%--escapeXml="true"属性的默认值是true--%>
<c:out value="${code}" escapeXml="true"/><br/>
<%--输出字符串常量--%>
<c:out value="虞四明" /><br/>
<c:set var="jjj" value="aaaaa" scope="request"/>
<%--若value中的值为空，则输出default中的值--%>
<c:out value= "${jjj}" default="yusiming"/><br/>