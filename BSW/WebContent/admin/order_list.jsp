<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../css/style.css">
<script src="../js/jquery-3.4.1.min.js" type="text/javascript" ></script>
<script src="../js/jquery.validate.min.js" type="text/javascript" ></script>
<title>manage order</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">

		<h2 class="pageHeading">Book Order Management</h2>
	</div>
	<c:if test="${message !=null }">
		<div align="center">

			<h2 class="message">${message}</h2>
		</div>
	</c:if>
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>Order Id</th>
				<th>Order By</th>
				<th>Book Copies</th>
				<th>Total </th>
				<th>Payment Method</th>
				<th>Status</th>
				<th>Order Date</th>
				<th>Action</th>

			</tr>

			<c:forEach var="order" items="${listOrder}"
				varStatus="status">
				<tr>
					<td>${status.index +1}</td>
					<td>${order.orderId}</td>
					<td>${order.customer.customerFullName}</td>
					<td>${order.bookCopies}</td>
					 <td> $${order.total}</td>
					<td>${order.paymentMethod}</td>
					<td>${order.status}</td>
					<td>${order.orderDate}</td>
					 
					<td>
					<a href="view_order?orderId=${order.orderId}">Detail</a>|
					<a href="edit_order?orderId=${order.orderId}">Edit</a>|
					<a href="javascript:void(0)" class="deleteLink" id="${order.orderId}">Delete</a>
					</td>
				</tr>

			</c:forEach>

		</table>

	</div>

	<jsp:directive.include file="footer.jsp" />
	<script type="text/javascript">
	
	$(document).ready(function(){
		$(".deleteLink").each(function(){
			$(this).on("click", function(){
				var orderId=$(this).attr("id");
				if(confirm('Are You Sure want to delete with  this Review '+orderId+'?')){
					window.location='delete_order?orderId='+orderId;
				}
			});
			
		});
	});
	
	
	
	
	
		/* function confermDelete(categoryId) {
			if (confirm('Are You Sure want to delete with  this userId '
					+ categoryId + '?')) {
				window.location = 'delete_category?categoryId=' + categoryId;
			}
		} */
	</script>
</body>
</html>