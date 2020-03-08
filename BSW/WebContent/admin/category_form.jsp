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
     <c:if test="${category != null }">
      <h2 class="pageHeading">Edit category</h2>
     </c:if>
     <c:if test="${category == null }">
		<h2 class="pageHeading">Create New category</h2>
		</c:if>

	</div>
	
   
   
   
   <div align="center">
   <c:if test="${category != null}">
    <form action="update_category" method="post" id="categoryForm">
    <input type="hidden" name="categoryId" value="${category.categoryId }">
   </c:if>
   <c:if test="${category == null}">
   <form action="create_category" method="post" id="categoryForm">
   </c:if>
   <table class="form">
   <tr>
   <td>category Name</td>
   <td><input type="text" name="category" size="20" id="category" value="${category.categoryName }"></td>
   </tr>
  <%--  <tr>
   <td>Full Name</td>
   <td><input type="text" name="userName" size="20" id="userFullName" value="${user.userName }"></td>
   </tr>
   <tr>
   
   <td>Password</td>
   <td><input type="password" name="password" size="20" id="passwordUser" value="${user.userPassword }"></td>
   </tr> --%>
   <tr><td>&nbsp;</td></tr>
   <tr colspan="2" align="center">
   <c:if test="${category != null}">
   <td collspan="2" align="center"><button type="submit" >Update</button></td>
   </c:if>
    <c:if test="${category == null}">
   <td collspan="2" align="center"><button type="submit" >Save</button></td>
    </c:if>
   <td><button type="reset" >Cancel</button></td>
   </tr>
   </table>
   </form>
   </div>
   
	
	<jsp:directive.include file="footer.jsp" />
</body>
<script type="text/javascript">
$(function() {
	  $("#categoryForm").validate({
		  
		  rules: {
			  category:"required"
		    },
		   
		    messages: {
		    	category:"Category is required"
		    }
		
			
		});
	 /*  $("#cancelButton").click(function(){
		  history.go(-1);
	  }); */
		
	});   




function validate(){
	var category=document.getElementById("category");
	if(category.value.length == 0){
		alert("category is required");
		category.focus();
		return false;
	}
	return true;
	
}




</script>
</html>