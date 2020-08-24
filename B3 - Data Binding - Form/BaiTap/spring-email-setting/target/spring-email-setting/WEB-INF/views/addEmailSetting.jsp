<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Add Email Setting</h3>
<form:form action="/emailSetting/addEmailSetting" method="post" modelAttribute="email">
    <br>
    <br>
    <label>Id: </label>
    <form:input path="id"/>
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
    <form:textarea path="signature"/>
    <br>
    <br>
    <input type="submit" value="Add">
</form:form>

</body>
</html>
