<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/login">
    <div>
        <label for="username">Имя пользователя: </label>
        <input type="text" id="username" name="username">
    </div>
    <div>
        <label for="password">Пароль: </label>
        <input type="password" id="password" name="password">
    </div>
    <button type="submit">Войти</button>
</form>
</body>
</html>
