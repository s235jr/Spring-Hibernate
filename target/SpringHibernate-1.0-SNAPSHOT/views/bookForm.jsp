<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: tomasz
  Date: 24.07.18
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Form</title>
</head>
<body>

<form:form method="post" modelAttribute="book">
    <div>Title<form:input path="title"/></div>
    <div>ISBN<form:input path="isbn"/></div>

    <div>Authors<form:select itemLabel="lastName" itemValue="id" items="${authors}" path="authors"
                             multiple="true"/></div>
    <div>Publisher<form:select itemLabel="name" itemValue="id" path="publisher" items="${publisher}"/></div>
    <div>Rating<form:input path="rating"/></div>
    <input type="submit" value="Save">
</form:form>

</body>
</html>
