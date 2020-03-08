<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Users</title>
<link rel="stylesheet" href="../css/style.css">
<script src="../js/jquery-3.4.1.min.js" type="text/javascript" ></script>
<script src="../js/jquery.validate.min.js" type="text/javascript" ></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">

		<h2 class="pageHeading">Book Management</h2>
		<a href="new_book">Create New Book</a>
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
	<th> Title</th>
	<th>Image</th>
	<th>Auther</th>
	<th>Category</th>
	<th> Price</th>
	<th>Last Updated</th>
	<th>Action</th>
	
	</tr>
	
	<c:forEach var="book" items="${listBook}" varStatus="status">
	<tr>
	<td>${status.index +1}</td>
	<td>${book.bookId}</td>
	<td>${book.bookTitle}</td>
	
	
	<td>
	<img  src="data:image/jpg;base64,${book.base64Image}" width="84" height="90">
	
	
	</td>
	
	
	
	<td>${book.bookAuther}</td>
	<td>${book.category.categoryName}</td>
	<td>$${book.bookPrice}</td>
	<td><fmt:formatDate value="${book.bookLastUpdated}" pattern="dd/MM/yyyy"/></td>
	 <td>
	<a href="edit_book?id=${book.bookId}">Edit</a>|
	<a href="javascript:void(0)" class="deleteLink" id="${book.bookId}">Delete</a>
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
				var bookId=$(this).attr("id");
				if(confirm('Are You Sure want to delete with  this BookId '+bookId+'?')){
					window.location='delete_book?bookId='+bookId;
				}
			});
			
		});
	});
	
	</script>
</body>
</html>