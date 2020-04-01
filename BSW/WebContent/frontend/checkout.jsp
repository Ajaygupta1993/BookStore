<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check out</title>
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src="js/jquery.validate.min.js" type="text/javascript"></script>
</head>
<body>
<jsp:directive.include file = "header.jsp" />
	<div align="center">
		
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
	
	
	<div>
	<h2>Review Your Order Detail :<a href="view_cart">Edit</a></h2>
	  <table border="1" cellpadding="5">
	  
	  <tr>
	  <th>No</th>
	  <th>Book</th>
	  <th>Author</th>
	  <th>Price</th>
	  <th>Quantity</th>
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
	 <td>${item.key.bookAuther}</td>
	 <td> <fmt:formatNumber value="${item.key.bookPrice}" type="currency"></fmt:formatNumber></td>
	  <td>
	  <input type="text" name="quantity${status.index + 1}" value="${item.value}" size="5" readonly="readonly" />
	  </td>
	  
	  <td> <fmt:formatNumber value="${item.value * item.key.bookPrice}" type="currency"></fmt:formatNumber></td>
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
	
	<h2>Your Shipping Information</h2>
	<form action="place_order" id="orderForm" method="post">
	<table >
	<tr>
	<td>Recipient Name:</td>
	<td><input type="text" name="recipientName" id="recipientName" value="${customerLogedin.customerFullName}" maxlength="40"></td>
	</tr>
	<tr>
	<td>Recipient Phone:</td>
	<td><input type="text" name="recipientPhone" id="recipientPhone" value="${customerLogedin.customerPhone}" maxlength="10"></td>
	</tr>
	
	<tr>
	<td>Street Address:</td>
	<td><input type="text" name="recipientAddress" id="recipientAddress" value="${customerLogedin.customerAddress}" maxlength="40"></td>
	</tr>
	<tr>
	<td>City :</td>
	<td><input type="text" name="recipientCity" id="recipientCity" value="${customerLogedin.customerCity}" maxlength="40"></td>
	</tr>
	<tr>
	<td>ZipCode :</td>
	<td><input type="text" name="recipientZipCode" id="recipientZipCode" value="${customerLogedin.customerZipCode}" maxlength="6"></td>
	</tr>
	<tr>
	<td>Country :</td>
	<td><input type="text" name="recipientCountry" id="recipientCountry" value="${customerLogedin.customerCountry}" maxlength="20"></td>
	
	</table>
	  <div>
	  <h2>Payment</h2>
	  Choose Your Payment:
	  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  <select name="paymentMethod">
	  <option value="cash On Delivery">Cash On Delivery</option>
	  
	  </select>
	  </div>
	  <div>
	
	<table class="form">
	<tr>
	<td></td>
	<td><button type="submit">Place Order</button></td>
	<td><a href="${pageContext.request.contextPath}/">Continue Shopping</a></td>
	
	</tr>
	</table>
	
	</div>
	</form>
	</div>
	</c:if>
	</div>
<jsp:directive.include file = "footer.jsp" />
</body>
<script type="text/javascript">
	$(document).ready(function() {
		/* $("#orderForm").click(function(){
			window.location='clear_cart';
		}) */
				
		
		$("#orderForm").validate({
			
			rules : {
				recipientName : "required",
				recipientPhone:{
					required: true,
				      number: true,
				      minlength:10
				      
				},
				recipientAddress : "required",
				recipientCity  : "required",
				recipientZipCode: {
				      required: true,
				      number: true,
				      minlength:6
				     
				    },
				recipientCountry : "required"
				
			},

			messages : {
				recipientName : "Enter Recipient Name",
				recipientPhone:{
					required:"Enter Recipient Phone",
					number:"Enter only numeric",
					minlength:"Minimum 10 digit required"
					
				},
				recipientAddress : "Enter Recipient Address",
				recipientCity  : "Enter City Required",
				recipientZipCode:{
					required:"Enter Zip Code ",
					number: " numeric Only",
					minlength:"Minimum 6 digit required"
				},
				recipientCountry : "Enter Country Name"
				
			}

		});

	});
</script>
</html>