package com.bookstore.controller.frontend;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class CustomerLoginFilter implements Filter {
	private static final String[] LOGIN_REQUIRED_URLS = { "/edit_profile", "/update_profile", "/view_profile" };
	public CustomerLoginFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession session = httpServletRequest.getSession(false);
		String path = httpServletRequest.getRequestURI().substring(httpServletRequest.getContextPath().length());
		if (path.startsWith("/admin/")) {
			chain.doFilter(request, response);
			return;
		}
		boolean loogedIn = session != null && session.getAttribute("customerLogedin") != null;
		String requestURL = httpServletRequest.getRequestURI().toString();
		System.out.println("============Path:::::" + path);
		System.out.println("============loogedIn:::::" + loogedIn);
		if (!loogedIn && isLoginedRequired(requestURL)) {
			String loginpage = "frontend/login.jsp";
			RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher(loginpage);
			requestDispatcher.forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}
	private boolean isLoginedRequired(String requestURI) {
		for (String loginRequiredURL : LOGIN_REQUIRED_URLS) {
			if (requestURI.contains(loginRequiredURL)) {
				return true;
			}
		}
		return false;
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}
}
