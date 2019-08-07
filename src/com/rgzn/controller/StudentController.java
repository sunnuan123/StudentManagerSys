package com.rgzn.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rgzn.entity.Student;
import com.rgzn.service.AdminService;
import com.rgzn.service.impl.AdminServiceImpl;

@WebServlet("/servlet/StudentController")
public class StudentController extends HttpServlet{
	
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
		String gender = req.getParameter("gender");
		Date birthday = Date.valueOf(req.getParameter("birthday"));
		Integer classno = Integer.parseInt(req.getParameter("classno"));
		String remark = req.getParameter("remark");
	
		Student stu = new Student(name, pwd, phone, gender, birthday, classno, remark);
		int flag = adminService.addStudent(stu);
		
		if (flag > 0) {
			resp.sendRedirect(req.getContextPath()+"/servlet/AllStudent");
		}else {
			req.setAttribute("msg", "注册失败");
			req.getRequestDispatcher("/files/studentRegister.jsp").forward(req, resp);
		}
		
	}
}
