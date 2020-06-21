<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Artist info</title>
</head>
<body>
<p>Id исполнителя: ${requestScope.artist.id}</p>
<p>Имя исполнителя: ${requestScope.artist.name}</p>
<p>Русская музыка: ${requestScope.artist.russian}</p>
</body>
</html>
