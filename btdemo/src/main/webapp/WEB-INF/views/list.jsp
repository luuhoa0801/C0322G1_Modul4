<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div><a href="/medical"> thêm mới medical </a></div>
<table>
    <tr>
        <th>ID</th>
        <th> Name </th>
        <th> Age </th>
        <th> Travel </th>
        <th> StartDay </th>
        <th> EndDay </th>
        <th> Status </th>
        <th>chinh sua</th>

    </tr>
    <tr>
        <c:forEach items="${listMedical}" var="medical">
    <tr>
        <td> ${medical.id}</td>
        <td> ${medical.name}</td>
        <td> ${medical.age}</td>
        <td> ${medical.travel}</td>
        <td> ${medical.startDay}</td>
        <td> ${medical.endDay}</td>
        <td> ${medical.status}</td>
        <td><a href="/edit/${medical.id}">Edit</a></td>
    </tr>
        </c:forEach>
    </tr>
</table>
</body>
</html>
