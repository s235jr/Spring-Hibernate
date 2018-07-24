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
        <td colspan="3">Author</td>
        <td colspan="2">Option</td>
    </tr>
    <tr>
        <td>Id</td>
        <td>First name</td>
        <td>Last name</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.id}</td>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td><a href="/editauthor${author.id}">Edit</a></td>
            <td><a href="/delauthor${author.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<div>
<a href="/addauthor"><button>Add Author</button></a>
</div>
</body>
</html>