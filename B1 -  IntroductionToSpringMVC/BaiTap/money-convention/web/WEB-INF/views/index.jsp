<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Greeting</title>
</head>
<body>
<form action="/sum">
    <form:input type="text" name="number1" />
    <input type="submit" value="Converter" />
</form>
<h1>Result: ${sumNum12}</h1>
</body>
</html>