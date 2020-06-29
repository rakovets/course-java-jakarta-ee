<%@ page import="java.util.List" %>
<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/24/2020
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read Info About Heroes Abilities</title>
</head>
<body>
<%@include file="/WEB-INF/jsp/common/header.jsp" %>
<main>
    <nav class="navbar">
        <div class="col-4"></div>
        <div class="col-4">
            <h4 class="p-3">Abilities</h4>
            <c:forEach items="${sessionScope.abilitiesList}" var="ability">
                <table border="1" class="border border-primary">
                    <tr>
                        <td class="pl-3">${ability.name}</td>
                    </tr>
                </table>
            </c:forEach>
        </div>
        <div class="col-4"></div>
    </nav>
</main>

</body>
</html>
