<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/15/2023
  Time: 11:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/calculator/convert">
    <table>
        <tr>
            <th>USD</th>
            <td><input type="number" name="usd" placeholder="Input USD"></td>
        </tr>
        <tr>
            <th>Tỉ giá</th>
            <td><input type="number" name="exchangeRate" placeholder="Input Exchange Rate "></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form>
${error}
${result}VNĐ
</body>
</html>
