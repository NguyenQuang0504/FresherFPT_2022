<%--
  Created by IntelliJ IDEA.
  User: raymundoortizjr
  Date: 30/10/2022
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %><html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Ho Ten</th>
        <th scope="col">Xe Thue</th>
        <th scope="col">Dia Chi</th>
        <th scope="col">SDT</th>
        <th scope="col">Ngay Thue</th>
        <th scope="col">Gio BD</th>
        <th scope="col">Gio KT</th>
        <th scope="col">Tong Tien</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="dangKy" items="${dangKys}">
        <tr>
            <td scope="col">${dangKy.maDK}</td>
            <td scope="col">${dangKy.hoTen}</td>
            <td scope="col">${dangKy.xeThue.maXe}</td>
            <td scope="col">${dangKy.diaChi}</td>
            <td scope="col">${dangKy.sdt}</td>
            <td scope="col">${dangKy.ngayThue}</td>
            <td scope="col">${dangKy.gioBD}</td>
            <td scope="col">${dangKy.gioKT}</td>
            <td scope="col">${dangKy.tongTien}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
