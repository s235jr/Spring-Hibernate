<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tomasz
  Date: 23.07.18
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PersonList</title>
</head>
<body>
<table border="5px">
    <tr>
        <td colspan="4">Person</td>
        <td colspan="3">Datails</td>
    </tr>
    <tr>
        <td>Id</td>
        <td>Login</td>
        <td>Email</td>
        <td>Password</td>
        <td>FirstName</td>
        <td>LastName</td>
        <td>City</td>
    </tr>
    <c:forEach items="${persons}" var="person">
        <tr>
            <td>${person.id}</td>
            <td>${person.login}</td>
            <td>${person.email}</td>
            <td>${person.password}</td>
            <td>${person.personDetails.firstName}</td>
            <td>${person.personDetails.lastName}</td>
            <td>${person.personDetails.city}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
