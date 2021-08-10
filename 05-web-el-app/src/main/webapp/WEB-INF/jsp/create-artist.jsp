<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fill in artist data</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/saveArtist" method="post">
        <label for="artistName">Имя исполнителя</label>
        <input type="text" name="artistName" id="artistName"><br>
        <button type="submit">Сохранить данные</button>
    </form>
</body>
</html>
