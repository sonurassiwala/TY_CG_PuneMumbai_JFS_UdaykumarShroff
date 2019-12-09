<%@page import="java.util.List"%>
<%@page import="com.capgemini.medspringmvc.beans.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>

<%	List<ProductBean> productList = (List<ProductBean>) request.getAttribute("productsList"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="./home">Home</a>
	<br><br>
	<% if (productList != null && !productList.isEmpty()) { %>
	<div align="center">
		<table>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Category</th>
				<th>Price</th>
			</tr>
			<% for (ProductBean productInfoBean : productList) { %>
				<tr>
					<td><%=productInfoBean.getpId()%></td>
					<td><%=productInfoBean.getName()%></td>
					<td><%=productInfoBean.getCategory()%></td>
					<td><%=productInfoBean.getPrice()%></td>
				</tr>
			<% } %>	
		</table>
	</div>
	<% } else { %>
		<h3 style="color: red;">Unable To Fetch Records!!!</h3>
	<% } %>

</body>
</html>