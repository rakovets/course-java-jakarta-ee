<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <meta charset="utf-8">
    <title>Home work</title>
    <link rel="stylesheet" href="style.css">
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
    <br><hr align-items="center"><br>

    <h3>Task 02. Query parameters: name, phone, mail</h3>
    <br>
    <form action="task02" method="post">
        <label for="nameTask02-field">Name</label>
        <input type="text" name="nameTask02" id="nameTask02-field">
        <br><br>
        <label for="phone-field">Phone</label>
        <input type="text" name="phone" id="phone-field">
        <br><br>
        <label for="mail-field">Mail</label>
        <input type="email" name="mail" id="mail-field">
        <input type="submit" value="Submit">
    </form>
    <br><hr align-items="center"><br>

    <h3>Task 03. Browser info</h3>
    <form action="task03" method="post">
        <input type="submit" value="Info">
    </form>
    <br><hr align-items="center"><br>

    <h3>Task 04. Save to session</h3>
    <br>
    <form action="task04" method="post">
        <label for="nameTask04-field">Name</label>
        <input type="text" name="nameTask04" id="nameTask04-field">
        <br><br>
        <label for="surnameTask04-field">Surname</label>
        <input type="text" name="surnameTask04" id="surnameTask04-field">
        <input type="submit" value="Save">
    </form>
    <br><hr align-items="center"><br>

    <h3>Task 05. Get from session full-name</h3>
    <form action="task05" method="get">
        <input type="submit" value="Get-session">
    </form>
    <br><hr align-items="center"><br>

    <h3>Task 06. Get information about entity by ID from database</h3>
    <br>
    <form action="task06" method="post">
        <label for="entityId-field">Enter ID restaurant</label>
        <input type="text" name="entityId" id="entityId-field" required>
        <input type="submit" value="Find-restaurant">
    </form>
    <br><hr align-items="center"><br>

    <h3>Task 07. Create new entity to database</h3>
    <br>
    <form action="task07" method="post">
        <label for="nameRestaurant-field">Enter name restaurant</label>
        <input type="text" name="nameRestaurant" id="nameRestaurant-field" required>
        <input type="submit" value="Create">
    </form>
    <br><hr align-items="center"><br>
</body>

</html>
