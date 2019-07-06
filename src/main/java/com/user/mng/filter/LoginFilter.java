package com.user.mng.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		String loginURI = req.getContextPath() + "/login.html";
		String validateURI = req.getContextPath() + "/validateUser.html";
		String signUpURI = req.getContextPath() + "/sign-up.jsp";

		boolean isLogin = session != null && session.getAttribute("isLogin") != null;
		boolean loginRequest = req.getRequestURI().equals(loginURI);
		boolean validateRequest = req.getRequestURI().equals(validateURI);
		boolean signUpRequest= req.getRequestURI().equals(signUpURI);

		if (isLogin || loginRequest || validateRequest || signUpRequest) {
			chain.doFilter(req, res);
		} else {
			res.sendRedirect(loginURI);
		}

	}

}
