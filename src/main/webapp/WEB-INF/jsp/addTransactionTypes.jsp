<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:include page="menu.jsp" />
<body>
	<h2 align="center">Add Transaction Types</h2>
	<form action="/addTransactionTypes" method="post" >

		<c:set var="count" value="0" scope="page" />

		<label for="transactionType">Select the type of Expense</label>
		 <select id="transactionTypeList" name="transactionTypeList">


		</select> <br> <label>Transaction Type Name</label> <input type="text"
			name="newtransactiontype" value=""> <br> 
			<label for="transactionDate">Transaction Date:</label> <input type="date" id="transactionDate" name="transactionDate" value="2020-06-04">
		<br> 
		<label for="transactionDescription">Description</label>
		<textarea id="transactionDescription" name="transactionDescription" rows="4" cols="25"></textarea>

		<br> <input type="submit" value="Submit transaction">
	</form>

</body>
</html>