<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/jstl-connect.jsp" %>
<html>
<head>
    <title>Hero</title>
    <%@include file="common/css-connect.jsp" %>
    <%@include file="common/js-connect.jsp" %>
</head>
<body>
<%@ include file="common/header.jsp" %>
<div class="container">
    <p><span>Псевдоним: </span><span>${requestScope.hero.name}</span></p>
    <p><span>Реальное имя: </span><span>${requestScope.hero.identity}</span></p>
    <p>
        <span>Пол: </span>
        <span>
            <c:if test="${requestScope.hero.gender eq 'MALE'}">Мужчина</c:if>
            <c:if test="${requestScope.hero.gender eq 'FEMALE'}">Женщина</c:if>
        </span>
    </p>
    <p><span>Возраст: </span><span>${requestScope.hero.age}</span><span> лет</span></p>
    <p><span>Способность: </span><span>${requestScope.hero.abilityName}</span></p>
</div>
</body>
</html>
