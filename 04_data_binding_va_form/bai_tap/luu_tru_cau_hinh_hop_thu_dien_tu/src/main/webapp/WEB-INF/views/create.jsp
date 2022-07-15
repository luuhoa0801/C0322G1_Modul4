<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h2> Settings</h2>

<form:form method="post" action="addEmail" modelAttribute="email">
    <table>
        <tr>
            <td> Languages:</td>
            <td>
                <form:select path="languages">
                    <form:options items="${listLanguages}"></form:options>
                </form:select>
            </td>
        </tr>
        <tr>
            <td> Page Size:</td>
            <td>
                <form:select path="pageSize">
                    <form:options items="${listSize}"></form:options>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Spams filter</td>
            <td>
                <form:checkbox path="spamsFilter"></form:checkbox>
            </td>
        </tr>
        <tr>
            <td> Signature</td>
            <td>
                <form:textarea path="signature"></form:textarea>
            </td>
        </tr>
        <tr>
            <td>
                <button value="submit">Update</button>
            </td>
            <td>
                <button><a href="email">Cancel</a></button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
