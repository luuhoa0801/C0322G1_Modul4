<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
<div >
<form action="/dictionary" method="post" >
    <h2> Từ điển  </h2>
    <input type="text" name="world" placeholder="Nhập từ"  >
    <input type="text" value="${result}">
    <button> Dịch</button>
</form>
</div>
</body>
</html>
