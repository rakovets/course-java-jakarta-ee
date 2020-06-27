<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Read artist id 3</title>
</head>
<body>
<h3>Страница исполнителя: ${sessionScope.listArtistsSession[2].name}</h3>
<p>
    ${sessionScope.listArtistsSession.get(2).toString()}
</p>
<form action="${pageContext.request.contextPath}/index.jsp">
    <input type="submit" value="Continue">
</form>
</body>
</html>
