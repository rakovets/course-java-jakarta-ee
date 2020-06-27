<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="/WEB-INF/jsp/common/jstl-connect.jsp"  %>
<html>
<head>
    <title>Abilities</title>
    <%@include file="/WEB-INF/jsp/common/css-connect.jsp"  %>
</head>
<body>
<%@include file="/WEB-INF/jsp/common/header.jsp"  %>
<main>
    <nav class="navbar">
    <div class="col-4"></div>
    <div class="col-4">
        <h3 class="pl-3">Abilities</h3>
        <c:forEach items="${sessionScope.abilitiesList}" var="ability">
            <table border="2"  >
                <tr>
                    <td class="pl-3">${ability.name}</td>
                </tr>
            </table>
        </c:forEach>
    </div>
    <div class="col-4"></div>
    </nav>
</main>
<%@include file="/WEB-INF/jsp/common/footer.jsp"  %>
</body>
</html>
