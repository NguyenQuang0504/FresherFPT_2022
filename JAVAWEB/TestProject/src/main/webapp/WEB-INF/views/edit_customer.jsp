<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Customer</title>
</head>
<body>
	<div align="center">
		<h2>Edit Customer</h2>
		<form:form action="/save" method="post" modelAttribute="customer">
			<table border="0" cellpadding="5">
				<tr>
					<td>Id: </td>
					<td>
						${customer.id}
						<form:hidden path="id"/>
					</td>
				</tr>
				<tr>
					<td>Name: </td>
					<td><form:input path="name"/></td>
				</tr>
				<tr>
					<td>Email: </td>
					<td><form:input path="email"/></td>
				</tr>
				<tr>
					<td>Address: </td>
					<td><form:input path="address"/></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Save" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>