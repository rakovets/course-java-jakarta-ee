<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="/WEB-INF/jsp/common/jstl-connect.jsp"  %>
<html>
<head>
    <title>Create Hero success</title>
    <%@include file="/WEB-INF/jsp/common/css-connect.jsp"  %>
</head>
<body>
<header>
    <nav class="navbar">
        <div class="col">
            <img class="rounded" src="static/hero.jpg" width="150" height="150" alt="hero.jpg">
        </div>
        <div class="col-1">
            <form action="${pageContext.request.contextPath}/localeChange">
                <p><input type="submit" name="locale" value="English"></p>
                <p><input type="submit" name="locale" value="France"></p>
                <p><input type="submit" name="locale" value="Germany"></p>
                <input type="submit" name="locale" value="Russian">
                <input type="hidden" name="referrer" value="/WEB-INF/jsp/create-hero-success.jsp">
            </form>
        </div>
        <%@include file="/WEB-INF/jsp/common/header.jsp"  %>
</header>
<main>
    <h3 class="pt-5 text-center">
        Created hero ${requestScope.heroName} - success!
    </h3>
</main>
<%@include file="/WEB-INF/jsp/common/footer.jsp" %>
</body>
</html>
