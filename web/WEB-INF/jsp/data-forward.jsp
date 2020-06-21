<%@ page import="main.java.com.rakovets.course_java_enterprise.solution.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/17/2020
  Time: 9:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Data forward JSP</title>
    <link rel="stylesheet" href="../../styleForUser.css">
</head>
<body>
<% User user = (User) request.getAttribute("role"); %>
<h1>Task 06</h1><br>
<p>User</p>
<p>FirstName: <%= user.getFirstName() %></p>
<p>LastName: <%= user.getLastName() %></p>
</body>
</html>
