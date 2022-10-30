<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="pkg.model.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Login</h2>
<%
    UserBean user = (UserBean)request.getAttribute("loginInfo");
%>
<form action="/ServletDemo/login" method="post">
  <div class="container">
    <label for="username"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" required value="<%=user.getUserName() %>">

    <label for="username"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required  value="<%=user.getPassword() %>">
    
    <%
    	String message = (String)request.getAttribute("loginMessage");
    	if (message != null && !"".equals(message)) {
    %>
    	<label><%=message %></label>
    <%	
    	}
    %>
    
    

    <button type="submit">Login</button>
  </div>
</form>
</body>
</html>