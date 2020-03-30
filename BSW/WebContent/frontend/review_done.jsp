<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Review Posted</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:directive.include file = "header.jsp" />
	<div align="center">
	
	<table class="tableNone" width="60%">
	<tr>
	<td><h2>Your Reviews</h2></td>
	<td><h2>${customerLogedin.customerFullName}</h2></td>
	</tr>
	<tr>
	<td colspan="3"><hr/></td>
	</tr>
	
	<tr>
	
	<td colspan="3">
	<span id="book-title">${book.bookTitle}</span><br/>
	<img  src="data:image/jpg;base64,${book.base64Image}" width="90" height="100">
	
	</td>
	<td>
	<h3> Your Review has been posted thank You</h3>
	</td>
	
	</table>
	
	</div>
<jsp:directive.include file = "footer.jsp" />
</body>
</html>