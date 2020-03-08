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
<title>Manage Category</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">

		<h2 class="pageHeading">Category Management</h2>
		<a href="category_form.jsp">Create New Category</a>
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
				<th>Category</th>
				<th>Action</th>

			</tr>

			<c:forEach var="listCategory" items="${listCategory}"
				varStatus="status">
				<tr>
					<td>${status.index +1}</td>
					<td>${listCategory.categoryId}</td>
					<td>${listCategory.categoryName}</td>
					<td><a href="edit_category?id=${listCategory.categoryId}">Edit</a>|
					<a href="javascript:void(0)" class="deleteLink" id="${listCategory.categoryId}">Delete</a>
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
				var categoryId=$(this).attr("id");
				if(confirm('Are You Sure want to delete with  this Category '+categoryId+'?')){
					window.location='delete_category?categoryId='+categoryId;
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