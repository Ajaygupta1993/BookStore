<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Write Review</title>
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src="js/jquery.validate.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>
</head>
<body>
<jsp:directive.include file = "header.jsp" />
	<div align="center">
	<form action="submit_review" id="reviewForm" method="post">
	
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
	<div id="rateYo"></div>
	<input type="hidden" id="rating" name="rating" />
	<input type="hidden" id="bookId" name="bookId" value="${book.bookId}">
	<br/>
	<input type="text" name="headline" id="headline" size="60" placeholder="headline">
	<br/>
	<br/>
	<textarea rows="10" cols="70" name="commenet" id="commenet" placeholder="Write your details...."></textarea>
	</td>
	</tr>
	<tr>
	<td colspan="5" align="center">
	<button type="submit">Submit</button>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<button id="buttonCancel">Cancel</button>
	</td>
	</tr>
	
	</table>
	
	</form>
	
	</div>
<jsp:directive.include file = "footer.jsp" />
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$("#reviewForm").validate({
			rules : {
				headline : "required",
				commenet : "required"
			},

			messages : {
				
				headline : "Please Enter your headline",
				commenet : "Please enter a commenet"
				
			}

		});
		
		$("#rateYo").rateYo({
		    starWidth: "40px",
		    fullStar:true,
		    onSet: function(rating,rateYoInstance){
		    	alert("==========="+rating)
		    	$("#rating").val(rating);
		    }
		  });
	});
</script>
</html>