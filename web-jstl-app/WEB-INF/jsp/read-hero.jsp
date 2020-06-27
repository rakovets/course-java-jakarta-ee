<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="/WEB-INF/jsp/common/jstl-connect.jsp"  %>
<html>
<head>
    <title>Read Hero</title>
    <%@include file="/WEB-INF/jsp/common/css-connect.jsp"  %>
</head>
<body>
<%@include file="/WEB-INF/jsp/common/header.jsp"  %>
<main>
    <nav class="navbar">
        <div class="col-3"></div>
        <div class="col-6">
            <h4 class="p-3">Information about: ${sessionScope.optionalHero.name}</h4>
            <table border="1" class="border border-primary">
                <tr>
                    <td class="pl-3 font-weight-bold">Identity</td>
                    <td class="pl-3">${sessionScope.optionalHero.identity}</td>
                </tr>
                <tr>
                    <td class="pl-3 font-weight-bold">Ability</td>
                    <td class="pl-3">${sessionScope.optionalHero.abilityName}</td>
                </tr>
                <tr>
                    <td class="pl-3 font-weight-bold">Age</td>
                    <td class="pl-3">${sessionScope.optionalHero.age}</td>
                </tr>
                <tr>
                    <td class="pl-3 font-weight-bold">Gender</td>
                    <td class="pl-3">${sessionScope.optionalHero.gender.toLowerCase()}</td>
                </tr>
            </table>
        </div>
        <div class="col-3"></div>
    </nav>
</main>
<%@include file="/WEB-INF/jsp/common/footer.jsp" %>
</body>
</html>
