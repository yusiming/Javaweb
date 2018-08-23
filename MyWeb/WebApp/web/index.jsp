<%--
  Created by IntelliJ IDEA.
  User: 虞四明
  Date: 2018/7/25
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>$Title$</title>
    <style type="text/css">
    </style>
</head>
<body>
<h1 id="h1"></h1>
<button id="button1">点击这里</button>
</body>
<script type="text/javascript">
    window.onload = function () {
        // 得到button元素
        var buttonElement = document.getElementById("button1");
        // 给button的onclick注册监听
        buttonElement.onclick = function () {
            var h1Element = document.getElementById("h1");
            h1Element.innerHTML = "Hello js";
        };
    };
</script>
</html>