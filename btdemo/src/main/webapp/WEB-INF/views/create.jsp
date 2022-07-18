<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h2> Settings</h2>

<form:form method="post" action="addMedical" modelAttribute="medical">
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
                <button value="submit">Them</button>
            </td>
            <td>
                <button><a href="email">Cancel</a></button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
