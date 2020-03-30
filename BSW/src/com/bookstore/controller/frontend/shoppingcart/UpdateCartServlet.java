package com.bookstore.controller.frontend.shoppingcart;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update_cart")
public class UpdateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateCartServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] arrayBookIds= request.getParameterValues("bookId");
		String[] arrayquantitys=new String[arrayBookIds.length];
		for(int i=1; i<=arrayquantitys.length; i++) {
			String aQuantity=request.getParameter("quantity"+i);
			arrayquantitys[i -1]=aQuantity;
		}
		//Testing the array
		/*response.getWriter().println(Arrays.asList(arrayBookIds));
		response.getWriter().println(Arrays.asList(arrayquantitys));*/
		//response.getWriter().println(arrayquantitys);
		/* Java 8 is using here strem and lembda expression for converting the 
		 * String array in integer array*/
		int[] bookIds=Arrays.stream(arrayBookIds).mapToInt(Integer::parseInt).toArray();
		int[] quantities=Arrays.stream(arrayquantitys).mapToInt(Integer::parseInt).toArray();
		ShoppingCart shoppingCart=(ShoppingCart) request.getSession().getAttribute("cart");
		shoppingCart.update(bookIds, quantities);
		String cartPage=request.getContextPath().concat("/view_cart");
        response.sendRedirect(cartPage);
	}

}
