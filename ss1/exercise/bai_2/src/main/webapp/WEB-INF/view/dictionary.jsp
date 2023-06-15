<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/15/2023
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/dictionary/translate">
    <table>
        <tr>
            <td>English word: </td>
            <td><input name="english" type="text"></td>
        </tr>
        <tr>
            <input type="submit" value="Translate">
        </tr>
        <tr>
            <td>VietNamese word:</td>
            <td>${word}</td>
        </tr>
    </table>
</form>

</body>
</html>
