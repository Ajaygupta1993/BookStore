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
<title>Reviews</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">

		<h2 class="pageHeading">Review Management</h2>
		<!-- <a href="category_form.jsp">Create New Category</a> -->
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
				<th>Id</th>
				<th>Book</th>
				<th>Rating</th>
				<th>Head Line</th>
				<th>Customer</th>
				<th>Review On</th>
				<th>Action</th>

			</tr>

			<c:forEach var="review" items="${listReview}"
				varStatus="status">
				<tr>
					<td>${status.index +1}</td>
					<td>${review.reviewId}</td>
					<td>${review.book.bookTitle}</td>
					<td>${review.reviewRating}</td>
					<td>${review.reviewHeadline}</td>
					<td>${review.customer.customerFullName}</td>
					<td>${review.reviewDate}</td>
					
					<td><a href="edit_review?reviewId=${review.reviewId}">Edit</a>|
					<a href="javascript:void(0)" class="deleteLink" id="${review.reviewId}">Delete</a>
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
				var reviewId=$(this).attr("id");
				if(confirm('Are You Sure want to delete with  this Review '+reviewId+'?')){
					window.location='delete_review?reviewId='+reviewId;
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