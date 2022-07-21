<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <a href="/list"> Vào trang list email</a>
</div>
<table>
    <tr>
        <td>Langueges :</td>
        <td>${email.languages}</td>
    </tr>
    <tr>
        <td>pageSize :</td>
        <td>${email.pageSize}</td>
    </tr>
    <tr>
        <td>spamsFilter :</td>
        <td>${email.spamsFilter}</td>
    </tr>
    <tr>
        <td>signature :</td>
        <td>${email.signature}</td>
    </tr>
</table>
</body>
</html>
