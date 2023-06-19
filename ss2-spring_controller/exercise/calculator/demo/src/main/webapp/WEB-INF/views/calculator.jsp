<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/16/2023
  Time: 12:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/calculator/calculate">
    <h1>Calculator</h1>

    <input name="number1" type="number">
    <input name="number2" type="number">
    <br>
    <input type="submit" name="calculate" value="addition">
    <input type="submit" name="calculate" value="subtraction">
    <input type="submit" name="calculate" value="multiply">
    <input type="submit" name="calculate" value="division">

</form>
<p>Result: ${calculate}</p>

</body>
</html>
