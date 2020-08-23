<%--
  Created by IntelliJ IDEA.
  User: TECHNOLOGY
  Date: 15/05/2020
  Time: 10:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${result}" var="condiment">
    <c:out value="${condiment}"></c:out>
</c:forEach>
</body>
</html>