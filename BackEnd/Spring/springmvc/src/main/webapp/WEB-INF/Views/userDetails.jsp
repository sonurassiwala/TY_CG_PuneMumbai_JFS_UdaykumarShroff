<%@page import="com.capgemini.springmvc.beans.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%
	/* String empIdVal = (String) request.getAttribute("empId"); */
/* 	int empIdVal = (int) request.getAttribute("empId");
	String pswd = (String) request.getAttribute("password"); */
	
	UserBean userBean = (UserBean)request.getAttribute("userBean");
%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- Entered Employee Id : <%=empIdVal%>
	Entered Password :  <%=pswd%> --%>
	Entered Employee Id : <%=userBean.getEmpId()%>
	Entered Password :  <%=userBean.getPassword()%>
	Entered DOB : <%=userBean.getDob()%>
	
</body>
</html>