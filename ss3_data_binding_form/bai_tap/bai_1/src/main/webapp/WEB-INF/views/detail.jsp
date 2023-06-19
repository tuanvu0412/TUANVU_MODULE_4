<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/06/2023
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Languages: </th>
        <td>${email.languages}</td>
    </tr>
    <tr>
        <th>Page size: </th>
        <td>${email.size}</td>
    </tr>
    <tr>
        <th>Spams filter:</th>
        <td>${email.filter}</td>
    </tr>
    <tr>
        <th>Signature: </th>
        <td>${email.signature}</td>
    </tr>
    <tr>
        <th><a href="/setting">update</a></th>
    </tr>
</table>

</body>
</html>
