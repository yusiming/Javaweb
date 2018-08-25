<%--
  Created by IntelliJ IDEA.
  User: 虞四明
  Date: 2018/8/24
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 id="h1"></h1>
<button id="button1">点击这里</button>
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
        var buttonElement = document.getElementById("button1");
        // 给userElement的失去焦点事件注册监听
        buttonElement.onclick = function () {
            // ajax的四步，向服务器发送请求，得到响应，
            // 得到xmlHttpRequest对象
            var xmlHttp = createXMLHttpRequest();
            // 打开与服务器的连接，设置请求方法，url，是否为异步请求
            xmlHttp.open("GET", "<c:url value='/Ajax2Servlet'/> ", true);
            // 设置请求头
            //xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            // 发送请求
            xmlHttp.send(null);

            // 给异步对象的onreadystatechange事件注册监听
            xmlHttp.onreadystatechange = function () {
                // 双重判断，xmlHttp的状态码为4（服务器响应结束），以及服务器相应的状态码为200（响应成功）
                if (xmlHttp.readyState === 4 && xmlHttp.status === 200) {
                    // 获取响应结果,一个document对象
                    var doc = xmlHttp.responseXML;
                    var students = doc.getElementsByTagName("students")[0];
                    var studentEle = students.getElementsByTagName("student")[0];
                    var number = studentEle.getAttribute("number");
                    var name = studentEle.getElementsByTagName("name")[0].textContent;
                    var age = studentEle.getElementsByTagName("age")[0].textContent;
                    var sex = studentEle.getElementsByTagName("sex")[0].textContent;
                    var h1Element = document.getElementById("h1");
                    h1Element.innerHTML = name + " " + age + " " + sex + " " + number;
                }
            }
        }
    }
</script>
</html>
