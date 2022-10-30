<%--
  Created by IntelliJ IDEA.
  User: raymundoortizjr
  Date: 20/10/2022
  Time: 00:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h1>Customer Manager</h1>
    <form method="get" action="/user/search">
        <input type="text" name="keyword" />
        <input type="submit" value="Search" />
    </form>
    <h3><a href="/user/new">New Customer</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>Id</th>
            <th>userName</th>
            <th>Password</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>

                <td>${user.id}</td>
                <td>${user.userName}</td>
                <td>${user.password}</td>
                <td>
                    <a href="/user/edit?id=${user.id}">Edit</a>
                    <a href="delete">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
