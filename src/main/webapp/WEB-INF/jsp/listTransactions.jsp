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

	<p>${NOTIFICATION}</p>
	
	<br>
	<h2 align="center">Below are the list of transactions</h2>
	
	<table border="1" cellpadding="5">
	
	<tr>
				<th>S. No</th>
                <th>Transaction Category</th>
                <th>Transaction Type</th>
                <th>Amount</th>
                <th>Transaction Date</th>
                <th>Description</th>
                <th>Actions</th>
     </tr>
     
     <c:set var="count" value="0" scope="page" />
     
     <c:forEach items="${transactionModel}" var="transactionModel">
	
     <tr>
     				<c:set var="count" value="${count + 1}" scope="page"/>
     				<td><c:out value="${count}"/></td>
					<td><c:out value="${transactionModel.expenseDeposit}" /></td>
					<td><c:out value="${transactionModel.transactionType.transactionTypeValue}" /></td>
					<td><c:out value="${Float.toString(transactionModel.transactionAmount)}" /></td>
					<td><c:out value="${transactionModel.transactionDate}" /></td>
					<td><c:out value="${transactionModel.transactionDescription}" /></td>

					<td><a href="/deleteTransaction/${transactionModel.transactionID}">Delete</a>

				</tr>
		</c:forEach>
	</table>
	<h1></h1>
	<br>
	Total Expenses = ${TotalExpenses}
	<br> 
	Total Deposits = ${TotalDeposits}
	<br>
	Current Standings = ${TotalStandings}
	
<!-- 	<label for="transactionType">Select the type of Expense</label> <select -->
<!-- 			id="transactionType" name="transactionType"> -->
<%-- 			<c:forEach items="${transactionList}" var="transactionModel"> --%>
<%-- 				<option value="food">${transactionModel.transactionAmount}</option> --%>
<%-- 			</c:forEach> --%>
<!-- 		</select>  -->
</body>
</html>