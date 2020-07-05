<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="/WEB-INF/jsp/common/jstl-connect.jsp"  %>
<html>
<head>
    <title>Create Hero</title>
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
                <input type="hidden" name="referrer" value="/WEB-INF/jsp/create-hero.jsp">
            </form>
        </div>
    <%@include file="/WEB-INF/jsp/common/header.jsp"  %>
</header>
<main>
    <form action="${pageContext.request.contextPath}/heroCreateServlet">
        <div class="row">
            <div class="col-auto ">
                <table class="font-weight-bold pl-3 ml-3">
                    <p>
                        <tr>
                            <td class="text-center">Псевдоним</td>
                            <td><input type="text" name="name" required></td>
                        </tr>
                    </p>
                    <p>
                        <tr>
                            <td class="text-center">Реальное имя</td>
                            <td><input type="text" name="identity" required></td>
                        </tr>
                    </p>
                    <p>
                        <tr>
                            <td class="text-center">Возраст</td>
                            <td><input type="number" min="1" name="age" required></td>
                        </tr>
                    </p>
                </table>
            </div>
            <div class="col font-weight-bold pt-3 pl-3 ml-3">
                <h6>Мужчина</h6><input type="radio" name="option" value="MALE" checked><br><br>
                <h6>Женщина</h6><input type="radio" name="option" value="FEMALE"><br><br><br><br>
            </div>
            <div class="col font-weight-bold pt-3">
                <select size = "8" name="ability">
                    <option selected="selected" value = "1">Полёт</option>
                    <option value = "2">Сверхсила</option>
                    <option value = "3">Телепатия</option>
                    <option value = "4">Невидимость</option>
                    <option value = "5">Регенерация</option>
                    <option value = "6">Управление стихией</option>
                    <option value = "7">Сверхскорость</option>
                    <option value = "8">Богатство</option>
                </select><br>
            </div>
                <div class="col"></div>
            </div>
        </div>
        <div class="row">
            <div class="col"></div>
                <div class="col-6">
                    <h6>
                        <input class="w-50 font-weight-bold" type="submit" value="Сохранить">
                    </h6>
                </div>
            <div class="col"></div>
         </div>
    </form>
</main>
<%@include file="/WEB-INF/jsp/common/footer.jsp" %>
</body>
</html>
