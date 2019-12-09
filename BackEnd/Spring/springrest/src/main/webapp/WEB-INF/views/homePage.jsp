<%@page import="com.capgemini.medspringmvc.beans.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
	String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<% 

UserBean userBean = (UserBean) request.getAttribute("userBean");
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover {
  background-color: #111;
}
</style>
</head>
<body>
<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<h3 style="color: red;"><%=msg%></h3>
	<%
		}
	%>
	<ul>
		<li><a href="./registerUser">Register User</a></li>
		<li><a href="./loginUser">Login User</a></li>
		<li><a href="./adminLogin">Admin Login</a></li>
		<li><a href="./productList">Product List</a></li>
	</ul>
</body>
</html>