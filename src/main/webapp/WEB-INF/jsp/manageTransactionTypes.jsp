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
	<h2 align="center">Below are the list of ${expenseOrDepositObject} Types</h2>
	
	<table border="1" cellpadding="5">
	
	<tr>
				<th>S. No</th>
                <th>Transaction Type</th>
                <th>Expense or Deposit</th>
                <th>Actions</th>
     </tr>
     
     <c:set var="count" value="0" scope="page" />
     
     <c:forEach items="${transactionTypeModel}" var="transactionModel">
	
     <tr>
     				<c:set var="count" value="${count + 1}" scope="page"/>
     				<td><c:out value="${count}"/></td>
					<td><c:out value="${transactionModel.transactionTypeValue}" /></td>
					<td><c:out value="${transactionModel.ttypeExpenseDeposit}" /></td>
					

					<td><a href="/deleteTransactionType/${transactionModel.ttypeExpenseDeposit}/${transactionModel.transactionTypeValue}">Delete</a>

				</tr>
		</c:forEach>
	</table>
	
	<h2 align="center">Add ${expenseOrDepositObject} Types</h2>
	<form action="/addTransactionTypes" method="post" modelAttribute="expenseModelAttribute">
	
		<input type="hidden" name="expenseOrDeposit" value="${expenseOrDepositObject}" /> 
<!-- 		<input type="hidden" name="username" value="pj695" />  -->

		<br> <label>New ${expenseOrDepositObject} Type Name</label> 
		<input type="text" name="newTransactionType" value=""> <br> 
		<br> 

		<br> <input type="submit" value="Add Type">
	</form>
	
<!-- 	<label for="transactionType">Select the type of Expense</label> <select -->
<!-- 			id="transactionType" name="transactionType"> -->
<%-- 			<c:forEach items="${transactionList}" var="transactionModel"> --%>
<%-- 				<option value="food">${transactionModel.transactionAmount}</option> --%>
<%-- 			</c:forEach> --%>
<!-- 		</select>  -->
</body>
</html>