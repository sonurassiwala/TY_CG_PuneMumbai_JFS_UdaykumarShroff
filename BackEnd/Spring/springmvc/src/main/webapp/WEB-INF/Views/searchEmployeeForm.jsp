<%@page import="com.capgemini.springmvc.beans.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page session="false" %>

<%	EmployeeInfoBean employeeInfoBean = (EmployeeInfoBean) request.getAttribute("employeeInfoBean");
	String msg = (String) request.getAttribute("msg");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="./home">Home</a>
	<br><br>
	<fieldset>
		<legend style="background: navy; color: white;">Search Employee</legend>
		<form action="./searchEmployee" method="get">
			<table>
				<tr>
					<td>Enter Employee ID</td>
					<td> : </td>
					<td><input type="text" name="empId" required></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><br>
						<input type="submit" value="Search">
					</td>
				</tr>
			</table>
		</form>
	</fieldset>
	<br>
	<% if (employeeInfoBean != null) { %>
		<h3 style="color: green;">Employee ID <%=employeeInfoBean.getEmpId()%> Found...</h3>
		<table border="1">
			<tr>
				<th>Name</th>
				<th>Age</th>
				<th>Salary</th>
				<th>Designation</th>
				<th>Mobile</th>
			</tr>
			<tr>
				<td><%=employeeInfoBean.getEmpName()%></td>
				<td><%=employeeInfoBean.getAge()%></td>
				<td><%=employeeInfoBean.getSalary()%></td>
				<td><%=employeeInfoBean.getDesignation()%></td>
				<td><%=employeeInfoBean.getMobile() %></td>
			</tr>
		</table>

	<% } %>
	<% if (msg != null && !msg.isEmpty()) { %>
		<h3 style="color: red;">Employee ID Not Found!!!</h3>
	<% } %>
</body>
</html>