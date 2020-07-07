<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 04.07.2020
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/main.css">
</head>
<body>
<header>
    <div class="container">
        <div class="row">

            <div class="col-lg-2">
                <img src="static/img/superhero.jpeg" alt="logo" class="logo rounded">
            </div>

            <div class="col-lg-8 ml-auto">
                <nav>
                    <ul class="menu d-flex justify-content-center">
                        <li class="menu__item">
                            <a href="#">
                                Abilities
                            </a>
                        </li>
                        <li class="menu__item">
                            <a href="">
                                Heroes
                            </a>
                        </li>
                        <li class="menu__item">
                            <a href="">
                                Create Hero
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>

        </div>
    </div>
</header>
<main>
    <div class="container">
        <div class="row">
            <div class="col-lg-4">
                <ul class="ul__hero">
                    <c:forEach var="ability" items="${abilities}">
                        <li><c:out value="${ability.name}"></c:out></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</main>
</body>
</html>
