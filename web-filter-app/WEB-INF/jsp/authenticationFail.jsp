<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/5/2020
  Time: 11:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authentication</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/authentication">
    <h3 style="color: red">Wrong name or password!</h3>
    <p>
        <b>Логин:</b>
        <input maxlength="25" size="40" name="login" required>
    </p>
    <p>
        <b>Пароль:</b>
        <input type="password" maxlength="25" size="40" name="password" required>
    </p>
    <p>
        <input type="submit" value="Enter">
    </p>
</form>
</body>
</html>
