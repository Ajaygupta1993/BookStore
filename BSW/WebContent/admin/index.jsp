<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book store admin</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<hr width="60%" />
		<h2 class="pageHeading">Quick action</h2>
		<b> <a href="new_book">New Book</a>&nbsp; 
		<a href="user_form.jsp">New
				Users</a>&nbsp;
				 <a href="category_form.jsp">New Category</a>&nbsp; <a
			href="create_customer">New Customer</a>&nbsp;
		</b>
	</div>
	<hr width="60%" />
	<div align="center">
		<h2>Recent Sales</h2>

	</div>
	<hr width="60%" />
	<div align="center">
		<h2>Recent Review</h2>

	</div>
	<hr width="60%" />
	<div align="center">
		<h2>Recent Statistics</h2>

	</div>
	<hr width="60%" />
	<jsp:directive.include file="footer.jsp" />
</body>
</html>