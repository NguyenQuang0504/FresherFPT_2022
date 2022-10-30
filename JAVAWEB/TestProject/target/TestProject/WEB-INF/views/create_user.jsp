<%--
  Created by IntelliJ IDEA.
  User: raymundoortizjr
  Date: 20/10/2022
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form:form action="/user/save" method="post" modelAttribute="user">
        UserName:
        <form:input path="userName"/>
        Password:
        <form:input path="password"/>
        <input type="submit" value="Submit">
    </form:form>
</div>
</body>
</html>
