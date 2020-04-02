<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../css/style.css">
<script src="../js/jquery-3.4.1.min.js" type="text/javascript" ></script>
<title>Edit Order Detail</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">

		<h2 class="pageHeading">Edit of Order Id: ${order.orderId}</h2>
	</div>
	<c:if test="${message !=null }">
		<div align="center">

			<h2 class="message">${message}</h2>
		</div>
	</c:if>
	<div align="center">
	  <form action="update_order" method="post" id="orderForm">
		<h2>Order OverView:</h2>
		<table border="1">
		<tr>
		<td><b>Order By</b></td>
		<td>${order.customer.customerFullName}</td>
		
		</tr>
		<tr>
		<td><b>Order Date</b></td>
		<td>${order.orderDate}</td>
		</tr>
		
		<tr>
		<td><b>Recipient Name</b></td>
		<td><input type="text" name="recipientName" id="recipientName" maxlength="40" value="${order.recipientName}"></td>
		
		</tr>
		
		<tr>
		<td><b>Recipient Phone</b></td>
		<td><input type="text" name="recipientPhone" id="recipientPhone" maxlength="40" value="${order.recipientPhone}"></td>
		
		</tr>
		
		<tr>
		<td><b>Ship To</b></td>
		<td><input type="text" name="shippingAddress" id="shippingAddress" maxlength="100" value="${order.shippingAddress}"></td>
		
		</tr>
		
		<tr>
		<td><b>Payment Method</b></td>
		<td>
		<select name="paymentMethod">
		
		<option value="cash on delivery">cash on delivery</option>
		</select>
		</td>
		
		</tr>
		
		
		<tr>
		<td><b>Order Status</b></td>
		<td>
		<select name="orderStatus">
		
		<option value="processing">processing</option>
		<option value="shipping">shipping</option>
		<option value="delivered">Delivered</option>
		<option value="completed">Completed</option>
		<option value="cancel">Cancel</option>
		</select>
		
		</td>
		
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
	<th></th>
	</tr>
	<c:forEach items="${order.orderDetails}" var="orderDetail" varStatus="status">
	<tr>
	<td>${status.index +1}</td>
	<td>${orderDetail.book.bookTitle}</td>
	<td>${orderDetail.book.bookAuther}</td>
	<td>$${orderDetail.book.bookPrice}</td>
	
	<td><input type="text" name="shippingAddress" id="shippingAddress" size="5" value="${orderDetail.quantity}"></td>
	
	<td>$${orderDetail.subtotal}</td>
	 <td>
	  <a href="">Remove</a>
	  </td>
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
	  
	 <td></td>
	   
	  </tr>
	</table>
	
	</div>
	<div align="center">
	<br/>
	<a href="javascript:showAddBookPopup()">Add Books</a>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" value="Save">
	&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="Cancel">
	</form>
	</div>
    
	<jsp:directive.include file="footer.jsp" />
	<script type="text/javascript">
	function showAddBookPopup(){
		var width=500;
		var height=200;
		var left=(screen.width - width)/2;
		var top=(screen.height - height)/2;
		window.open('add_book_form','_blank','width='+ width +', height=' + height + ',top=' + top +', left=' + left);
	}
	</script>
</body>
</html>