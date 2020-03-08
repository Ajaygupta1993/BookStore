<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:directive.include file = "header.jsp" />
<div align="center">
<h2 class="pageHeading">New Book</h2>
<div  align="center" >
<div align="center" style="width: 80%; margin: 0 auto;">
<c:forEach items="${listNewBook}" var="book">
              <div style="display: inline-block; margin: 20px; margin: 0 auto;">
				<div>
				<a href="view_book?id=${book.bookId}">
				<img  src="data:image/jpg;base64,${book.base64Image}" width="84" height="90">
				</a>
				</div>
				<div>
				<a href="view_book?id=${book.bookId}">
				<b>${book.bookTitle}</b>
				</a>
				</div>
				<div>Rating ****</div>
				<div><i>${book.bookAuther }</i></div>
				<div><b>${book.bookPrice }</b></div>
			</div>


</c:forEach>

</div>
<div align="center" style="clear: both">
<h2 class="pageHeading">Best selling book</h2>
</div>
<div align="center" style="clear: both">
<h2 class="pageHeading">Fav book </h2>
</div>
</div>
</div>

<jsp:directive.include file = "footer.jsp" />
</body>
</html>