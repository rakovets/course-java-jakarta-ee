<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Servlet</title>
    <link rel="stylesheet" href="static/bootstrap.min.css">
</head>

<body>

<h3>Task 01. Query parameters: name, surname</h3>
<br>
<form action="task01" method="post">
    <label for="nameTask01-field">Name</label>
    <input type="text" name="nameTask01" id="nameTask01-field">
    <br><br>
    <label for="surname-field">Surname</label>
    <input type="text" name="surname" id="surname-field">
    <input type="submit" value="Submit">
</form>
<br><br>

<h3>Task 02. Query parameters: name, phone, mail</h3>
<br>
<form action="task02" method="post">
    <label for="nameTask02-field">Name</label>
    <input type="text" name="nameTask02" id="nameTask02-field" required>
    <br><br>
    <label for="phone-field">Phone</label>
    <input type="text" name="phone" id="phone-field" required>
    <br><br>
    <label for="mail-field">Mail</label>
    <input type="email" name="mail" id="mail-field" required>
    <input type="submit" value="Submit">
</form>
<br><br>

<h3>Task 03. Browser info</h3>
<form action="task03" method="post">
    <input type="submit" value="Info">
</form>
<br><br>

<h3>Task 04. Get information about entity by ID from database</h3>
<br>
<form action="DatabaseAccess" method="post">
    <label for="entityID-field">Enter ID restaurant</label>
    <input type="text" name="entityID" id="entityID-field" required>
    <input type="submit" value="Submit">
</form>

</body>

</html>
