<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" name="viewport"
		  content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<title>Home Page</title>
</head>
<body>
	<br />
	<h2>List of Employees</h2>
	<p><c:out value="${message}"/></p>
	<br />
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>ID</th>
				<th>Employee Name</th>
				<th>Gender</th>
				<th>Date of birth</th>
				<th>Department Name</th>
				<th>Option</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listOfEmployee}" var="employee">
				<tr>
					<td>${employee.employeeId}</td>
					<td>${employee.employeeName}</td>
					<td>${employee.gender == 1 ? 'Male' : 'Female'}</td>
					<td>${employee.dateOfBirth}</td>
					<c:forEach items="${listOfDepartment}" var="department">
						<c:if test="${employee.departmentId == department.departmentId}">
							<td>${department.departmentName}</td>
						</c:if>
					</c:forEach>
					<td><a href="/update?action=${employee.employeeId}">Update</a></td>
					<td><a href="/delete?action=${employee.employeeId}">Delete</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</body>