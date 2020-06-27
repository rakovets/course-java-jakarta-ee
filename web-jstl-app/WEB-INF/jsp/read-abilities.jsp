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
            <h4 class="p-3">Abilities</h4>
            <c:forEach items="${sessionScope.abilitiesList}" var="ability">
                <table border="1" class="border border-primary">
                    <tr>
                        <td class="pl-3">${ability.name}</td>
                    </tr>
                </table>
            </c:forEach>
        </div>
        <div class="col-4"></div>
    </nav>
</main>
<%@include file="/WEB-INF/jsp/common/footer.jsp" %>
</body>
</html>
