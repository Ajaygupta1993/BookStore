<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${book.bookTitle}</title>
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src="js/jquery.validate.min.js" type="text/javascript"></script>
</head>
<body>
<jsp:directive.include file = "header.jsp" />
	<div align="center">
		<table width="80%" style="border: 0">
		<%-- <c:forEach items="${book}" var="book"> --%>
			<tr>
				<td colspan="3" align="left">
					<div align="left">

						<h2 class="pageHeading">${book.bookTitle}</h2>
						By ${book.bookAuther}
					</div>

				</td>

			</tr>
			
			<tr>
				<td rowspan="2">

					<img  src="data:image/jpg;base64,${book.base64Image}" width="240" height="300">
					

				</td>
				<td valign="top" align="left">
				  <jsp:directive.include file="book_rating.jsp" />
				</td>
				<td valign="top" rowspan="2" width="20%">
				<h2>$${book.bookPrice}</h2>
				<br/>
				
				<button id="buttonAddToCart">AddToCart</button>
				</td>

			</tr>
			<tr>
			<td valign="top" style="text-align: justify;">
			 ${book.bookDescription}
			</td>
			</tr>
			<tr>
			<td><h2>Customer Review</h2></td>
			<td colspan="2"><button id="buttonWriteReview">Write Customer Review</button></td>
			</tr>
			
			<tr>
			<td colspan="3">
			<table border="0">
			<c:forEach items="${book.reviews}">
			<tr>
			<td>
			<c:forTokens items="${book.ratingStars}" delims="," var="star">
				<c:if test="${star eq 'on' }">
				<img  src="images/rating_on.png">
				</c:if>
				<c:if test="${star eq 'half' }">
				<img  src="images/rating_half.png">
				</c:if>
				</c:forTokens>
			${reviews.reviewHeadline}
			</td>
			</tr>
			</c:forEach>
			</table>
			</td>
			</tr>

		
		</table>
	</div>
<jsp:directive.include file = "footer.jsp" />
<script type="text/javascript">
$(document).ready(function(){
	$('#buttonWriteReview').click(function(){
		window.location='write_review?book_id='+${book.bookId};
		
	});
	$('#buttonAddToCart').click(function(){
		window.location='add_to_cart?book_id='+${book.bookId};
		
	});
});

</script>
</body>
</html>