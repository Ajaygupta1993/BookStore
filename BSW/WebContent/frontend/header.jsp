<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align="center">
<img  src="images/BookstoreLogo.png">
<div>
<form action="search" method="get">
<input type="text" name="keyword" size="50">
<input type="submit" value="Search">
</form>
&nbsp; &nbsp; &nbsp;
<a href="#">SignIn</a>|&nbsp; &nbsp;
<a href="#">Register</a>|&nbsp; &nbsp;
<a href="#">Cart</a>|&nbsp; &nbsp;

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