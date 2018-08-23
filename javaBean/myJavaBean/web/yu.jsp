<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: 虞四明
  Date: 2018/7/31
  Time: 18:49
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
${param.username[0]}
${paramValues.hobby[0]}
${paramValues.hobby[1]}
${initParam.name1}<br/>
${header['User-Agent']}<br/>
<%--cookie.Map<String,Cookie>类型，其中key是cookie的name，value是cookie对象--%>
${cookie.JSESSIONID.value}<br/>
<%--返回项目名--%>
${pageContext.request.contextPath}
