<%--
  Created by IntelliJ IDEA.
  User: 虞四明
  Date: 2018/7/31
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="person" class="yu.domain.Person" scope="session"/><br/>
<jsp:getProperty property="name" name="person"/><br/>
</body>
</html>
