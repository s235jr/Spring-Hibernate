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
    <title>Person</title>
</head>
<body>
<h1>Add Person</h1>

<form:form method="post" modelAttribute="person">
    <form:input path="login" title="Login"  />
    <form:input path="email" title="Email"/>
    <form:password path="password" title="Password" />
    <input type="submit" value="Save">
</form:form>

</body>
</html>
