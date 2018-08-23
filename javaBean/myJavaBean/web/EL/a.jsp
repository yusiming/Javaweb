<%@ page import="yu.domain.Address" %>
<%@ page import="com.sun.nio.sctp.PeerAddressChangeNotification" %>
<%@ page import="yu.domain.Employee" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: 虞四明
  Date: 2018/7/30
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Address address = new Address();
    address.setCity("上海");
    address.setStreet("普陀区梅岭路");
    Employee employee = new Employee();
    employee.setAddress(address);
    employee.setName("虞四明");
    employee.setSalary(20000);
    request.setAttribute("employee",employee);
%>
${requestScope.employee.address.street}
</body>
</html>
