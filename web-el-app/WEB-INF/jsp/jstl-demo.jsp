<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${empty requestScope.bookName}">
    <p>Название не указано</p>
</c:if>
<c:if test="${not empty requestScope.bookName}">
    <p>${requestScope.bookName}</p>
</c:if>
<c:forEach var="artist" items="${requestScope.artists}">
    <p>
        <span>${artist.id}</span>
        <span><a href="${pageContext.request.contextPath}/artist-details?id=${artist.id}">${artist.name}</a></span>
        <span>${artist.classical}</span>
    </p>
</c:forEach>
</body>
</html>
