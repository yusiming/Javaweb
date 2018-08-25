<%--
  Created by IntelliJ IDEA.
  User: 虞四明
  Date: 2018/8/25
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>json的应用</title>
</head>
<body>

</body>
<script type="text/javascript">
    window.onload = function () {
        //var person = {"name":"张三","age":18,"sex":"male"};
        var  str = "{\"name\":\"张三\",\"age\":18,\"sex\":\"male\"}";
        var person = eval("(" + str + ")");
        window.alert(person.name + person.age + person.sex);
    }
</script>
</html>
