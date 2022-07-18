<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <a href="/list"> Vào trang list medical</a>
</div>
<table>
    <tr>
        <td>name :</td>
        <td>${medical.name}</td>
    </tr>
    <tr>
        <td>age :</td>
        <td>${medical.age}</td>
    </tr>
    <tr>
        <td>travel :</td>
        <td>${medical.travel}</td>
    </tr>
    <tr>
        <td>startDay :</td>
        <td>${medical.startDay}</td>
    </tr>
    <tr>
        <td>endDay :</td>
        <td>${medical.endDay}</td>
    </tr>
    <tr>
        <td>status :</td>
        <td>${medical.status}</td>
    </tr>
</table>
</body>
</html>
