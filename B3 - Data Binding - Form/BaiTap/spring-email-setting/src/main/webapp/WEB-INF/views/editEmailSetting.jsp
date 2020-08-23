<%--<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: duytr
  Date: 8/21/2020
  Time: 1:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Edit Email Setting</h3>
<form:form action="/emailSetting/edit" method="post" modelAttribute="email">
    <form:hidden items="${email.id}" path="id"/>
    <br>
    <br>
    <label>Languages: </label>
    <form:select path="language">
        <form:options items="${languages}" ></form:options>
    </form:select>
    <br>
    <br>
    <label>Page Size: </label>
    <form:select path="pagesizes">
        <form:options items="${pagesize}"></form:options>
    </form:select>
    <br>
    <br>
    <label>Spams fillers: </label>
    <form:checkbox value="spamfiller" path="spamfiller"/>
    <br>
    <br>
    <label>Languages: </label>
    <form:textarea items="${email.signature}" path="signature"/>
    <br>
    <br>
    <input type="submit" value="Edit">
</form:form>

</body>
</html>
