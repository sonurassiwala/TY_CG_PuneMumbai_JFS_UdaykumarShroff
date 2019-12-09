<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
	<ul>
		<li><a href="./seeAllProducts">See All Products</a></li>
		<li><a href="./updateProfile">Update Profile</a></li>
		<li><a href="./placeOrder">Place Order</a></li>
		<li><a href="./payment">Payment</a></li>
	</ul>

</body>
</html>