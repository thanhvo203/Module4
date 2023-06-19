<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/17/2023
  Time: 6:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--@elvariable id="email" type="com.example.demo1"--%>
<form:form modelAttribute="email" action="/email/detail-email" method="post">
    <table>
        <tr>
            <td>Languages:</td>
            <td><form:select path="languages" items="${languages}">
            </form:select></td>
        </tr>
        <tr>
            <td><form:label path="size" >Page size: </form:label></td>
            <td>Show
                <form:select path="size" items="${size}">

                </form:select>
                emails per page
            </td>
        </tr>
        <tr>
            <td><form:label path="filter">Spams filter</form:label></td>
            <td>
                <form:checkbox path="filter"/>Enable spams filter
            </td>
        </tr>
        <tr>
            <td><form:label path="signature"/>Signature: </td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"></td>
            <td><input type="reset" value="Cancel"></td>
        </tr>
    </table>
</form:form>

</body>
</html>
