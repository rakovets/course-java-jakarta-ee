<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25.06.2020
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read artists</title>
</head>
<body>
    <table border="2px" cellpadding="5px">
        <tr>
            <th>ID</th>
            <th>Name of artist</th>
        </tr>
        <tr>
            <td><a href="${pageContext.request.contextPath}/artist/1">1</a></td>
            <td>Nick Cave</td>
        </tr>
    </table>
</body>
</html>
