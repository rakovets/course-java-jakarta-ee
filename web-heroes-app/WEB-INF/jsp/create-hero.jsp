<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 07.07.2020
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Hero</title>
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
            <div class="col-lg-10 ml-auto">
                <form action="save-hero" class="form">
                    <p>Псевдоним:</p>
                    <input type="text" class="form__input" name="name"> <br>
                    <p>Реальное имя:</p>
                    <input type="text" class="form__input" name="identity"> <br>
                    <p>Возраст:</p>
                    <input type="text" class="form__input" name="age"> <br><br>
                    <input type="radio" name="gender" value="MALE" checked> Мужчина
                    <input type="radio" name="gender" value="FEMALE"> Женщина <br><br>
                    <select size="1" class="select" name="abilities">
                        <option value="1">Полёт</option>
                        <option value="2">Сверхсила</option>
                        <option value="3">Телепатия</option>
                        <option value="4">Телепатия</option>
                        <option value="5">Регенерация</option>
                        <option value="6">Управление стихией</option>
                        <option value="7">Сверхскорость</option>
                        <option value="8" selected="selected">Богатство</option>
                    </select> <br><br>
                    <input type="submit" class="form__btn" value="Сохранить">
                </form>
            </div>
        </div>
    </div>
</main>
</body>
</html>
