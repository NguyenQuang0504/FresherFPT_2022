<%--
  Created by IntelliJ IDEA.
  User: raymundoortizjr
  Date: 30/10/2022
  Time: 09:27
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
    <div class="pt-4">
        <h1>Đăng ký sử dụng DV</h1>
        <form:form action="/dangKy/save" method="post" modelAttribute="dangKy" onsubmit="return handlerSubmit()">
            <div class="form-group">
                <label>Ma KH</label>
                <form:input path="maKH" type="text" class="form-control"  aria-describedby="emailHelp" placeholder="Enter ma KH"/>
            </div>
            <div class="form-group">
                <label>Ho ten</label>
                <form:input path="hoTen" type="text" class="form-control"  aria-describedby="emailHelp" />
            </div>
            <div class="form-group">
                <label>Gioi tinh</label>
                <form:input path="gioiTinh" type="text" class="form-control"  aria-describedby="emailHelp" />
            </div>
            <div class="form-group">
                <label>Ngay sinh</label>
                <form:input path="ngaySinh" type="date" class="form-control"  aria-describedby="emailHelp" />
            </div>
            <div class="form-group">
                <label>Dia chi</label>
                <form:input path="diaChi" type="text" class="form-control"  aria-describedby="emailHelp" />
            </div>
            <div class="form-group">
                <label>So dien thoai</label>
                <form:input path="sdt" type="text" class="form-control" id="sdt1" aria-describedby="emailHelp" />
                <i style="color: red" id="messageSDT"></i>
            </div>
            <div class="form-group">
                <label>Ngay DK</label>
                <form:input path="ngayDK" type="date" id="ngayDK" value="${ngayDk}" class="form-control"  aria-describedby="emailHelp" />
                <i style="color: red" id="messageDk"></i>

            </div>
            <div class="form-group">
                <label>Ngay KT</label>
                <form:input path="ngayKT" type="date" disabled="true" class="form-control"  aria-describedby="emailHelp" />
            </div>
            <div class="form-group">
                <label>Ma HD</label>
                <form:input path="maHD" type="text" class="form-control"  aria-describedby="emailHelp" />
            </div>
            <div class="form-group">
                <label>Chiet Khau</label>
                <form:input path="chetKhau" type="text" class="form-control"  aria-describedby="emailHelp" />
            </div>
<%--            <div class="form-group">--%>
<%--                <label>Gia tri TT</label>--%>
<%--                <form:input path="giaTriTT" type="text" disabled="true" class="form-control"  aria-describedby="emailHelp" />--%>
<%--            </div>--%>
            <div class="form-group">
                <label>Ma Goi Cuoc</label>
                <form:input path="goiCuoc.maGC" type="text" class="form-control"  aria-describedby="emailHelp" />
                <i style="color: red">${message}</i>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form:form>
    </div>
</div>
<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
<script
        src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
        integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
        crossorigin="anonymous">
</script>
<script type="text/javascript" src="/resources/js/validation.js"></script>
</body>
</html>
