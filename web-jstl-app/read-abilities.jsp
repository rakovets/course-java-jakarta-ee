<%@ page import="java.util.List" %>
<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/24/2020
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read Info About Heroes Abilities</title>
</head>
<body>

<% Enumeration <String> eList = session.getAttributeNames();
    request.setAttribute("eList", eList);

%>

<%
 //   for (String u : eList.asIterator()) {
%>
<tr>
    <td><%=eList.toString()%></td>
</tr>
<%
  //  }
%>

<table>
    <c:forEach items="${abilities}" var="abilities">
        <tr>
            <td>AbilitiesServlet abilities: <c:out value="${abilities.toString}"/></td>
            <td><%=eList.toString()%></td>
            <td><%=  eList.asIterator()%></td>

        </tr>
    </c:forEach>
</table>>

</body>
</html>
