<%--
  Created by IntelliJ IDEA.
  User: raymundoortizjr
  Date: 30/10/2022
  Time: 14:33
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
    <script type="text/javascript" src="/resources/js/validation.js"></script>

</head>
<body>
    <div class="container">
        <form:form modelAttribute="dangKy" onsubmit="return handlerSubmit()" action="/home/save" method="post">
            <div class="form-group">
                <label for="exampleInputEmail1">Ma DK</label>
                <form:input path="maDK" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email"/>
<%--                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>--%>
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Ho ten</label>
                <form:input path="hoTen" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email"/>
<%--                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>--%>
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Gioi tinh</label>
                <form:input path="gioiTinh" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email"/>
<%--                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>--%>
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Ngay sinh</label>
                <form:input path="ngaySinh" type="date" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email"/>
                    <%--                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>--%>
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Dia chi</label>
                <form:input path="diaChi" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email"/>
                    <%--                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>--%>
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">SDT</label>
                <form:input path="sdt" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email"/>
                    <%--                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>--%>
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Ngay thue</label>
                <form:input path="ngayThue" id="date" type="date" class="form-control"  aria-describedby="emailHelp" placeholder="Enter email"/>
                    <%--                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>--%>
                <i id="messageDate"></i>

            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Gio BD</label>
                <form:input path="gioBD" type="time" id="timeBD" class="form-control"  aria-describedby="emailHelp" placeholder="Enter email"/>
                    <%--                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>--%>
                <i id="messageTime"></i>
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Gio KT</label>
                <form:input path="gioKT" type="time" class="form-control" id="timeKT" aria-describedby="emailHelp" placeholder="Enter email"/>
                    <%--                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>--%>
            </div>
            <div class="form-group">
                <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Xe Thue</label>
                <form:select path="xeThue.maXe" class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref">
                    <c:forEach var="xeThue" items="${xeThues}">
                        <option value="${xeThue.maXe}">${xeThue.maXe}</option>
                    </c:forEach>
                </form:select>
            </div>
<%--            <div class="form-group">--%>
<%--                <label for="exampleInputEmail1">Gioi tinh</label>--%>
<%--                <form:input path="tongTien" type="text" " class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email"/>--%>
<%--                    &lt;%&ndash;                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>&ndash;%&gt;--%>
<%--            </div>--%>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form:form>
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
