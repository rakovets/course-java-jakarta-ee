<%@ page contentType="text/html;charset=UTF-8" %>
<header>
    <nav class="navbar">
        <div class="col">
            <img class="rounded" src="static/hero.jpg" width="150" height="150" alt="hero.jpg">
        </div>
        <div class="col text-right ml-3">
            <a href="abilitiesServlet">
                <h2>Abilities</h2>
            </a>
        </div>
        <div class="col text-center">
            <a href="heroesServlet">
                <h2>Heroes</h2>
            </a>
        </div>
        <div class="col text-left pl-5">
            <a href="heroFormsCreateServlet">
                <h2>Create Heroes</h2>
            </a>
        </div>
        <div class="col">
            <form action="${pageContext.request.contextPath}/signOut">
                <p style="font-size: 20px; text-align: center">
                    <input type="submit" value="Sign out">
                </p>
            </form>
        </div>
    </nav>
</header>
