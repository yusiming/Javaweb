<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 虞四明
  Date: 2018/8/25
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 id="h1"></h1>
<button id="button">点击这里</button>
</body>
<script type="text/javascript">
    // 创建异步对象
    function createXMLHttpRequest() {
        try {
            // 支持大多数浏览器
            return new XMLHttpRequest();
        } catch (e) {
            try {
                // 支持ie6.0
                return new ActiveXObject("Msxm12.XMLHTTP");
            } catch (e) {
                try {
                    // 支持ie5.5以及更早版本
                    return new ActiveXObject("Microsoft.XMLHTTP");
                } catch (e) {
                    window.alert("您用的什么鬼浏览器");
                    throw e;
                }
            }
        }
    }

    window.onload = function () {
        var buttonElement = document.getElementById("button");
        var h1Element = document.getElementById("h1");
        buttonElement.onclick = function () {
            // 得到异步对象
            var xmlHttp = createXMLHttpRequest();
            // 打开连接
            xmlHttp.open("GET", "<c:url value='/JsonServlet'/> ", true);
            // 发送请求
            xmlHttp.send(null);

            // 给异步对象的onreadystatechange属性注册监听
            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.readyState === 4 && xmlHttp.status === 200) {
                    // 得到服务器发送过来的字符串
                    var text = xmlHttp.responseText;
                    var person = eval("(" + text + ")");
                    h1Element.innerHTML = person.name + "," + person.age + "," + person.sex;
                }
            }
        }
    }
</script>
</html>
