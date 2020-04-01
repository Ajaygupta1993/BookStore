<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">


<title>order History</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">

		<h2 class="pageHeading">Order History</h2>
	</div>
	
	<c:if test="${fn:length(listOrder) == 0}">
	  <h2 align="center">You did not placed any Order</h2>
	</c:if>
	
	
	<c:if test="${fn:length(listOrder) > 0}">
	<div align="center">
		<table border="1">
			<tr>
				<th>Index</th>
				<th>Order Id</th>
				<th>Quantity</th>
				<th>Total Amount </th>
				<th>Order Date</th>
				<th>Status</th>
				<th>Action</th>

			</tr>

			<c:forEach var="order" items="${listOrder}"
				varStatus="status">
				<tr>
					 <td>${status.index +1}</td> 
					<td>${order.orderId}</td>
					<td>${order.bookCopies}</td>
					 <td> $${order.total}</td>
					 <td>${order.orderDate}</td>
					<td>${order.status}</td> 
					<td>
					<a href="view_detail?orderId=${order.orderId}">Veiw Detail</a>
					</td>
				</tr>

			</c:forEach>

		</table>

	</div>
</c:if>
	<jsp:directive.include file="footer.jsp" />
	
</body>
</html>