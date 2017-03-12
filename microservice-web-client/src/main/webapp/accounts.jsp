<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<html lang="en">

<body>

	<form action="/accounts" method="get">
		<input type="submit" value="Get All"/>
	</form>
	
	<br>
	
	<form action="/accounts/id" method="get">
		<input type="text" name="accountId" />
		<input type="submit" value="Get ID"/>
	</form>
	
	<br>
	
	<form action="/accounts/number" method="get">
		<input type="text" name="accountNumber" />
		<input type="submit" value="Get Account Number"/>
	</form>
	
	<br>

	Current time : <% out.println(System.currentTimeMillis()); %>
	
	<h2>Account : </h2> 
	
	<c:if test="${not empty accounts}">
		<ul>
			<c:forEach var="account" items="${accounts}">
				<li>${account.id} ${account.number} ${account.owner} ${account.balance}</li>
			</c:forEach>
		</ul>
	</c:if>
	
	
	<c:if test="${not empty account}">
		${account.id} ${account.number} ${account.owner} ${account.balance}
	</c:if>
	
	
</body>

</html>