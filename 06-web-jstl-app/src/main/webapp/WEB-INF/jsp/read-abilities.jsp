<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="common/jstl-connect.jsp" %>
<html>
<head>
    <title>Abilities</title>
    <%@ include file="common/css-connect.jsp" %>
    <%@ include file="common/js-connect.jsp" %>
</head>
<body>
<%@ include file="common/header.jsp" %>
<div class="container">
    <c:forEach items="${abilities}" var="ability">
        <p>${ability.name}</p>
    </c:forEach>
</div>
</body>
</html>
