<%--
  Created by IntelliJ IDEA.
  User: duytr
  Date: 8/20/2020
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>Email Setting</h3>
    <a href="/emailSetting/addEmailSetting">Add New Email Setting</a>
    <table border="1">
        <tr>
            <td>Languages:</td>
            <td>Page Size:</td>
            <td>Spam</td>
            <td>Signature</td>
            <td>Action</td>
        </tr>
        <c:forEach var="email" items="${emails}">
        <tr>
            <td>${email.getLanguage()}</td>
            <td>${email.getPagesizes()}</td>
            <td>${email.spamfiller}</td>
            <td>${email.signature}</td>
            <td><a href="/emailSetting/edit/${email.id}">edit</a> </td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
