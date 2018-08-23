<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 虞四明
  Date: 2018/8/23
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="post">
    用户名：<input type="text" name="username" id="username"/><span id="errorspan"></span><br/>
    密 码：<input type="text" name="password" id="password"/><br/>
    <input type="submit" value="注册"/>
</form>
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
        // 得到username元素
        var userElement = document.getElementById("username");
        // 给userElement的失去焦点事件注册监听
        userElement.onblur = function () {
            // ajax的四步，向服务器发送请求，得到响应，
            // 得到xmlHttpRequest对象
            var xmlHttp = createXMLHttpRequest();
            // 打开与服务器的连接，设置请求方法，url，是否为异步请求
            xmlHttp.open("POST", "<c:url value='/VerifyUsernameServlet'/> ", true);
            // 设置请求头
            xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            // 发送请求
            xmlHttp.send("username=" + userElement.value);

            // 给异步对象的onreadystatechange事件注册监听
            xmlHttp.onreadystatechange = function () {
                // 双重判断，xmlHttp的状态码为4（服务器响应结束），以及服务器相应的状态码为200（响应成功）
                if (xmlHttp.readyState === 4 && xmlHttp.status === 200) {
                    // 获取响应结果
                    var text = xmlHttp.responseText;
                    // 得到h1元素
                    var errorspanEle = document.getElementById("errorspan");
                    if (text === "1") {
                        errorspanEle.innerHTML = "用户名已被注册";
                    } else {
                        errorspanEle.innerHTML = "";
                    }
                }
            }
        }
    }
</script>
</html>
