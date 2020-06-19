<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <meta charset="utf-8">
    <title>Task 02</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <h3>Task 02. Query parameters: name, phone, mail</h3>
    <br>
    <form action="task02" method="post">
        <label for="nameTask02-field">Name</label>
        <input <%
                    if(request.getParameter("nameTask02").length() == 0) {
                        out.print("style=\"border-color: red\"");
                    }
                %>
                type="text" name="nameTask02" id="nameTask02-field" value=${param.nameTask02}>
        <span style="color: red">
            <%
                if(request.getParameter("nameTask02").length() == 0) {
                    out.print("Enter name");
                }
            %>
        </span>
        <br><br>
        <label for="phone-field">Phone</label>
        <input <%
                    if(request.getParameter("phone").length() == 0) {
                        out.print("style=\"border-color: red\"");
                    }
                %>
                type="text" name="phone" id="phone-field" value=${param.phone}>
        <span style="color: red">
            <%
                if(request.getParameter("phone").length() == 0) {
                    out.print("Enter phone");
                }
            %>
        </span>
        <br><br>
        <label for="mail-field">Mail</label>
        <input <%
                    if(request.getParameter("mail").length() == 0) {
                        out.print("style=\"border-color: red\"");
                    }
                %>
                type="text" name="mail" id="mail-field" value=${param.mail}>
        <span style="color: red">
            <%
                if(request.getParameter("mail").length() == 0) {
                    out.print("Enter mail");
                }
            %>
        </span>
        <input type="submit" value="Submit">
    </form>
    <br><hr align-items="center"><br>
</body>

</html>
