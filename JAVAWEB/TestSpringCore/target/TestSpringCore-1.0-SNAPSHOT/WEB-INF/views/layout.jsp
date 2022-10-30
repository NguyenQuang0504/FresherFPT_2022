<%--
  Created by IntelliJ IDEA.
  User: raymundoortizjr
  Date: 17/10/2022
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h1>Header</h1>
    <tiles:insertAttribute name="content" />
    <h1>Footer</h1>
</div>
</body>
</html>
