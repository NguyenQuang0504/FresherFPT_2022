<%--
  Created by IntelliJ IDEA.
  User: raymundoortizjr
  Date: 23/10/2022
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css"
          href="<%=request.getContextPath()%>/resources/css/home.css">
</head>
<body>
<div class="container-fluid">
    <div class="">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Venus Gaming</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/">Trang chủ <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/machine/list">Máy</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/service/list">Dịch vụ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/customer/list">Khách hàng</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
    </div>
    <div class="row nav-left">
        <div class="col-lg-3" style="background-color: #d7d5d5">
            <ul class="list-group list-group-flush">
                <li class="list-group-item"><a href="/useMachine/create">Đăng ký sử dụng máy</a></li>
                <li class="list-group-item"><a href="/useService/create">Đăng ký sử dụng dịch vụ</a></li>
                <li class="list-group-item"><a href="/">Trang chủ</a></li>
                <li class="list-group-item">Khác</li>
            </ul>
        </div>
        <div class="col-lg-9">
            <!--                content-->
            <div class="container">
                <div style="padding-top: 30px">
                    <h5 style="text-align: center">Chỉnh sửa dịch vụ</h5>
                    <i style="color: red"><c:out value="${message}"/></i>
                    <form:form method="post" action="/service/save" modelAttribute="service">
                        <div class="form-group">
                            <label>Mã dịch vụ</label>
                            <form:input type="text" id="maDV" class="form-control" path="maDV" placeholder="Nhập mã dịch vụ"/>
                            <i id="messageDV" style="color: red"></i>
                        </div>
                        <div class="form-group">
                            <label>Tên dịch vụ</label>
                            <form:input type="text" class="form-control" path="tenDV" placeholder="Nhập tên dịch vụ"/>
                        </div>
                        <div class="form-group">
                            <label>Đơn vị tính</label>
                            <form:input type="text" class="form-control" path="donVi" placeholder="Nhập đơn vị tính"/>
                        </div>
                        <div class="form-group">
                            <label>Đơn giá</label>
                            <form:input type="number" class="form-control" path="donGia" placeholder="Đơn giá"/>
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
    <div class="footer" style="background-color: beige; width: 100%">
        <h5 class="card-title" style="text-align: center">Footer</h5>
        <div class="row">
            <div class="col-lg-6">
                <div class="card">
                    <div class="card-body">
                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <ul class="list-group">
                    <li class="list-group-item">Cras justo odio</li>
                    <li class="list-group-item">Dapibus ac facilisis in</li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>
