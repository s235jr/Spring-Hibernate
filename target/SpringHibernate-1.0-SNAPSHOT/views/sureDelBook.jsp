<%--
  Created by IntelliJ IDEA.
  User: tomasz
  Date: 24.07.18
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Are you sure?</title>
</head>
<body>

<form method="post" action="/sureDelBook">
    <label>Are you sure to del book?</label>
    <input type="hidden" name="id" value="${id}">
    <input type="submit" value="Delete Book">
</form>
<form method="get" action="/books">
    <input type="submit" value="Back to book list">
</form>

</body>
</html>
