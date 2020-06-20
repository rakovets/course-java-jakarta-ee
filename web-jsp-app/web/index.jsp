<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index</title>
    <link rel="stylesheet" href="style.css">
  </head>
  <body>
    <h3>
      <a href="hello.jsp">Task 01. Go to the direct link "hello.jsp"</a><br><br>
      <a href="helloServlet">Task 02. Servlet 'HelloServlet' redirecting link "/WEB-INF/hello.jsp"</a><br><br>
      <a href="mainServlet">Task 03. Create header, main, footer</a><br><br>
      <a href="mainServlet">Task 04. Add header, footer to main</a><br><br>
      <a href="mainServlet">Task 05. Create "style.css"</a><br><br>
      <p > Task 06:</p>
        <form action="dataForwardServlet">
          <label for="firstName-field">FirstName</label>
          <input type="text" name="firstName" id="firstName-field">
          <br><br>
          <label for="lastName-field">LastName</label>
          <input type="text" name="lastName" id="lastName-field">
          <input type="submit" value="Submit">
        </form>
    </h3>
  </body>
</html>
