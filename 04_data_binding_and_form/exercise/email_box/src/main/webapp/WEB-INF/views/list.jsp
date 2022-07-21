<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>

</head>
<body>
<div><a href="/email"> thêm mới email</a></div>
<table>
    <tr>
        <th> Languages</th>
        <th> Pagesize</th>
        <th> SpamsFilter</th>
        <th> Signature</th>
    </tr>
    <tr>
        <c:forEach items="${listEmail}" var="email">
    <tr>
        <td> ${email.languages}</td>
        <td> ${email.pageSize}</td>
        <td> ${email.spamsFilter}</td>
        <td> ${email.signature}</td>
    </tr>
    </c:forEach>
    </tr>
</table>

</body>


</html>
