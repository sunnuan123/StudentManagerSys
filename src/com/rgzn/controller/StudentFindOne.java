package com.rgzn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rgzn.entity.Student;
import com.rgzn.service.AdminService;
import com.rgzn.service.impl.AdminServiceImpl;

@WebServlet("/servlet/StudentOne")
public class StudentFindOne extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	AdminService adminService = new AdminServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sno = req.getParameter("sno");
		Student stu = adminService.findOneStu(sno);
		if(stu != null) {
			req.setAttribute("stu", stu);
			req.getRequestDispatcher("/files/studentUpdate.jsp").forward(req, resp);
		}else {
			
		}
		
	}
	
}
