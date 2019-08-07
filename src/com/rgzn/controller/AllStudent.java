package com.rgzn.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rgzn.entity.Student;
import com.rgzn.service.AdminService;
import com.rgzn.service.impl.AdminServiceImpl;

@WebServlet("/servlet/AllStudent")
public class AllStudent extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AdminService adminService = new AdminServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		List<Student> allStu  =adminService.findAllStu();
		if(allStu != null) {
			req.setAttribute("allStu", allStu);
			req.getRequestDispatcher("/files/studentList.jsp").forward(req, resp);
		}else {
			resp.sendRedirect(req.getContextPath()+"/files/error.jpg");
		}
		
	}
}
