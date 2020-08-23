<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="/sum">
    <table>
    <td>
    <input type="text" name="number1" />
    <input type="text" name="number2" />
    </td>
    <td>
    <input type="submit" name="calculate" value="Addition(+)" />
    <input type="submit" name="calculate" value="Subtraction(-)" />
    <input type="submit" name="calculate" value="Multiplication(x)" />
    <input type="submit" name="calculate" value="Division(/)" />
    </td>
    </table>
</form>
<h1>Result: ${sumNum12}</h1>
</body>
</html>