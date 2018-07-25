<%--
  Created by IntelliJ IDEA.
  User: tomasz
  Date: 24.07.18
  Time: 09:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
<h1>Add student</h1>

<form:form method="post" modelAttribute="student">
    <form:input path="firstName"/>
    <form:input path="lastName" />
    <input type="submit" value="Save">
</form:form>

</body>
</html>
