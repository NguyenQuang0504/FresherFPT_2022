<%@ page import="java.util.Date" %>
<%@ page import="java.util.Random" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%! 
	Date d = new Date(); 
	String helloWorld = "Chao mung toi JSP";
	Random rd = new Random();
	int a = rd.nextInt(100);
%>
Today is: <%= new Date() %>
<%= helloWorld %>


<p>

<%
	if (rd.nextInt(100) < 40) {
%>
	<a href="google.com">link to google</a>
<%
	} else {
%>
	<b>This is not link</b>
<%
	}
%>
</p>

<%@ include file="include.jsp" %>
<!-- 
<jsp:include page="include.jsp">
    <jsp:param value="this is param" name="param"/>
</jsp:include>
 -->
</body>
</html>