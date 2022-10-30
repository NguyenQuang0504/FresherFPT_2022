<%--
  Created by IntelliJ IDEA.
  User: raymundoortizjr
  Date: 16/10/2022
  Time: 13:37
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
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/stylelogin.css">
</head>
<body>
<div class="div-form container-fluid">
    <h4 class="header-form">Please Sign in</h4>
    <form onsubmit="return submitFormLogin()" action="/login" method="post">
        <i class="text-danger">${loginFail}</i>
        <div class="form-row">
            <div class="form-group">
                <label for="inputEmail4">UserName</label>
                <input type="text" class="form-control email" id="inputEmail4" name="userName" placeholder="UserName">
                <span class="messageEmail" style="color: red"></span>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group">
                <label for="inputPassword4">Password</label>
                <input type="password" class="form-control password" name="password" id="inputPassword4" placeholder="Password">
                <span class="messagePassword" style="color: red"></span>
            </div>
        </div>
        <div class="form-group">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="check" id="gridCheck">
                <label class="form-check-label" for="gridCheck">
                    Remember me
                </label>
            </div>
        </div>
        <button type="submit" class="btn btn-success">Login</button>
        <br>
        <br>
        <a href="/register" style="font-size: 14px">Click her to Register </a>
    </form>
</div>
</body>
</html>
