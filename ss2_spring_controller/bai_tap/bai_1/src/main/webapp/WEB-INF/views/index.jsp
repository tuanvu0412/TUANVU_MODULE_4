<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form method="post" action="/choice">
    <h1>Sandwich Condiments</h1>
    <input type="checkbox" name="name" value="Lettuce">Lettuce
    <input type="checkbox" name="name" value="Tomato">Tomato
    <input type="checkbox" name="name" value="Mustard">Mustard
    <input type="checkbox" name="name" value="Sprouts">Sprouts<br>
    <button type="submit">save</button>
</form>
<h1>Sau khi lưu là: </h1>
<h1>${result}</h1>
</body>
</html>