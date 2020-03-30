<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align="center">
<a href="${pageContext.request.contextPath}">
<img  src="images/BookstoreLogo.png">
</a>
<div>
<form action="search" method="get">
<input type="text" name="keyword" size="50">
<input type="submit" value="Search">
</form>
&nbsp; &nbsp; &nbsp;

<c:if test="${customerLogedin == null}">
   <a href="login">SignIn</a>|&nbsp; &nbsp;
   <a href="register">Register</a>|&nbsp; &nbsp;
   
</c:if>

<c:if test="${customerLogedin != null}">
   <a href="view_profile">Welcome, ${customerLogedin.customerFullName}</a>|&nbsp; &nbsp;
   <a href="view_order">My Order</a>|&nbsp; &nbsp;
   <a href="#">Cart</a>|&nbsp; &nbsp;
   <a href="logout">Logout</a>|&nbsp; &nbsp;
</c:if>
<a href="view_cart">Cart</a>|&nbsp; &nbsp;



</div>
<div>&nbsp;</div>
<div>
<c:forEach var="listCategory" items="${listCategory}"
				varStatus="status">
				
					<a href="view_category?id=${listCategory.categoryId}">
					<font size="+1"><b><c:out value="${listCategory.categoryName}"></c:out></b></font>
					
					</a>
					<c:if test="${not status.last}">
					&nbsp; &nbsp;
					</c:if>

			</c:forEach>


</div>


</div>