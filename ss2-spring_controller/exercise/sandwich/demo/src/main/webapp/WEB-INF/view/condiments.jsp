<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/16/2023
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/condiments/save" method="post">
    <input type="checkbox" name="condiment" value="lettuce">Lettuce
    <input type="checkbox" name="condiment" value="tomato">Tomato
    <input type="checkbox" name="condiment" value="mustard">Mustard
    <input type="checkbox" name="condiment" value="sprouts">Sprouts
    <hr>
    <input type="submit" value="Save">
</form>
<p>Sandwich have condiment is : ${list}</p>

</body>
</html>
