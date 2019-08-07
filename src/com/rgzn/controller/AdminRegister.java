package com.rgzn.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;

import com.rgzn.entity.Admin;
import com.rgzn.service.AdminService;
import com.rgzn.service.impl.AdminServiceImpl;

@WebServlet("/servlet/AdminRegister")
public class AdminRegister extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AdminService adminService = new AdminServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		Date employdate = Date.valueOf(req.getParameter("employdate"));
		String gender = req.getParameter("gender");
		String hobby = Arrays.toString(req.getParameterValues("hobby"));
		String remark = req.getParameter("remark");
		Admin admin = new Admin(name, pwd, phone, email, gender, employdate, hobby, remark);
		int flag = adminService.AdminRegister(admin);
		if (flag > 0) {
			resp.sendRedirect(req.getContextPath()+"/files/right.html");
		}else {
			req.setAttribute("msg", "注册失败");
			req.getRequestDispatcher(req.getContextPath()+"/files/adminRegister.jsp");
		}
		
	}
	
}
