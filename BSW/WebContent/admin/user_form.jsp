<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
<link rel="stylesheet" href="../css/style.css">
<script src="../js/jquery-3.4.1.min.js" type="text/javascript" ></script>
<script src="../js/jquery.validate.min.js" type="text/javascript" ></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
   <div align="center">
     <c:if test="${user != null }">
      <h2 class="pageHeading">Edit User</h2>
     </c:if>
     <c:if test="${user == null }">
		<h2 class="pageHeading">Create New User</h2>
		</c:if>

	</div>
	
   
   
   
   <div align="center">
   <c:if test="${user != null}">
    <form action="update_user" method="post" id="userform">
    <input type="hidden" name="userId" value="${user.userId }">
   </c:if>
   <c:if test="${user == null}">
   <form action="create_user" method="post" id="userform" >
   </c:if>
   <table class="form">
   <tr>
   <td>Email</td>
   <td><input type="text" name="email" size="20" id="email" value="${user.userEmail }"></td>
   </tr>
   <tr>
   <td>Full Name</td>
   <td><input type="text" name="userName" size="20" id="userName" value="${user.userName }"></td>
   </tr>
   <tr>
   
   <td>Password</td>
   <td><input type="password" name="password" size="20" id="password" value="${user.userPassword }"></td>
   </tr>
   <tr><td>&nbsp;</td></tr>
   <tr colspan="2" align="center">
   <c:if test="${user != null}">
   <td colspan="2"><button type="submit" >Update</button></td>
   </c:if>
    <c:if test="${user == null}">
    <td colspan="2" ><button type="submit" >Save</button></td>
    </c:if>
   <td colspan="2" ><button type="reset" >Cancel</button></td>
   </tr>
   </table>
   </form>
   </div>
   
	
	<jsp:directive.include file="footer.jsp" />
</body>
<script type="text/javascript">

 $(function() {
	  $("#userform").validate({
		  
		  rules: {
		    	email:{
		    		required: true,
		    		email: true
		    	},
		    	userName:"required",
		    	password:"required",
		    },
		   
		    messages: {
		    	email:{
		    		required:"Please Enter your email",
		    		email:"Please enter a valid email"
		    	},
		    	userName:"Please Enter your FullName",
		    	password:"Please Enter Your password"
		    }
		
			
		});
	 /*  $("#cancelButton").click(function(){
		  history.go(-1);
	  }); */
		
	});   
	  


/* $(function() {
	BY Name
	alert("============s")
	  $("form[name='userform']").validate({
	    // Specify validation rules
	    rules: {
	    	email:"required",
	    	userName:"required",
	    	password:"required",
	    },
	   
	    messages: {
	    	email:"Please Enter your email",
	    	userName:"Please Enter your FullName",
	    	password:"Please Enter Your password"
	    },
	    submitHandler: function(form) {
	      form.submit();
	    }
	  });
	}); */


 /* function validate(){
var emailfield=document.getElementById("emailfield");
var userFullName=document.getElementById("userFullName");
var passwordUser=document.getElementById("passwordUser");
if(emailfield.value.length == 0){
	alert("Email is required");
	emailfield.focus();
	return false;
}
if(userFullName.value.length == 0){
	alert("UserName is required");
	userFullName.focus();
	return false;
}
if(passwordUser.value.length == 0){
	alert("Password is required");
	passwordUser.focus();
	return false;
}
return true;

}  */
</script>
</html>







