<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../css/style.css">
<title>Add Book to order</title>
</head>
<body>
  <div align="center">
  <h2>Add Book to Order ID: ${order.orderId}</h2>
     <form action="add_book_to_order" method="post">
       <table>
       <tr>
       <td>Select a book</td>
       <td>
       <select name="bookId">
       
       <c:forEach items="${ listBook}" var="book" varStatus="status">
       <option value="${book.bookId}">
       ${book.bookTitle} - ${book.bookAuther }
        </option>
       </c:forEach>
       </select>
       </td>
       </tr>
       <tr></tr>
       <tr></tr>
       <tr>
       
       <td>No. Of Quantity</td>
       
       <td>
       <select name="quantity">
       <option value="1">1</option>
       <option value="2">2</option>
       <option value="3">3</option>
       <option value="4">4</option>
       <option value="5">5</option>
       </select>
       </td>
       </tr>
       <tr>
       <td>&nbsp;&nbsp;</td>
       <td align="center">
       <input type="submit" value="Add">
       
       </td>
       
       </tr>
       </table>
     
     
     </form>
  </div>
</body>
</html>