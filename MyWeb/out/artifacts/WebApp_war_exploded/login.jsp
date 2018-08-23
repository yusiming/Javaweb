<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: 虞四明
  Date: 2018/7/27
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>
<%
    /*
    * 判断request域中是否保存了信息，如果保存了信息，
    * 要么没有登陆
    * 要么登陆失败
    */
    String mess = "";
    String message = (String) request.getAttribute("message");
    if (message != null) {
        mess = message;
    }
%>
<%
    /*
    * 判断Cookie中是否有名为name的的头
    * 如果有显示在名字的默认值
    */
    String userName = "";
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie:cookies) {
        if ("userName".equals(cookie.getName())) {
            userName = URLDecoder.decode(cookie.getValue(),"utf-8");
        }
    }
%>
  <h1><%= mess %></h1>
  <form action="/WebApp/LoginServlet" method="post">
      姓  名：<input type="text" name="name" value="<%= userName %>"/><br/>
      密  码：<input type="password" name="password"/><br/>
      验证码：<input type="text" name="userVerifyCode"><img id="img1" src="/WebApp/VerifyCodeServlet"><a href="javascript:changeImage();">看不清换一张</a><br/>
      <input type="submit" value="登陆"/><br/>
  </form>
</body>
<script type="text/javascript">
    function changeImage() {
        var imageElement = document.getElementById("img1");
        imageElement.src = "/WebApp/VerifyCodeServlet?a = " + new Date().getTime();
    }
</script>
</html>