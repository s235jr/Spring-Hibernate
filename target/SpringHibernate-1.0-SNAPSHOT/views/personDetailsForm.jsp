<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: tomasz
  Date: 24.07.18
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person Details</title>
</head>
<body>

<form:form method="post" modelAttribute="personDTO">
    <label>Login</label>
    <div><form:input path="login" title="Login"/></div>
    <label>Email</label>
    <div><form:input path="email" title="Email"/></div>
    <label>First Name</label>
    <div><form:input path="firstName" title="First Name"/></div>
    <label>Last Name</label>
    <div><form:input path="lastName" title="Last Name"/></div>
    <label>Gender</label>
    <div><form:radiobuttons items="${genders}" path="gender"/></div>
    <label>Country</label>
    <div><form:select items="${countries}" path="country"/></div>
    <label>Note</label>
    <div><form:textarea path="notes"/></div>
    <label>Send Me email</label>
    <div><form:checkbox path="mailingList" title="Send Me email" value="false" /></div>
    <label>Skills</label>
    <div><form:select items="${programmingSkills}" path="programmingSkills" multiple="true"/></div>
    <label>Hobby</label>
    <div><form:checkboxes items="${hobbies}" path="hobby"/></div>
    <div><input type="submit" value="Save"></div>
</form:form>

</body>
</html>
