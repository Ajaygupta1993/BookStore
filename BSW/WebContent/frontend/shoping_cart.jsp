<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Cart</title>
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src="js/jquery.validate.min.js" type="text/javascript"></script>
</head>
<body>
<jsp:directive.include file = "header.jsp" />
	<div align="center">
		<h2> Your Shopping Cart</h2>
		<c:if test="${message !=null }">
	<div align="center">
	
	<h3 class="pageHeading">${message}</h3>
	</div>
	</c:if>
	<c:set var="cart" value="${sessionScope['cart']}"/>
	
	<c:if test="${cart.totalItems == 0 }">
	<h2>There's is no carts</h2>
	</c:if>
	<c:if test="${cart.totalItems > 0 }">
	
	<form action="update_cart" method="post" id="cartForm">
	<div>
	  <table border="1" cellpadding="5">
	  
	  <tr>
	  <th>No</th>
	  <th>Book</th>
	  <th>Quantity</th>
	  <th>Price</th>
	  <th>Sub Total</th>
	  <th>
	  
	  </th>
	  </tr>
	  
	  <c:forEach items="${cart.items }" var="item" varStatus="status">
	  
	  <tr>
	  <td>${status.index + 1}</td>
	  <td>
	  <img  src="data:image/jpg;base64,${item.key.base64Image}" width="40" height="50">
	  &nbsp; &nbsp; &nbsp; &nbsp;
	 <span id="#book-title"> ${item.key.bookTitle}</span></td>
	  <td>
	  <input type="hidden" name="bookId" value="${item.key.bookId}">
	  <input type="text" name="quantity${status.index + 1}" value="${item.value}" size="5" />
	  </td>
	  <td> <fmt:formatNumber value="${item.key.bookPrice}" type="currency"></fmt:formatNumber></td>
	  <td> <fmt:formatNumber value="${item.value * item.key.bookPrice}" type="currency"></fmt:formatNumber></td>
	   <td><a href="remove_from_cart?book_id=${item.key.bookId}">Remove</a></td>
	  </tr>
	  </c:forEach>
	  <tr>
	  <td></td>
	  <td></td>
	  <td><b>${cart.totalQuantity} book(s)</b></td>
	  <td>Total:</td>
	  <td colspan="2"> <b><fmt:formatNumber value="${cart.totalAmount}" type="currency"></fmt:formatNumber></b></td>
	  </tr>
	  
	  </table>
	</div>
	<div>
	<table class="form">
	<tr>
	<td></td>
	<td><button type="submit">Update</button></td>
	<td><input type="button" id="clearCart" value="clearCart"/></td>
	<!-- <button id="">Clear Cart</button> -->
	<td><a href="${pageContext.request.contextPath}/">Continue Shopping</a></td>
	<td><a href="">CheckOut</a></td>
	</tr>
	</table>
	</div>
	</form>
	
	
	
	</c:if>
	</div>
<jsp:directive.include file = "footer.jsp" />
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$("#clearCart").click(function(){
			window.location='clear_cart';
		})
				
		
		$("#cartForm").validate({

			rules : {
				<c:forEach items="${cart.items }" var="item" varStatus="status">
				quantity${status.index + 1}:{required : true, number:true,min:1},
				</c:forEach>
			},

			messages : {
				<c:forEach items="${cart.items }" var="item" varStatus="status">
				quantity${status.index + 1}:{
				required : "Please enter Quantity",
				number :"Quantity must be a number",
				min : "Quantity must be greter then 0"
				},
				</c:forEach>
			}

		});

	});
</script>
</html>