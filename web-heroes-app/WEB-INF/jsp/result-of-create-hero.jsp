<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 07.07.2020
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result ofsving Hero</title>
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
                            <a href="abilities">
                                Abilities
                            </a>
                        </li>
                        <li class="menu__item">
                            <a href="heroes">
                                Heroes
                            </a>
                        </li>
                        <li class="menu__item">
                            <a href="create-hero">
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
                <div class="main__info">
                    <p>
                        Псевдоним: <c:out value="${savedHero.name}"></c:out>
                    </p>
                    <p>
                        Реальное имя: <c:out value="${savedHero.identity}"></c:out>
                    </p>
                    <p>
                        Пол: <c:out value="${savedHero.gender}"></c:out>
                    </p>
                    <p>
                        Возраст: <c:out value="${savedHero.age}"></c:out>
                    </p>
                    <p>
                        Способность: <c:out value="${savedHero.abilityId}"></c:out>
                    </p>
                </div>
            </div>
        </div>
    </div>
</main>
</body>
</html>
