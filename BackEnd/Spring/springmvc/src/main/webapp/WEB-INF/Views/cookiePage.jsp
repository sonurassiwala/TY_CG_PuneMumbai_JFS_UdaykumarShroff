<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	String msg = (String) request.getAttribute("msg");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="./createCookie">Click Here</a>to create cookie...
	<br>
	<a href="./readCookie">Click Here</a>to read cookie...
	<br>
	<br>

	<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<%=msg%>
	<%
		}
	%>

</body>
</html>