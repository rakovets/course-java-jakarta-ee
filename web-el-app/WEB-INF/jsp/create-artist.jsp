<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 22.06.2020
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create artist</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/artist" method="post">
        Name of artist: <input type="text" name="name"> <br>
        Russian artist: <input type="radio" name="russian" value="yes">Yes
        <input type="radio" name="russian", value="no">No <br><br>
        <input type="submit" value="Send">
    </form>
</body>
</html>
