<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/17/2023
  Time: 6:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>Languages: </td>
        <td>${email.languages}</td>
    </tr>
    <tr>
        <td>Page size: </td>
        <td>${email.size}</td>
    </tr>
    <tr>
        <td>Spams filter:</td>
        <td>${email.filter}</td>
    </tr>
    <tr>
        <td>Signature: </td>
        <td>${email.signature}</td>
    </tr>
    <tr>
        <td><a href="/email/setting-email">Setting</a></td>
    </tr>
</table>

</body>
</html>
