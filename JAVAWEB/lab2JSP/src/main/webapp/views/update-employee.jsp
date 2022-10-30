<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<form action="/update" method="post" name="frm-addEmp">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <h2>Update a Employee</h2>
            <input type="hidden" name="employeeId" value="${employee.employeeId}">
            <div class="form-group">
                <label for="employeeName">Name:</label> <input type="text" class="form-control" id="employeeName"
                                                               placeholder="Enter name" name="employeeName" value="${employee.employeeName}">
            </div>

            <label>Gender:</label>
            <div class="form-check-inline">
                <label class="form-check-label"> <input type="radio" class="form-check-input" name="gender" value="1"
                                                        checked>Male
                </label>
            </div>
            <div class="form-check-inline">
                <label class="form-check-label"> <input type="radio" class="form-check-input" name="gender" value="0"
                ${employee.gender==0 ? 'checked' : '' }>Female
                </label>
            </div>

            <div class="form-group">
                <label for="dateOfBirth">Date of birth:</label> <input type="date" class="form-control" id="dateOfBirth"
                                                                       placeholder="Enter date of birth" name="dateOfBirth"
                                                                       value="<fmt:formatDate value='${employee.dateOfBirth}' pattern='yyyy-MM-dd' />">
            </div>
            <div class="form-group">
                <label for="dept">Department:</label>
                <select name="deptId" class="form-control" id="dept">
                    <c:forEach items="${departments}" var="department">
                        <option value="${department.departmentId}" ${department.departmentId==employee.departmentId
                                ? 'selected' : '' }>${department.departmentName}</option>
                    </c:forEach>

                </select>
            </div>
        </div>

    </div>

    <div class="row">
        <div class="col-md-6 offset-md-3">
            <button type="submit" id="btn-addEmp" class="btn btn-primary">Update
                Employee</button>
        </div>
    </div>
</form>

<script type="text/javascript" src="<%=request.getContextPath()%>/resource"></script>
</body>