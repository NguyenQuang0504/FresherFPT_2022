<%!String include = "This is include file. Change new content";%>
<%!String include2 = "This is include file. Change new content2";%>
<%!String include3 = "This is include file. Change new content3";%>
<%!String include4 = "This is include file. Change new content3";%>
<h3><%= include %></h3>
<h3><%= include2 %></h3>
<h3><%= include3 %></h3>
<h3><%= include4 %></h3>
<h5>
	<% if (include3 == include4)  {%>
		<p>File include 3 = file include 4</p>
	<%} else {%>
		<p>File include 3 != file include 4</p>
	<%}
    
    String param = request.getParameter("param");
    
    %>
    
    <%=param %>
</h5>