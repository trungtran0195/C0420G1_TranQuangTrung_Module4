<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 05/15/2020
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<h3>Sandwich Condiments</h3>
<body>
<form:form method="POST" action="/addCondiment" modelAttribute="condiment">
<table>
    Condiments:
    Lettuce<form:checkbox path="condiment" value="Lettuce"/>
    Tomato<form:checkbox path="condiment" value="Tomato"/>
    Mustard<form:checkbox path="condiment" value="Mustard"/>
    Sprouts<form:checkbox path="condiment" value="Sprouts"/>
    <form:button type="submit" value="Submit">Submit</form:button>
</table>
</form:form>
</body>
</html>