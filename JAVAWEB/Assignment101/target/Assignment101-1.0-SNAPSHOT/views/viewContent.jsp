<%--
  Created by IntelliJ IDEA.
  User: raymundoortizjr
  Date: 16/10/2022
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/styleeditprofile.css">
</head>
<body>
<div class="">
    <ul class="nav nav-pills bg-dark nav-cms">
        <li class="nav-item">
            <a class="nav-link" href="#">CMS</a>
        </li>
        <div class="btn-group dropdown">
            <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                ${userLogin} <i class="bi bi-person-circle"></i>
            </button>
            <div class="dropdown-menu dropdown-menu-right">
                <button class="dropdown-item edit-profile-btn" type="button"><a href="/userProfile"><i class="bi bi-pencil-square "></i> &nbsp;  User Profile</a></button>
                <button class="dropdown-item" type="button"><i class="bi bi-box-arrow-in-left"></i><a href="/logout"> &nbsp;  Log out</a></button>
            </div>
        </div>
    </ul>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-3" id="nav-left">
            <form action="/search" method="get" class="form-inline my-2 my-lg-0 search-form">
                <input class="form-control mr-sm-2" type="search" name="search" placeholder="Search" aria-label="Search">
                <button type="submit" class="btn btn-outline-success my-2 my-sm-0"><i class="bi bi-search"></i></button>
            </form>
            <ul class="list-group">
                <li class="list-group-item view-content-option"><i class="bi bi-view-stacked"></i> <a href="/viewContent">View content</a></li>
                <li class="list-group-item form-content-option"><a href="/formContent"><i class="bi bi-pencil-square"></i> Form content</a></li>
            </ul>
        </div>
        <!--        Form profile-->
        <div class="col-lg-9">
            <i class="text-danger">${message}</i>
            <div class="content-profile view-content">
                <h4 class="header-form" style="padding-bottom: 15px">View Content</h4>
                <hr>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Title</th>
                        <th scope="col">Brief</th>
                        <th scope="col">Created Date</th>
                        <th scope="col" colspan="2">Option</th>
                    </tr>
                    </thead>
                    <tbody id="body">
                    <c:forEach items="${listContent}" var="content">
                    <tr>
                        <td><c:out value="${content.getId()}"/></td>
                        <td><c:out value="${content.getTitle()}"/></td>
                        <td><c:out value="${content.getBrief()}"/></td>
                        <td><c:out value="${content.getCreateDate()}"/></td>
                        <td><a href="/update?action=${content.getId()}"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                            <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                            <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
                        </svg></a></td>
                        <td><a href="/delete?action=${content.getId()}"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                            <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                            <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                        </svg></a></td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
