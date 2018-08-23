<%--
  Created by IntelliJ IDEA.
  User: 虞四明
  Date: 2018/8/23
  Time: 11:01
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
    // 文档加载完毕时，执行该操作，
    window.onload = function () {
        var buttonElement = document.getElementById("button1");
        // 给按钮的点击时间注册监听
        buttonElement.onclick = function () {
            // ajax的四步操作，向服务器发送请求，把响应结果显示到h1元素中
            // 得到异步对象
            var xmlHttp = createXMLHttpRequest();
            // 打开与服务器的连接
            // 指定请求方法、URL、是否为异步请求
            xmlHttp.open("GET","<c:url value='/AJAXServlet'/>",true);
            // 发送请求,get请求没有体，但是不加null，有些浏览器可能会出错，比如Firefox
            xmlHttp.send(null);
            // 给异步对象的onreadystatechangge事件注册监听
             xmlHttp.onreadystatechange = function () {
                 // 双重判断，xmlHttp的状态码为4（服务器响应结束），以及服务器相应的状态码为200（响应成功）
                 if (xmlHttp.readyState === 4 && xmlHttp.status === 200) {
                     // 获取响应结果
                     var text = xmlHttp.responseText;
                     // 得到h1元素
                     var h1Element = document.getElementById("h1");
                     h1Element.innerHTML = text;
                 }
             }
        }
    };
</script>
</html>
