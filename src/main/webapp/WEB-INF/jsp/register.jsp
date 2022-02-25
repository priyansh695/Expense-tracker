<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">Register</h2>
	<form action="/register" method="post" modelAttribute="registerModelAttribute">
			 <br> <label>Username</label> <input type="text" name="username" value=""> <br>  <font color="red">${userExist}</font>
			 <br> <label>Password</label> <input type="password" name="userpassword" value=""> <br> 
			 <br> <label>Email</label> <input type="email" name="useremail" value=""> <br> 	<font color="red">${userEmailExist}</font>

		<br> <input type="submit" value="Submit">
	</form>

</body>
</html>