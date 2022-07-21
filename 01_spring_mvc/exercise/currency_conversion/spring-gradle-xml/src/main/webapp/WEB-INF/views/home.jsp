
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
<h1> Chuyển đổi tiền tệ </h1>

<form action="/money" method="post">
    <input type="number" name="usd" placeholder="nhập số tiền muốn đổi" value="${usd}" >
    <span><button > Đổi </button></span>
     <p>Kết quả:  ${result}</p>
</form>
</body>
</html>
