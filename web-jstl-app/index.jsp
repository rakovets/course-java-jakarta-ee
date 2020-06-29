<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/24/2020
  Time: 8:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Super-Hero Page!!!</title>
    <link href="static/bootstrap.min.css" rel="stylesheet">
    <script src="static/bootstrap.min.js"></script>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <img src="static/Superhero.jpg" width="90" height="90">
    <a class="navbar-brand" href="AbilitiesServlet">Abilities</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/WEB-INF/jsp/read-hero.jsp">Heroes<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/WEB-INF/jsp/create-hero.jsp">Create Hero</a>
            </li>
        </ul>
    </div>
</nav>

<link href="../web-jstl-app/static/bootstrap.min.css" rel="stylesheet">
<script src="../web-jstl-app/static/bootstrap.min.js"></script>

</body>
</html>
