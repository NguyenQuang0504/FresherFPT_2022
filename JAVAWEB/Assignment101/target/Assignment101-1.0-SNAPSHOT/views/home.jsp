<%--
  Created by IntelliJ IDEA.
  User: raymundoortizjr
  Date: 16/10/2022
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <form class="form-inline my-2 my-lg-0 search-form">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0"><i class="bi bi-search"></i></button>
            </form>
            <ul class="list-group">
                <li class="list-group-item view-content-option"><i class="bi bi-view-stacked"></i> <a href="/viewContent">View content</a></li>
                <li class="list-group-item form-content-option"><a href="/formContent"><i class="bi bi-pencil-square"></i> Form content</a></li>
            </ul>
        </div>
        <!--        Form profile-->
        <div class="col-lg-9" id="profile">
        </div>
    </div>
</div>
</body>
</html>
