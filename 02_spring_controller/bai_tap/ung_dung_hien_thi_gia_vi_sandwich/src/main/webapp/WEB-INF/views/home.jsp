<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<h1> Sandwich Condiments</h1>
<form action="/update" method="post">
    <div>
        <input type="checkbox" name="check" value="Lettuce"> Lettuce
        <input type="checkbox" name="check" value="Tomato"> Tomato
        <input type="checkbox" name="check" value="Mustard"> Mustard
        <input type="checkbox" name="check" value="Sprouts"> Sprouts
    </div>
    <button type="submit"> Save</button>
</form>
</body>
</html>
