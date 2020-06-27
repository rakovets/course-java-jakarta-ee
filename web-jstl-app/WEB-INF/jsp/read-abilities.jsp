<%@ page import="java.util.List" %>
<%@ page import="com.rakovets.course_java_enterprise.solution.jstl.entity.Ability" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>Abilities</title>
    <%@include file="/WEB-INF/jsp/common/css-connect.jsp"  %>
<%--    <%@include file="/WEB-INF/jsp/common/jstl-connect.jsp"  %>--%>

</head>
<body>
<%@include file="/WEB-INF/jsp/common/header.jsp"  %>
<main>
    <div class="text-center pt-2">
        <h3>Abilities</h3>
        <%
            out.println(request.getAttribute("jop"));

            List<Ability> abilityList = (List<Ability>) request.getAttribute("abilities");
            for(Ability ability : abilityList) {
                out.println("<p>" + ability.getName() + "</p>");
                out.println(request.getAttribute("jop"));
            }
        %>
<%--        <ul>--%>
<%--            <jsp:useBean id="abilities" scope="request" type="java.util.List"/>--%>
<%--            <c:forEach var="ability" items="${abilities}">--%>
<%--                <li><c:out value="${ability}" /></li>--%>
<%--            </c:forEach>--%>
<%--        </ul>--%>
    </div>
</main>
<%@include file="/WEB-INF/jsp/common/footer.jsp"  %>
</body>
</html>
