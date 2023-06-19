<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form:form action="/detail" method="post" modelAttribute="email">
    <table>
        <tr>
            <th>Languages:</th>
            <td><form:select path="languages">
                <form:option value="English"/>
                <form:option value="Vietnamese"/>
<%--                <form:option value="${languages}">--%>
<%--                </form:option>--%>
            </form:select></td>
        </tr>
        <tr>
            <th><form:label path="size">Page size: </form:label></th>
            <td>Show
                <form:select path="size" items="${size}">

                </form:select>
                emails per page
            </td>
        </tr>
        <tr>
            <th><form:label path="filter">Spams filter:</form:label></th>
            <td>
                <form:checkbox path="filter"/>Enable spams filter
            </td>
        </tr>
        <tr>
            <th><form:label path="signature"/>Signature:</th>
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
