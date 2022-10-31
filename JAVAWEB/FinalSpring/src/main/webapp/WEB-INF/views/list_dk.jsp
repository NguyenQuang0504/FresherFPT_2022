<%--
  Created by IntelliJ IDEA.
  User: raymundoortizjr
  Date: 30/10/2022
  Time: 09:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="pt-3">
        <nav class="navbar navbar-light bg-light">
            <form style="width: 50%" action="/dangKy/search" method="get">
                Tên KH: <input class="form-control mr-sm-2" name="nameKH" type="search" placeholder="Search" aria-label="Search">
                Tên gói cước:
                <select name="nameGC" class="form-control">
                    <c:forEach items="${goiCuocs}" var="goiCuoc">
                        <option value="${goiCuoc.tenGC}" >${goiCuoc.tenGC}</option>
                    </c:forEach>
                </select>
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </nav>
        <h1>Danh sách đăng ký</h1>
        <h5>${message}</h5>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Ma KH</th>
                <th scope="col">Ho Ten</th>
                <th scope="col">So dien thoai</th>
                <th scope="col">Tong thanh toan</th>
                <th scope="col">Ma Goi cuoc</th>
                <th scope="col">Ten goi cuoc</th>
                <th scope="col">Gia cuoc</th>
                <th>Option</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="dk" items="${dangKys}">
                <tr>
                    <td scope="col">${dk.getMaKH()}</td>
                    <td scope="col">${dk.getHoTen()}</td>
                    <td scope="col">${dk.getSdt()}</td>
                    <td scope="col">${dk.getGiaTriTT()}</td>
                    <td scope="col">${dk.getMaGC()}</td>
                    <td scope="col">${dk.getTenGC()}</td>
                    <td scope="col">${dk.getGiaCuoc()}</td>
                    <td><a href="/dangKy/update?maKH=${dk.getMaKH()}">Update</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <a href="/dangKy/create">Create</a>
</div>
</body>
</html>
