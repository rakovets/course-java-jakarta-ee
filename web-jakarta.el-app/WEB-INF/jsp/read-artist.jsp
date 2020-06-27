<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Read-artist</title>
</head>
<body>
    <p>
        ${sessionScope.listArtistsSession.get(0).toString()}
    </p>
    <form action="${pageContext.request.contextPath}/index.jsp">
        <input type="submit" value="Continue">
    </form>
</body>
</html>
