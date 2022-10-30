<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>
	<h2>HTML Table</h2>

	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Age</th>
			<th>Update</th>
		</tr>
		<c:forEach items="${sinhVienList }" var="sinhvien">
			<tr>
				<td>${sinhvien.id }</td>
				<td>${sinhvien.name }</td>
				<td>${sinhvien.age }</td>
				<td>
					<c:url value="/showsinhvienupdate" var="showupdatesinhvien">
						<c:param name="sinhvienId" value="${sinhvien.id }"></c:param>
					</c:url>
					<a href="${showupdatesinhvien}" target="blank">Detail</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>