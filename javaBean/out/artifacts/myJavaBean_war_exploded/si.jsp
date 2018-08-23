<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: 虞四明
  Date: 2018/7/31
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="person" class="yu.domain.Person" scope="session"/><br/>
<jsp:setProperty name="person" property="name" value="虞四明"/><br/>
${fn:toUpperCase("yusiming")}<br/>
${fn:toLowerCase("YUSIMING")}<br/>
${fn:indexOf("虞四明", "虞")}<br/>
${fn:length("虞四明")}<br/>
${fn:contains("YUSIMING", "yu")}<br/>
${fn:containsIgnoreCase("YUSIMING", "yu")}<br/>
${fn:startsWith("yusiming", "yu")}<br/>
${fn:endsWith("yusiming", "ming")}<br/>
${fn:substring("yusiming", 0, 2)}<br/>
${fn:substring("yusiming", 2, 4)}<br/>
${fn:substring("yusiming", 4, 8)}<br/>
${fn:substringAfter("yusiming", "si")}<br/>
${fn:substringBefore("yusiming", "si")}<br/>
${fn:escapeXml("<a>点击这里</a>")}<br/>
${fn:trim(" yusiming ")}<br/>
${fn:replace("yusimng", "si", "yu")}<br/>
${fn:split("yu-si-ming", "-")[2]}<br/>
${fn:join(fn:split("yu-si-ming", "-"), "*")}<br/>
</body>
</html>