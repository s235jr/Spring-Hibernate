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
    <title>Author Form</title>
</head>
<body>

<form:form method="post" modelAttribute="author">
    <div>First name<form:input path="firstName"/></div>
    <div>Last name<form:input path="lastName"/></div>
    <input type="submit" value="Save">
</form:form>

</body>
</html>
