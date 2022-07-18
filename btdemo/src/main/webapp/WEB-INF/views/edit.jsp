<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    <a href="/medical"></a>
</p>
<form:form method="post" action="/update" modelAttribute="medical">
    <table>
        <tr>
            <td> ID:</td>
            <td>
                <form:input path="id"></form:input>
            </td>
        </tr>
        <tr>
            <td> Name:</td>
            <td>
                <form:input path="name"></form:input>
            </td>
        </tr>
        <tr>
            <td> Age:</td>
            <td>
                <form:select path="age">
                    <form:options items="${listYear}"></form:options>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Travel</td>
            <td>
                <form:radiobutton path="travel" value="tau bay" label="tau bay"/>
                <form:radiobutton path="travel" value="tau thuyen" label="tau thuyen"/>
                <form:radiobutton path="travel" value="o to" label="o to"/>
                <form:radiobutton path="travel" value="khac" label="khac"/>
            </td>
        </tr>
        <tr>
            <td> StartDay:</td>
            <td>
                <form:select path="startDay">
                    <form:options items="${listStartDay}"></form:options>
                </form:select>
            </td>
        </tr>
        <tr>
            <td> EndDay:</td>
            <td>
                <form:select path="endDay">
                    <form:options items="${listEndDay}"></form:options>
                </form:select>
            </td>
        </tr>
        <tr>
            <td> status:</td>
            <td>
                <form:input path="status"></form:input>
            </td>
        </tr>

        <tr>
            <td>
                <button value="submit">update</button>
            </td>
            <td>
                <button><a href="email">Cancel</a></button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
