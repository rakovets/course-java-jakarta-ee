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
<main>
    <div style="text-align: center; padding-top: 75px">
        <form action="${pageContext.request.contextPath}/authentication">
            <div class="row">
                <div class="col text-right">
                    <p>
                        <b style="font-size: 25px">Login:</b>
                    </p>
                </div>
                <div class="col text-left">
                    <p style="font-size: 15px">
                        <input maxlength="25" size="40" name="login" required>
                    </p>
                </div>
                <div class="col"></div>
            </div>

            <div class="row">
                <div class="col text-right">
                    <p>
                        <b style="font-size: 25px">Password:</b>
                    </p>
                </div>
                <div class="col text-left">
                    <p style="font-size: 15px">
                        <input type="password" maxlength="25" size="40" name="password" required>
                    </p>
                </div>
                <div class="col"></div>
            </div>

            <div class="row">
                <div class="col"></div>
                <div class="col">
                    <p style="font-size: 20px">
                        <input type="submit" value="Enter">
                    </p>
                </div>
                <div class="col"></div>
            </div>
        </form>
    </div>
</main>
    <%@include file="/WEB-INF/jsp/common/footer.jsp"  %>
</body>
</html>
