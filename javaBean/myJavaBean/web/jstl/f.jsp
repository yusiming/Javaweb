<%@taglib prefix="yu" uri="http://yusiming.com/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 虞四明
  Date: 2018/8/1
  Time: 16:34
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
    request.setAttribute("a","yusiming");
%>
<%--http://localhost:8080/myJavaBean/jstl/f.jsp?name=yusiming--%>
<yu:Tag5 test="${empty param.name}">
    <yu:Tag4/>
</yu:Tag5>

<yu:Tag1/>
<br/>
<yu:Tag2/>
<br/>
<yu:Tag3>
    虞四明
</yu:Tag3>
<yu:Tag3>
    ${a}
</yu:Tag3>