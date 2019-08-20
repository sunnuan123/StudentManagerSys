package com.rgzn.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rgzn.dao.TeacherDao;
import com.rgzn.dao.impl.TeacherDaoImpl;
import com.rgzn.service.AdminService;
import com.rgzn.service.StudentService;
import com.rgzn.service.impl.AdminServiceImpl;
import com.rgzn.service.impl.StudentServiceImpl;

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
		
		String yzm = req.getParameter("yzm");
		String randomStr = (String)req.getSession().getAttribute("randStr");
		if(null == yzm || "".equals(yzm) || !randomStr.equals(yzm)) {
			req.setAttribute("error", "验证码错误");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return ;
		}
		
		Object user = null;
		//数据处理
		String role = req.getParameter("role");
		HttpSession session = req.getSession();
		session.setAttribute("role", role);
		session.setAttribute("username", username);
		if("admin".equals(role)) {
			AdminService adminService = new AdminServiceImpl();
			user = adminService.login(username, password);
		}else if("student".equals(role)) {
			StudentService  studentService = new StudentServiceImpl();
			user = studentService.findByNameAndPwd(username, password);
		}else if("teacher".equals(role)) {
			TeacherDao teacherDao = new TeacherDaoImpl();
			user = teacherDao.selectByNameAndPwd(username, password);
		}
		
		
		if (user != null) {
			//统计登录人数
			ServletContext context = req.getServletContext();
			Integer count  = (Integer)context.getAttribute("count");
			if(count == null) {
				count = 1;
			}else{
				count++;
			}
			context.setAttribute("count", count);
			 
			session.setAttribute("user", user);
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
