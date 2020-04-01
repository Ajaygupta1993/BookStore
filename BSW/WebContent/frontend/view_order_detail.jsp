<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<title>Order Detail</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
     <c:if test="${order == null }">
     <h2 align="center"> Sorry You are not authorise to view this order</h2>
     </c:if>
	<div align="center">

		<h2 class="pageHeading">Detail of Your Order Id: ${order.orderId}</h2>
	</div>
	<c:if test="${order !=null }">
	<div align="center">
		<h2>Order OverView:</h2>
		<table border="1">
		<tr>
		<td><b>Order Status</b></td>
		<td>${order.status}</td>
		
		</tr>
		<tr>
		<td><b>Order Date</b></td>
		<td>${order.orderDate}</td>
		</tr>
		<tr>
		<td><b>Book Copies</b></td>
		<td>${order.bookCopies}</td>
		
		</tr>
		<tr>
		<td><b>Total Amount</b></td>
		<td>$${order.total}</td>
		
		</tr>
		<tr>
		<td><b>Recipient Name</b></td>
		<td>${order.recipientName}</td>
		
		</tr>
		<tr>
		<td><b>Recipient Phone</b></td>
		<td>${order.recipientPhone}</td>
		
		</tr>
		<tr>
		<td><b>Payment Method</b></td>
		<td>${order.paymentMethod}</td>
		
		</tr>
		
		<tr>
		<td><b>Shipping Address</b></td>
		<td>${order.shippingAddress}</td>
		
		</tr>
		
		
		</table>
	</div>
	
	<div align="center">
	<h2>Ordered Books:</h2>
	<table border="1">
	<tr>
	<th>Index</th>
	<th>Book Title</th>
	<th>Author</th>
	<th>Price</th>
	<th>Quantity</th>
	<th>Sub total</th>
	</tr>
	<c:forEach items="${order.orderDetails}" var="orderDetail" varStatus="status">
	<tr>
	<td>${status.index +1}</td>
	<td>${orderDetail.book.bookTitle}</td>
	<td>${orderDetail.book.bookAuther}</td>
	<td>$${orderDetail.book.bookPrice}</td>
	<td>${orderDetail.quantity}</td>
	<td>$${orderDetail.subtotal}</td>
	
	</tr>
	</c:forEach>
	  <tr>
	  <td colspan="4" align="right">
	   <b>TOTAL:</b>
	  </td>
	  <td>${order.bookCopies}</td>
	  <td>
	   $${order.total}
	  </td>
	   
	  </tr>
	</table>
	
	</div>
	</c:if>
	<div align="center">
	<br>
	<a href="${pageContext.request.contextPath}/">Continue Shopping</a>
	</div>

	<jsp:directive.include file="footer.jsp" />
	
</body>
</html>