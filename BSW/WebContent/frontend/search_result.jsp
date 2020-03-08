<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results for ${keyword}</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<table width="80%" style="border: 0">
			<c:if test="${fn:length(result) ==0}">
				<tr>
					<td>
						<div align="center">

							<h2 class="pageHeading">No Result Found for ${keyword}</h2>

						</div>
					</td>

				</tr>
			</c:if>
			<c:if test="${fn:length(result) > 0}">
				<tr>

					<td colspan="3" align="left">
						<div align="center">

							<h2 class="pageHeading">${keyword}</h2>

						</div>

					</td>

				</tr>
				<c:forEach items="${result}" var="book">


					<tr>
						<td rowspan="2"><a href="view_book?id=${book.bookId}"> <img
								src="data:image/jpg;base64,${book.base64Image}" width="84"
								height="90">
						</a></td>
						<td valign="top" align="left">Rating ****
							<h2>
								<a href="view_book?id=${book.bookId}"> <b>${book.bookTitle}</b>
								</a>
							</h2>
						</td>
						<td valign="top" rowspan="2" width="20%">
							<h2>$${book.bookPrice}</h2> <br />


							<button type="submit">AddToCart</button>
						</td>

					</tr>
					<tr>
						<td valign="top" style="text-align: justify;">
							<p>${fn:substring(book.bookDescription,0,100)}...</p>



						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>

	<jsp:directive.include file="footer.jsp" />
</body>
</html>