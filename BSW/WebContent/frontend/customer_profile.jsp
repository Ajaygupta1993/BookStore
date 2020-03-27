<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Profile</title>
</head>
<body>
   <jsp:directive.include file="header.jsp" />
    <div align="center">
    <h2>Welcome, ${customerLogedin.customerFullName}</h2>
    
   

	<table border="0">
		<tr>
			<td><b>E-Mail Address:</b></td>
			<td>${customerLogedin.customerEmail}</td>
		</tr>
		<tr>
			<td><b>Full Name:</b></td>
			<td>${customerLogedin.customerFullName}</td>
		</tr>
		<tr>
			<td><b>Phone Number:</b></td>
			<td>${customerLogedin.customerPhone}</td>
		</tr>
		<tr>
			<td><b>Address:</b></td>
			<td>${customerLogedin.customerAddress}</td>
		</tr>
		<tr>
			<td><b>City:</b></td>
			<td>${customerLogedin.customerCity}</td>
		</tr>
		<tr>
			<td><b>ZipCode:</b></td>
			<td>${customerLogedin.customerZipCode}</td>
		</tr>
		<tr>
			<td><b>Country:</b></td>
			<td>${customerLogedin.customerCountry}</td>
		</tr>
		<tr>
		<td>&nbsp;</td>
		</tr>
		<tr>
		<td colspan="2" align="center"><a href="edit_profile">Edit Profile</a>
		</td>
		</tr>
		

	</table>
	 </div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html>