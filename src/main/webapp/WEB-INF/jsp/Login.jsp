<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to Expense Tracker</h2>
    <font color="red">${errorMessage}</font>
    <form action="/login" method="post" modelAttribute="username">
        Username : <input type="text" name="name" />
        Password : <input type="password" name="password" /> 
        <input type="submit" />
    </form>
    
    New user? <a href="/register">Register here</a>
</body>
</html>