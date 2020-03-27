<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../css/style.css">

<title>Create New Category</title>
<script src="../js/jquery-3.4.1.min.js" type="text/javascript" ></script>
<script src="../js/jquery.validate.min.js" type="text/javascript" ></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
   <div align="center">
     <c:if test="${review != null }">
      <h2 class="pageHeading">Edit Review</h2>
     </c:if>
   
	</div>
   <div align="center">
   
    <form action="update_review" method="post" id="reviewForm">
    <input type="hidden" name="reviewId" value="${review.reviewId }">
   <table class="form">
   <tr>
   <td>Book</td>
   <td><b>${review.book.bookTitle}</b></td>
   </tr>
   <tr>
   <td>Rating</td>
   <td><b>${review.reviewRating}</b></td>
   </tr>
   <tr>
   <td>Customer</td>
   <td><b>${review.customer.customerFullName}</b></td>
   </tr>
   <tr>
   <td>Head Line</td>
   <td><input type="text" name="reviewHeadline" id="reviewHeadline" value="${review.reviewHeadline}"/></td>
   
   </tr>
   <tr>
   <td>Comment</td>
   <td><textarea rows="5" cols="70" name="comment" id="comment">${review.reviewComment}</textarea></td>
   </tr>
  
   <tr><td>&nbsp;</td></tr>
   <tr colspan="2" align="center">
   
   <td collspan="2" align="center"><button type="submit" >Update</button></td>
  
   <td><button type="reset" >Cancel</button></td>
   </tr>
   </table>
   </form>
   </div>
   
	
	<jsp:directive.include file="footer.jsp" />
</body>
<script type="text/javascript">
$(function() {
	  $("#reviewForm").validate({
		  
		  rules: {
			  reviewHeadline:"required",
			  comment:"required"
		    },
		   
		    messages: {
		    	reviewHeadline:"reviewHeadline is required",
		    	comment:"reviewHeadline is required"
		    }
		});
		
	});   




/* function validate(){
	var category=document.getElementById("category");
	if(category.value.length == 0){
		alert("category is required");
		category.focus();
		return false;
	}
	return true;
	
} */




</script>
</html>