<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="/WEB-INF/jsp/common/jstl-connect.jsp"  %>
<html>
<head>
    <title>Create Hero success</title>
    <%@include file="/WEB-INF/jsp/common/css-connect.jsp"  %>
</head>
<body>
<%@include file="/WEB-INF/jsp/common/header.jsp"  %>
<main>
    <h3 class="pt-5 text-center">
        Created hero ${requestScope.heroName} - success!
    </h3>
</main>
<%@include file="/WEB-INF/jsp/common/footer.jsp" %>
</body>
</html>
