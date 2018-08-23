<%--
  Created by IntelliJ IDEA.
  User: 虞四明
  Date: 2018/7/30
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%
  pageContext.setAttribute("xxx","pageContext_XXX");
  request.setAttribute("xxx","request_XXX");
  session.setAttribute("xxx","session_XXX");
  application.setAttribute("xxx","application_XXX");
%><br/>
${xxx}<br/>
${pageScope.xxx}<br/>
${requestScope.xxx}<br/>
${sessionScope.xxx}<br/>
${applicationScope.xxx}<br/>
  </body>
</html>
