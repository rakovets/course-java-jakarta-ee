<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Form Elements Demo</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/form-elements" method="post">
        <input type="radio" name="radioChoice" value="first"> Первый выбор
        <input type="radio" name="radioChoice" value="second"> Второй выбор
        <select name="dropdownChoice">
            <c:forEach var="artist" items="${requestScope.artists}">
                <option value="${artist.id}">${artist.name}</option>
            </c:forEach>
            <%--<option value="1">Один</option>--%>
            <%--<option value="2">Два</option>--%>
            <%--<option value="3">Три</option>--%>
        </select>
        <button type="submit">Отправить</button>
    </form>
</body>
</html>
