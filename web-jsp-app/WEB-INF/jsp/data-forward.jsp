<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>First Name: <%= request.getParameter("firstName") %></p>
    <p>Last Name: <%= request.getParameter("lastName") %></p>
    <p>Role: <%= request.getAttribute("role") %></p>
</body>
</html>
