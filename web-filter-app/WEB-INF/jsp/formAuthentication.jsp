<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Authentication</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/authentication">
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
