<%--
  Created by IntelliJ IDEA.
  User: tomasz
  Date: 24.07.18
  Time: 09:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book</title>
</head>
<body>

<table border="3px">
    <c:forEach items="${valid}" var="valid">
        <tr>
        <td><c:out value="${valid.propertyPath}"></c:out></td>
        <td><c:out value="${valid.message}"></c:out></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
