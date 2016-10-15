<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: DethGhost
  Date: 15.10.2016
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form:form action="register" modelAttribute="user">
    <label for="name"><sp:message code="reg.name"/></label><br/>
    <form:input path="name" placeholder="Enter name"/>
    <form:errors path="name" cssClass="error"/><br/>
    <label for="login"><sp:message code="reg.login"/></label><br/>
    <form:input path="login" placeholder="Enter login"/>
    <form:errors path="login" cssClass="error"/><br />
    <label for="password"><sp:message code="reg.password"/></label><br/>
    <form:input path="password" placeholder="Enter password"/>
    <form:errors path="password" cssClass="error"/><br/>
    <button><sp:message code="reg.submit"/> </button>
</form:form>
</body>
</html>
