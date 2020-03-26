<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Customer</title>
<link rel="stylesheet" href="../css/style.css" />
<!-- <link rel="stylesheet" href="../css/jquery-ui.min.css"/> -->
<script src="../js/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src="../js/jquery.validate.min.js" type="text/javascript"></script>
<!-- <script src="../js/jquery.richtext.min.js" type="text/javascript"></script> -->
<!-- <link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="../css/richtext.min.css"> -->


<!-- <script src="../js/jquery-ui.min.js" type="text/javascript" ></script> -->
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<c:if test="${customer != null }">
			<h2 class="pageHeading">Edit Customer</h2>
		</c:if>
		<c:if test="${customer == null }">
			<h2 class="pageHeading">Create New Customer</h2>
		</c:if>

	</div>




	<div align="center">
		<c:if test="${customer != null}">
			<form action="update_customer" method="post" id="customerform">
				<input type="hidden" name="customerId" value="${customer.customerId }" />
		</c:if>
		<c:if test="${customer == null}">
			<form action="create_customer" method="post" id="customerform">
				
		</c:if>
		<table class="form">
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" size="40" id="email"
					value="${customer.customerEmail }"></td>
			</tr>
			<tr>
				<td>FullName</td>
				<td><input type="text" name="fullName" size="20" id="fullName"
					value="${customer.customerFullName}"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" size="20" id="password"
					value="${customer.customerPassword}"></td>
			</tr>
			
			<tr>
				<td>Confirm Password</td>
				<td><input type="password" name="cnfPassword" size="20" id="cnfPassword"
					value="${customer.customerPassword}"></td>
			</tr>
			
			<tr>
				<td>Phone</td>
				<td><input type="text" name="phone" maxlength="10" id="phone"
					value="${customer.customerPhone}"></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" size="40" id="address"
					value="${customer.customerAddress}"></td>
			</tr>
			
			<tr>
				<td>City</td>
				<td><input type="text" name="city" size="20" id="city"
					value="${customer.customerCity}"></td>
			</tr>
			<tr>
				<td>Zip Code</td>
				<td><input type="text" name="zipCode" size="6" id="zipCode"
					value="${customer.customerZipCode}"></td>
			</tr>
			<tr>
				<td>Country</td>
				<td><input type="text" name="country" size="20" id="country"
					value="${customer.customerCountry}"></td>
			</tr>


			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr colspan="2" align="center">
				<c:if test="${customer != null}">
					<td colspan="2"><button type="submit">Update</button></td>
				</c:if>
				<c:if test="${customer == null}">
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
		$("#customerform").validate({

			rules : {
				email:{
					required:true,
					email:true
				},
				fullName : "required",
				password : "required",
				cnfPassword:{
					required:true,
					equalTo:"#password"
				},
				phone:"required",
				address : "required",
				city : "required",
				zipCode : "required",
				country : "required"
			},

			messages : {
				email :{
					required:"Please enter email",
					email:"Please eneter a valid email address"
				},
				fullName : "Please Enter Full Name",
				password : "Please Enter Password",
				cnfPassword:{
					required:"Please enter Password",
					equalTo:"Confirm password does not matched"
				},
				phone:"Please enter phone number",
				address : "Please Select Address",
				city : "Please Select City",
				zipCode : "Please Enter the city Zip Code",
				country : "Please Enter Your Country"
			}

		});

	});
</script>
<script type="text/javascript">

/* function confirmPassword(){
	var password=document.getElementById('password').value;
	var cnfPassword=document.getElementById('cnfPassword').value;
	if(password != cnfPassword){
		alert("Please enter the same password");
		return false;
	}
} */

</script>
</html>







