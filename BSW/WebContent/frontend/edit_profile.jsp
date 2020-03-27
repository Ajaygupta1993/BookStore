<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edit profile</title>
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src="js/jquery.validate.min.js" type="text/javascript"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		Edit My Profile

	</div>
	<div align="center">
		
			<form action="update_profile" method="post" id="customerform">
				
		
		<table class="form">
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" size="40" id="email"
					value="${customerLogedin.customerEmail }" readonly="true"></td>
			</tr>
			<tr>
				<td>FullName</td>
				<td><input type="text" name="fullName" size="20" id="fullName"
					value="${customerLogedin.customerFullName}"></td>
			</tr>
			
			
			<tr>
				<td>Phone</td>
				<td><input type="text" name="phone" maxlength="10" id="phone"
					value="${customerLogedin.customerPhone}"></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" size="40" id="address"
					value="${customerLogedin.customerAddress}"></td>
			</tr>
			
			<tr>
				<td>City</td>
				<td><input type="text" name="city" size="20" id="city"
					value="${customerLogedin.customerCity}"></td>
			</tr>
			<tr>
				<td>Zip Code</td>
				<td><input type="text" name="zipCode" size="6" id="zipCode"
					value="${customerLogedin.customerZipCode}"></td>
			</tr>
			<tr>
				<td>Country</td>
				<td><input type="text" name="country" size="20" id="country"
					value="${customerLogedin.customerCountry}"></td>
			</tr>
			<tr>
			<td colspan="2" align="center"> Leave Password field if you don't want to change</td>
			</tr>
             <tr>
				<td>Password</td>
				<td><input type="password" name="password" size="20" id="password"
					></td>
			</tr>
			
			<tr>
				<td>Confirm Password</td>
				<td><input type="password" name="cnfPassword" size="20" id="cnfPassword"
					></td>
			</tr>

			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr colspan="2" align="center">
					<td colspan="2"><button type="submit">Update</button></td>
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
				cnfPassword:{
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
				cnfPassword:{
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
</html>







