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
    <title>BookList</title>
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
        <td colspan="3">Book</td>
        <td colspan="2">Author</td>
        <td>Publisher</td>
        <td colspan="2">Option</td>
    </tr>
    <tr>
        <td>Id</td>
        <td>Title</td>
        <td>Isbn</td>
        <td>Name</td>
        <td>Surname</td>
        <td>Name</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.isbn}</td>
            <c:forEach items="${book.authors}" var="author" end="0">
                <td>${author.firstName}</td>
                <td>${author.lastName}</td>
            </c:forEach>
            <td>${book.publisher.name}</td>
            <td><a href="/editbook${book.id}">Edit</a></td>
            <td><a href="/delbook${book.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<div>
    <a href="/addbook">
        <button>Add Book</button>
    </a>
</div>
</body>
</html>