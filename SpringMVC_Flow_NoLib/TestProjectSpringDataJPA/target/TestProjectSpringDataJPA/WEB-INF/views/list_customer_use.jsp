<%--
  Created by IntelliJ IDEA.
  User: raymundoortizjr
  Date: 23/10/2022
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CustomerList</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <%--    <link rel="stylesheet" type="text/css"--%>
    <%--           href="<%=request.getContextPath()%>/resources/css/home.css">--%>
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
            <div class="container" style="padding-top: 30px">
                <div>
                    <h5 style="text-align: center">Danh sách khách hàng</h5>
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">Mã KH</th>
                            <th scope="col">Tên KH</th>
                            <th scope="col">Mã dịch vụ</th>
                            <th scope="col">Mã máy</th>
                            <th scope="col">Ngày bắt đầu sử dụng</th>
                            <th scope="col">Ngày sử dụng</th>
                        </tr>
                        </thead>
                        <tbody>
                        <th:forEach items="${list}" var="customerUse">
                            <tr>
                                <td>${customerUse.getMaKH()}</td>
                                <td>${customerUse.getTenKH()}</td>
                                <td>${customerUse.getMaDV()}</td>
                                <td>${customerUse.getMaMay()}</td>
                                <td>${customerUse.getNgayBD()}</td>
                                <td>${customerUse.getNgaySD()}</td>
<%--                                <td class="option">--%>
<%--                                    <a href="/customer/update?id=${customer.getMaKH()}">--%>
<%--                                        <svg xmlns="http://www.w3.org/2000/svg" color="green" width="20" height="20" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">--%>
<%--                                            <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>--%>
<%--                                            <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>--%>
<%--                                        </svg>--%>
<%--                                    </a>--%>
<%--                                </td>--%>
<%--                                <td>--%>
<%--                                        &lt;%&ndash;                                    DELETE USE POPUP&ndash;%&gt;--%>
<%--                                    <svg data-toggle="modal" data-target="#${customer.getMaKH()}" xmlns="http://www.w3.org/2000/svg" color="red" width="20" height="20" fill="currentColor" class="bi bi-trash-fill" viewBox="0 0 16 16">--%>
<%--                                        <path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"/>--%>
<%--                                    </svg>--%>
<%--                                    <!-- Modal -->--%>
<%--                                    <div class="modal fade" id="${customer.getMaKH()}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">--%>
<%--                                        <div class="modal-dialog" role="document">--%>
<%--                                            <div class="modal-content">--%>
<%--                                                <div class="modal-header">--%>
<%--                                                    <h5 class="modal-title" id="exampleModalLabel">Confirm</h5>--%>
<%--                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                                                        <span aria-hidden="true">&times;</span>--%>
<%--                                                    </button>--%>
<%--                                                </div>--%>
<%--                                                <div class="modal-body">--%>
<%--                                                    <h6 style="color: orange;">You want delete <c:out value="${customer.getTenKH()}"/></h6>--%>
<%--                                                </div>--%>
<%--                                                <div class="modal-footer">--%>
<%--                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
<%--                                                    <a href="/customer/delete?id=${customer.getMaKH()}" type="button" class="btn btn-primary">Delete</a>--%>
<%--                                                </div>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </td>--%>
                            </tr>
                        </th:forEach>
                        </tbody>
                    </table>
                </div>
                <%--                Paging--%>
<%--                <nav aria-label="Page navigation example">--%>
<%--                    <ul class="pagination">--%>
<%--                        <c:if test="${currentPage >1}">--%>
<%--                            <li class="page-item"><a class="page-link" href="/customer/list?page=${currentPage-1}">Previous</a></li>--%>
<%--                        </c:if>--%>
<%--                        <c:forEach begin="1" end="${totalPage}" var="i" >--%>
<%--                            <c:choose>--%>
<%--                                <c:when test="${currentPage eq i}">--%>
<%--                                    <li class="page-item"><a class="page-link bg-success" href="/customer/list?page=${i}">${i}</a></li>--%>
<%--                                </c:when>--%>
<%--                                <c:otherwise>--%>
<%--                                    <li class="page-item"><a class="page-link" href="/customer/list?page=${i}">${i}</a></li>--%>
<%--                                </c:otherwise>--%>
<%--                            </c:choose>--%>
<%--                        </c:forEach>--%>
<%--                        <c:if test="${currentPage < totalPage}">--%>
<%--                            <li class="page-item"><a class="page-link" href="/customer/list?page=${currentPage+1}">Next</a></li>--%>
<%--                        </c:if>--%>
<%--                    </ul>--%>
<%--                </nav>--%>

            </div>
            <a href="/customer/create" type="button" class="btn btn-success">Create</a>
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
