package com.rgzn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RbacFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest)req;
		HttpServletResponse httpServletResponse = (HttpServletResponse)res;
		
		HttpSession session = httpServletRequest.getSession();
		Object obj = session.getAttribute("role");
		
		String uri = httpServletRequest.getRequestURI();
//		System.out.println(uri);
		
		if("/Test02/login.jsp".equals(uri) || "/Test02/servlet/User".equals(uri)||
				"/Test02/servlet/Random.jpg".equals(uri)) {
			//放行
			chain.doFilter(httpServletRequest, httpServletResponse);
		}else {
			if(obj == null) {
				//没有登录
				httpServletResponse.sendRedirect("/Test02/login.jsp");
			}else {
				//放行
				chain.doFilter(httpServletRequest, httpServletResponse);
			}
		}
		
		
		
		
		
		
	}

}
