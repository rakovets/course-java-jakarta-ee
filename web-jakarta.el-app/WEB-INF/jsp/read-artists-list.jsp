<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Read artist list</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style.css">
</head>
<body>
  <table border="1">
      <p>
        <h3>Список всех исполнителей</h3>
      </p>
      <tr>
          <th>Id</th>
          <th>Имя исполнителя</th>
          <th>Русская музыка</th>
      </tr>
      <tr>
          <td>
              <a href="${pageContext.request.contextPath}/artist/id?artistId=1">
                  ${sessionScope.listArtistsSession[0].id}</a>
          </td>
          <td>${sessionScope.listArtistsSession[0].name}</td>
          <td>${sessionScope.listArtistsSession[0].russian}</td>
      </tr>
      <tr>
          <td>
              <a href="${pageContext.request.contextPath}/artist/id?artistId=2">
                  ${sessionScope.listArtistsSession[1].id}</a>
          </td>
          <td>${sessionScope.listArtistsSession[1].name}</td>
          <td>${sessionScope.listArtistsSession[1].russian}</td>
      </tr>
      <tr>
          <td>
              <a href="${pageContext.request.contextPath}/artist/id?artistId=3">
                  ${sessionScope.listArtistsSession[2].id}</a>
          </td>
          <td>${sessionScope.listArtistsSession[2].name}</td>
          <td>${sessionScope.listArtistsSession[2].russian}</td>
      </tr>
  </table><br>
    <form action="${pageContext.request.contextPath}/index.jsp">
        <input type="submit" value="Continue">
    </form>
</body>
</html>
