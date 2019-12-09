<%@page import="com.capgemini.springmvc.beans.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>
    
    <% HttpSession session = request.getSession(false);
    EmployeeInfoBean employeeInfoBean = (EmployeeInfoBean) session.getAttribute("employeeInfoBean"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3 style='color: red'>Welcome <%=employeeInfoBean.getEmpName()%> !!</h3>
	
	<a href="./addEmployeeForm">Add Employee</a><br>
	<a href="./updateEmployeeForm">Update Employee Employee</a><br>
	<a href="./deleteEmployeeForm">Delete Employee</a><br>
	<a href="./searchEmployeeForm">Search Employee</a><br>
	<a href="./seeAllEmployeeForm">See All Employee</a><br><br>
	
	<a href="./logout">Logout</a><br>
</body>
</html>