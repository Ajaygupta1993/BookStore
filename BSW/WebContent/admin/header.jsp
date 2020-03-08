<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align="center">
	<div>
		<img src="../images/BookstoreAdminLogo.png">
	</div>
	<div>
		Welcome <c:out value="${sessionScope.userEmail}"/> <a href="logout">Logout</a>
	</div>
	<br>
	 <div id="headerMenu"> 
	<div style="display: table-cell; padding-right: 20px;" >
		<a href="list_user"> <img src="../images/users.png"><br />Users
		</a>
	</div>
	<div >
		<a href="list_category"> <img src="../images/category.png"><br/>
			Category
		</a>
	</div>
	<div >
		<a href="list_book"> <img src="../images/bookstack.png"><br/>Book</a>
	</div>
	<div >
		<a href="#"> <img src="../images/customer.png"><br/>Customers</a>
	</div>
	<div >
		<a href="#"><img src="../images/review.png"><br/>Reviews</a> 
	</div>
	<div >
		<a href="#"> <img src="../images/order.png"><br/>Orders</a>
	</div>
	</div>
</div>
