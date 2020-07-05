<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="/WEB-INF/jsp/common/jstl-connect.jsp" %>

<div class="col text-right ml-3">
    <h2>
        <a href="abilitiesServlet">
            <c:if test="${sessionScope.abilities == null}">
                <c:out value="Abilities"/>
            </c:if>
            <c:if test="${sessionScope.abilities != null}">
                <c:out value="${sessionScope.abilities}"/>
            </c:if>
        </a>
    </h2>
</div>
<div class="col text-center">
    <h2>
        <a href="heroesServlet">
            <c:if test="${sessionScope.heroes == null}">
                <c:out value="Heroes"/>
            </c:if>
            <c:if test="${sessionScope.heroes != null}">
                <c:out value="${sessionScope.heroes}"/>
            </c:if>
        </a>
    </h2>
</div>
<div class="col text-left pl-5">
    <h2>
        <a href="heroFormsCreateServlet">
            <c:if test="${sessionScope.create == null}">
                <c:out value="Create heroes"/>
            </c:if>
            <c:if test="${sessionScope.create != null}">
                <c:out value="${sessionScope.create}"/>
            </c:if>
        </a>
    </h2>
</div>
<div class="col">
    <form action="${pageContext.request.contextPath}/signOut">
        <p style="font-size: 20px; text-align: center; margin-left: -30px">
            <input type="submit" value="Sign out">
        </p>
    </form>
</div>
</nav>
