package com.lanou.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		/*
		 * 放行 login.html  和 adminLogin
		 * 放行 js下的静态资源
		 */
		String uri = req.getRequestURI();
		if(uri.endsWith("login.html") || uri.endsWith("adminLogin") || uri.contains("/js/") || uri.contains("/user/")){
			chain.doFilter(req, resp);
		}else{
			HttpSession session = req.getSession();
			Object obj = session.getAttribute("admin");
			if(obj!=null){
				chain.doFilter(req, resp);
			}else{
				resp.sendRedirect("/XXXManage/admin/login.html");
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

}
