<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Result authentication</title>
</head>
<body>
    <h1 style="color: green">Authentication and authorization - success!</h1>
    <form action="${pageContext.request.contextPath}/index.jsp">
        <input type="submit" value="Continue">
    </form>
</body>
</html>
