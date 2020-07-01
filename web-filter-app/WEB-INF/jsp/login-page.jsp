<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/1/2020
  Time: 9:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="/static/bootstrap.min.css">
</head>
<body>
<form action="${pageContext.request.contextPath}/user" method="post">
    <label for="name-field">Enter name</label>
    <input type="text" name="name" id="name-field">
    <br><br>
    <label for="name-field">Enter Surname</label>
    <input type="text" name="surname" id="surname-field">
    <br><br>
    <label for="name-field">Enter Pasword</label>
    <input type="text" name="pasword" id="pasword-field">
    <br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
