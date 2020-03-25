<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Customer</title>
<link rel="stylesheet" href="../css/style.css">
<!-- <script src="../js/jquery-3.4.1.min.js" type="text/javascript" ></script>
<script src="../js/jquery.validate.min.js" type="text/javascript" ></script> -->
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">

		<h2 class="pageHeading">Book Management</h2>
		<a href="customer_form.jsp">Create New Customer</a>
	</div>
	<c:if test="${message !=null }">
	<div align="center">
	
	<h4>${message}</h4>
	</div>
	</c:if>
	<div align="center">
	<table border="1" cellpadding="5">
	<tr>
	<th>Index</th>
	<th>Id</th>
	<th> Email</th>
	<th>FullName</th>
	<th>Address</th>
	<th>City</th>
	<th> Country</th>
	<th>Register Date</th>
	<th>Phone</th>
	<th>ZipCode</th>
	<th>Action</th>
	
	</tr>
	
	<c:forEach var="customerList" items="${customerList}" varStatus="status">
	<tr>
	<td>${status.index +1}</td>
	<td>${customerList.customerId}</td>
	<td>${customerList.customerEmail}</td>
	<td>${customerList.customerFullName}</td>
	<td>${customerList.customerAddress}</td>
	<td>${customerList.customerCity}</td>
	<td>${customerList.customerCountry}</td>
	<td><fmt:formatDate value="${customerList.customerRegisterDate}" pattern="dd/MM/yyyy"/></td>
	<td>${customerList.customerPhone}</td>
	<td>${customerList.customerZipCode}</td>
	
	 <td>
	<a href="edit_customer?id=${customerList.customerId}">Edit</a>|
	<a href="javascript:void(0)" class="deleteLink" id="${customerList.customerId}">Delete</a>
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
				var customerId=$(this).attr("id");
				if(confirm('Are You Sure want to delete with  this customerId '+customerId+'?')){
					window.location='delete_customer?customerId='+customerId;
				}
			});
			
		});
	});
	
	</script>
</body>
</html>