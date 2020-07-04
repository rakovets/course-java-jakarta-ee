<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Start page</title>
    <%@include file="/WEB-INF/jsp/common/css-connect.jsp"  %>
</head>
<body>
<header>
    <nav class="navbar">
        <div class="col-2">
            <img class="rounded" src="static/hero.jpg" width="150" height="150" alt="hero.jpg">
        </div>
        <div class="col-2 text-right ml-3">
            <h2>Abilities</h2>
        </div>
        <div class="col-2 text-center">
            <h2>Heroes</h2>
        </div>
        <div class="col-3 text-left pl-5">
            <h2>Create Heroes</h2>
        </div>
        <div class="col-2"></div>
    </nav>
</header>
    <%@include file="/WEB-INF/jsp/common/main.jsp"  %>
    <%@include file="/WEB-INF/jsp/common/footer.jsp"  %>
</body>
</html>
