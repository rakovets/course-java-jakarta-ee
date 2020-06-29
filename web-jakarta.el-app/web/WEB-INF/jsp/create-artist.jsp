<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Create-artist</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/artist" method="post">
    <label for="name-field">Enter name artist</label>
    <input type="text" name="name" id="name-field">
    <br><br>
    Russian music:
    <input type="radio" name="option" value="true">Yes
    <input type="radio" name="option" value="false">No<br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>