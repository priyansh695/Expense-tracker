<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:include page="menu.jsp" />
<body>
	<h2 align="center">Expense</h2>
	<form action="/addTransaction" method="post" modelAttribute="expenseModelAttribute">

		<input type="hidden" name="expenseOrDeposit" value="Expense" /> 
				

		<c:set var="count" value="0" scope="page" />

		<label for="transactionType">Select the type of Expense</label>
		 <select id="transactionTypeList" name="transactionTypeList">
			<c:forEach items="${transactionTypeModel}" var="transactionTypeListVar">
				<option value="${transactionTypeListVar.transactionTypeValue}">
				<c:out value="${transactionTypeListVar.transactionTypeValue}" /></option>
			</c:forEach>

		</select> <br> <label>Expense Amount</label> <input type="number" step=0.01
			name="transactionAmount" value="" required> <br> 
			<label for="transactionDate">Transaction Date:</label> <input type="date" id="transactionDate" name="transactionDate" value="2020-06-04">
		<br> 
		<label for="transactionDescription">Description</label>
		<textarea id="transactionDescription" name="transactionDescription" rows="4" cols="25"></textarea>

		<br> <input type="submit" value="Submit transaction">
	</form>

</body>
</html>