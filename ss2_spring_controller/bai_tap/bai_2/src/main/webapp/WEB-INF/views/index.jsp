<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Calculator</h1>
<form method="post" action="/calculator">
    <input type="text" name="number1" placeholder="nhập số thứ nhất">
    <input type="text" name="number2" placeholder="nhâp số thứ hai"><br>
    <button type="submit" name="calculator" value="addition">Addition(+)</button>
    <button type="submit" name="calculator" value="subtraction">Subtraction(-)</button>
    <button type="submit" name="calculator" value="multiplication">Multiplication(*)</button>
    <button type="submit" name="calculator" value="division">Division(/)</button>
</form>
<h2>kết quả :</h2>
<h3>${result}</h3>
<h1>${message}</h1>
</body>
</html>