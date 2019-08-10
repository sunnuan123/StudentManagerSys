package com.rgzn.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rgzn.entity.Admin;
import com.rgzn.service.AdminService;
import com.rgzn.service.impl.AdminServiceImpl;

@WebServlet("/servlet/User")
public class User extends HttpServlet{

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("utf-8");
		
		String method = req.getParameter("method");
		if("login".equals(method)) {
			login(req,resp);
		}else if("logout".equals(method)) {
			logout(req, resp);
		}
	
	}
	
	/**
	 * 用户登录
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//乱码的处理
		req.setCharacterEncoding("utf-8");
		//数据的接收
		String username = req.getParameter("name");
		String password = req.getParameter("pwd");
		//数据处理
		AdminService adminService = new AdminServiceImpl();
		Admin admin = adminService.login(username, password);
		
		if (admin != null) {
			//统计登录人数
			ServletContext context = req.getServletContext();
			Integer count  = (Integer)context.getAttribute("count");
			if(count == null) {
				count = 1;
			}else{
				count++;
			}
			context.setAttribute("count", count);
			 
			req.getSession().setAttribute("admin", admin);
			resp.sendRedirect(req.getContextPath()+"/index.html");
		}else {
			req.setAttribute("msg", "账号密码不匹配");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);;
		}
		
	}
	
	/**
	 * 用户退出
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}
	
}
