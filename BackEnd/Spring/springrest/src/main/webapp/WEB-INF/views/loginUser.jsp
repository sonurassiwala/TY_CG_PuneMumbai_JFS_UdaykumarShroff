<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>Login</legend>
		
		<form action="./loginUser" method="post">
			<table>
				
				<tr>
					<td>Email</td>
					<td>:</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="password"></td>
				</tr>

				<tr>
					<td colspan="3" align="center"><br /> <input type="submit"
						value="login"></td>

				</tr>
			</table>

		</form>
	</fieldset>
</body>
</html>