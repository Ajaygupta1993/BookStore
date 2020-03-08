<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Book</title>
<link rel="stylesheet" href="../css/style.css" />
<!-- <link rel="stylesheet" href="../css/jquery-ui.min.css"/> -->
<script src="../js/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src="../js/jquery.validate.min.js" type="text/javascript"></script>

<!-- <script src="../js/jquery-ui.min.js" type="text/javascript" ></script> -->
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<c:if test="${book != null }">
			<h2 class="pageHeading">Edit Book</h2>
		</c:if>
		<c:if test="${book == null }">
			<h2 class="pageHeading">Create New Book</h2>
		</c:if>

	</div>




	<div align="center">
		<c:if test="${book != null}">
			<form action="update_book" method="post" id="bookform"
				enctype="multipart/form-data">
				<input type="hidden" name="bookid" value="${book.bookId }" />
		</c:if>
		<c:if test="${book == null}">
			<form action="create_book" method="post" id="bookform"
				enctype="multipart/form-data">
		</c:if>
		<table class="form">
			<tr>
				<td>Category</td>
				<td><select name="category">

						<c:forEach items="${listCategory}" var="category">

							<%--  <c:if test="${category.categoryId == book.category.categoryId}">
							  
								<option value="${category.categoryId}"  selected/>
							</c:if>  --%>
							 <%-- <c:if test="${category.categoryId != book.category.categoryId}">
							 
								<option value="${category.categoryId}" />
							</c:if>  --%>
							<option value="${category.categoryId}">
								${category.categoryName }
								</option>

						</c:forEach>

				</select></td>
			</tr>
			<tr>
				<td>Title</td>
				<td><input type="text" name="title" size="20" id="title"
					value="${book.bookTitle }"></td>
			</tr>
			<tr>
				<td>Auther</td>
				<td><input type="text" name="auther" size="20" id="auther"
					value="${book.bookAuther }"></td>
			</tr>
			<tr>
				<td>ISBN</td>
				<td><input type="text" name="isbn" size="20" id="isbn"
					value="${book.bookIsbn }"></td>
			</tr>
			<tr>
				<td>PblishDate</td>
				<td><input type="date" name="pblishDate" size="20"
					id="pblishDate" value="${book.bookPublishDate }"></td>
			</tr>

			<tr>
				<td>Book Image:</td>
				<td><input type="file" name="bookImage" id="bookImage"
					size="20"></br> <img id="thumbnail" alt="image preview"
					style="width: 20%; margin-top: 10px"
					src="data:image/jpg;base64,${book.base64Image}" /></td>
			</tr>

			<tr>
				<td>Price:</td>
				<td><input type="text" name="price" id="price" size="5"
					value="${book.bookPrice }"></td>
			</tr>

			<tr>
				<td>Descreption:</td>
				<td><textarea rows="5" cols="50" name="descreption"
						id="descreption">${book.bookDescription}</textarea></td>
			</tr>

			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr colspan="2" align="center">
				<c:if test="${book != null}">
					<td colspan="2"><button type="submit">Update</button></td>
				</c:if>
				<c:if test="${book == null}">
					<td colspan="2"><button type="submit">Save</button></td>
				</c:if>
				<td colspan="2"><button type="reset">Cancel</button></td>
			</tr>
		</table>
		</form>
	</div>


	<jsp:directive.include file="footer.jsp" />
</body>
<script type="text/javascript">
	$(function() {
		$("#bookImage").change(function() {
			showImageThumbnail(this);

		});
		$("#bookform").validate({

			rules : {

				title : "required",
				auther : "required",
				isbn : "required",
				pblishDate : "required",
				<c:if test="${book == null}">
				bookImage : "required",
				</c:if>
				price : "required",
				descreption : "required"
			},

			messages : {
				title : "Please Enter Title",
				auther : "Please Enter auther",
				isbn : "Please Enter isbn",
				pblishDate : "Please Select PublishDate",
				bookImage : "Please Select BookImage",
				price : "Please Enter the Book Price",
				descreption : "Please Enter the Book descreption"
			}

		});

	});

	function showImageThumbnail(fileInput) {
		var file = fileInput.files[0];
		var reader = new FileReader();
		reader.onload = function(e) {
			$('#thumbnail').attr('src', e.target.result);

		};
		reader.readAsDataURL(file);

	}
</script>
</html>







