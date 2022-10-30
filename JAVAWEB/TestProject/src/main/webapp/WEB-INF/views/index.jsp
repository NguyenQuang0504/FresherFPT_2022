<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Manager</title>
</head>
<body>
	<div align="center">
		<h1>Customer Manager</h1>
		<form method="get" action="search">
			<input type="text" name="keyword" />
			<input type="submit" value="Search" />
		</form>
		<h3><a href="new">New Customer</a></h3>
		<table border="1" cellpadding="5">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Address</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${listCustomer}" var="customer">
			<tr>
			
				<td>${customer.id}</td>
				<td>${customer.name}</td>
				<td>${customer.email}</td>
				<td>${customer.address}</td>
				<td>
					<a href="edit?id=${customer.id}">Edit</a>				
					<a href="delete?id=${customer.id}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	
	
</body>
</html>