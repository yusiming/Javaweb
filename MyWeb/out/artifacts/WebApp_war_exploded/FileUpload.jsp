<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 虞四明
  Date: 2018/8/21
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="<c:url value='/Upload1Servlet'/>" method="post" enctype="multipart/form-data">
    姓名：<input type="text" name="username"/><br/>
    照片：<input type="file" name="photo"/><br/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
