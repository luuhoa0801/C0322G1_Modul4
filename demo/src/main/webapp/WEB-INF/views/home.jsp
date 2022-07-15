<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calculator" method="post">
    <p> calculator</p>
    <input type="text" name="number1" value="${number1}">
    <input type="text" name="number2" value="${number2}">
    <div>
        <button value="+" type="submit" name="check"> Addition(+)</button>
        <button value="-" type="submit" name="check"> Subtraction(-)</button>
        <button value="*" type="submit" name="check"> Multiplication(*)</button>
        <button value="/" type="submit" name="check"> Division(/)</button>
    </div>

    <p> ket qua: ${result} </p>
</form>

</body>
</html>
