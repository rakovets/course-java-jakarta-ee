<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/17/2020
  Time: 7:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>web jsp</title>
</head>
<body>

<h3><a href="hello.jsp">Task01</a></h3><br>

<h3><a href="HelloServlet">Task02</a></h3><br>

<h3><a href="main.jsp">Task03</a></h3><br>

<h3><a href="main.jsp">Task04</a></h3><br>

<h3><a href="main.jsp">Task05</a></h3><br>

<p > Task 06:</p>
<form action="dataForwardServlet">
    <label for="firstName-field">FirstName</label>
    <input type="text" name="firstName" id="firstName-field">
    <br><br>
    <label for="lastName-field">LastName</label>
    <input type="text" name="lastName" id="lastName-field">
    <input type="submit" value="Submit">
</form>

</body>
</html>
