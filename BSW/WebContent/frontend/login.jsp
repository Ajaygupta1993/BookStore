<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src="js/jquery.validate.min.js" type="text/javascript"></script>
</head>
<body>
<jsp:directive.include file = "header.jsp" />
	<div align="center">
		<h2>User Login</h2>
		<c:if test="${message !=null }">
	<div align="center">
	
	<h3 class="pageHeading">${message}</h3>
	</div>
	</c:if>
		<form action="login" method="post" id="loginform">
			<table class="form">
				<tr>
					<td>&nbsp;&nbsp;Email:</td>
					<td><input type="text" name="email" id="email" maxlength="30"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" id="password"
						maxlength="20"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><button type="submit">Login</button></td>

				</tr>


			</table>
		</form>

	</div>
<jsp:directive.include file = "footer.jsp" />
</body>
<script type="text/javascript">
	$(function() {
		$("#loginform").validate({

			rules : {
				email : {
					required : true,
					email : true
				},
				password : "required",
			},

			messages : {
				email : {
					required : "Please Enter your email",
					email : "Please enter a valid email"
				},
				password : "Please Enter Your password"
			}

		});

	});
</script>
</html>