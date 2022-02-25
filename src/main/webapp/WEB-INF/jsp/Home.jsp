<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:include page="menu.jsp" />
<body>
<h1 align="center">Expense Tracker</h1>

	Welcome  ${name} !!
<br>    What you want to do today?	<br>
    <a href="/addExpense">Add an expense</a>
    <a href="/addDeposit">Add an deposit</a>
    <a href="/listAllTransactions">List all transactions</a>
	

</body>
</html>