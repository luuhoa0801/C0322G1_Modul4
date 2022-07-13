<%--
  Created by IntelliJ IDEA.
  User: Luu Hoa
  Date: 6/13/2022
  Time: 10:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Chuyển đổi tiền tệ </h1>

<form action="/tiente" method="post">

    <input type="number" name="usd" placeholder="nhập số tiền muốn đổi">  <span><button > Đổi </button></span>
     <p>Kết quả:  ${result}</p>

</form>
</body>
</html>
