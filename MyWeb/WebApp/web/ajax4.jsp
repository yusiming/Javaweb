<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 虞四明
  Date: 2018/8/24
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>省市联动</h1>
<select name="province" id="select1">
    <option>===请选择省份===</option>
</select>
<select name="city" id="select2">
    <option>===请选择城市===</option>
</select>
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

    var select1 = document.getElementById("select1");
    window.onload = function () {
        var xmlHttp = createXMLHttpRequest();
        // 设置参数
        xmlHttp.open("GET", "<c:url value='/ProvinceServlet'/>", true);
        xmlHttp.send(null);
        xmlHttp.onreadystatechange = function () {
            if (xmlHttp.readyState === 4 && xmlHttp.status === 200) {
                var text = xmlHttp.responseText;
                var List = text.split(",");
                for (var i = 0; i < List.length; i++) {
                    var option = document.createElement("option");
                    option.value = List[i];
                    option.appendChild(document.createTextNode(List[i]));
                    select1.appendChild(option);
                }
            }
        }
    };
    // 每次改变省份,向服务器发送POST请求，参数为省份
    select1.onchange = function () {
        var select2 = document.getElementById("select2");
        var arr = select2.getElementsByTagName("option");
        if (arr.length > 1) {
            while (arr.length > 1) {
                select2.removeChild(arr[1]);
            }
        }
        var xmlHttp = createXMLHttpRequest();
        // 设置参数
        xmlHttp.open("POST", "<c:url value='/CityServlet'/>", true);
        xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xmlHttp.send("province=" + select1.value);
        xmlHttp.onreadystatechange = function () {
            if (xmlHttp.readyState === 4 && xmlHttp.status === 200) {
                // 得到xml数据，遍历得到每一个城市的名字
                var xml = xmlHttp.responseXML;
                var cityList = xml.getElementsByTagName("city");
                for (var i = 0; i < cityList.length; i++) {
                    var text = cityList[i].textContent;
                    var option = document.createElement("option");
                    option.value = text;
                    option.appendChild(document.createTextNode(text));
                    select2.appendChild(option);
                }
            }
        }
    }
</script>
</html>
