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
    <title>Author List</title>
</head>
<body>

<a href="/books">
    <button>Books</button>
</a>
<a href="/publishers">
    <button>Publishers</button>
</a>
<a href="/authors">
    <button>Authors</button>
</a>

<table border="5px">
    <tr>
        <td colspan="2">Publisher</td>
        <td colspan="2">Option</td>
    </tr>
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items="${publishers}" var="publisher">
        <tr>
            <td>${publisher.id}</td>
            <td>${publisher.name}</td>
            <td><a href="/editpublisher${publisher.id}">Edit</a></td>
            <td><a href="/delpublisher${publisher.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<div>
<a href="/addpublisher"><button>Add Publisher</button></a>
</div>
</body>
</html>