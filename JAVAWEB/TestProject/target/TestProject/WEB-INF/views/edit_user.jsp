<%--
  Created by IntelliJ IDEA.
  User: raymundoortizjr
  Date: 20/10/2022
  Time: 00:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <form:form action="/user/save" modelAttribute="user" method="post">
<%--            //user form:hidden --%>
            <form:hidden path="id"/>
            <lable>UserName</lable>
            <form:input path="userName" />
            <br>
            <lable>Password</lable>
            <form:input path="password"/>
            <input type="submit"> Update </input>
        </form:form>
    </div>
</body>
</html>
