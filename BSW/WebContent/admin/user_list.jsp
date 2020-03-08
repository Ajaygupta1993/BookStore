<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

		<h2 class="pageHeading">User Management</h2>
		<a href="user_form.jsp">Create New USer</a>
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
	<th>Email</th>
	<th>Full Name</th>
	<th>Action</th>
	
	</tr>
	
	<c:forEach var="users" items="${listUser}" varStatus="status">
	<tr>
	<td>${status.index +1}</td>
	<td>${users.userId}</td>
	<td>${users.userEmail}</td>
	<td>${users.userName}</td>
	<td>
	<a href="edit_user?id=${users.userId}">Edit</a>|
	<a href="javascript:void(0)" class="deleteLink" id="${users.userId}">Delete</a>
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
				var userID=$(this).attr("id");
				if(confirm('Are You Sure want to delete with  this userId '+userID+'?')){
					window.location='delete_user?id='+userID;
				}
			});
			
		});
	});
	
	
	
	/* function confermDelete(userID){
		if(confirm('Are You Sure want to delete with  this userId '+userID+'?')){
			window.location='delete_user?id='+userID;
		}
	} */
	</script>
</body>
</html>