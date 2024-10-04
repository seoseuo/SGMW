package com.ssk.web.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter(urlPatterns = { "*.do" })
public class AuthenticationFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	// public AuthenticationFilter() {
	// super();
	// TODO Auto-generated constructor stub
	// }

	/**
	 * @see Filter#destroy()
	 */
	// public void destroy() {
	// TODO Auto-generated method stub
	// }

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		System.out.println("AuthenticationFilter 수행");
		// 세션에 userId 정보가 등록되어 있는지 확인합니다.
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession();

		String uri = req.getRequestURI();

		// 관리자 필터

		if (uri.equals("/login.do")) {
			System.out.println("AuthenticationFilter 로그인");
			chain.doFilter(request, response);
		}

		else if (session.getAttribute("admin") != null || session.getAttribute("professor") != null
				|| session.getAttribute("student") != null) {
			chain.doFilter(request, response);
			
		} 
		else {
			// pass the request along the filter chain
			res.sendRedirect("/");
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	// public void init(FilterConfig fConfig) throws ServletException {
	// TODO Auto-generated method stub
	// }

}
