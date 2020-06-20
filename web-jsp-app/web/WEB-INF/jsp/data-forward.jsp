<%@ page import="main.java.com.rakovets.course_java_enterprise.solution.classes.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>data-forward</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <% User user = (User) request.getAttribute("role"); %>
    <h1>Task 06</h1><br>
    <p>User</p>
    <p>FirstName: <%= user.getFirstName() %></p>
    <p>LastName: <%= user.getLastName() %></p>
</body>
</html>
