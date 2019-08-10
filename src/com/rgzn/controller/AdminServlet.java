package com.rgzn.controller;

import java.io.IOException;
import java.security.Provider.Service;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;

import com.rgzn.entity.Admin;
import com.rgzn.entity.Student;
import com.rgzn.service.AdminService;
import com.rgzn.service.impl.AdminServiceImpl;

@WebServlet("/servlet/AdminServlet")
public class AdminServlet extends HttpServlet{
	
	AdminService adminService = new AdminServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		
		String method = req.getParameter("method");
		if("registerAdmin".equals(method)) {
			registerAdmin(req, resp);
		}else if("getAllStu".equals(method)) {
			getAllStu(req,resp);
		}else if("registerStu".equals(method)) {
			registerStu(req, resp);
		}else if("getOneStu".equals(method)) {
			getOneStu(req, resp);
		}else if("modStu".equals(method)) {
			modStu(req,resp);
		}else if("moveStu".equals(method)) {
			moveStu(req, resp);
		}
	
	}
	

	/**
	 * 管理员删除学生
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void moveStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sno = req.getParameter("sno");
		
		int flag = adminService.delOneStu(sno);
		if(flag > 0) {
			resp.sendRedirect(req.getContextPath()+"/servlet/AllStudent");
		}
	}
	
	/**
	 * 管理员修改学生信息
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void modStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		
		String sno = req.getParameter("sno");
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		String phone = req.getParameter("phone");
		String gender = req.getParameter("gender");
		Date birthday = Date.valueOf(req.getParameter("birthday"));
		Integer classno = Integer.parseInt(req.getParameter("classno"));
		String remark = req.getParameter("remark");
	
		Student stu = new Student(sno, name, pwd, phone, gender, birthday, classno, remark);
		int flag = adminService.modStu(stu);
		if(flag > 0) {
			resp.sendRedirect(req.getContextPath()+"/servlet/AdminServlet?method=getAllStu");
		}
		
	
	}
	
	/**
	 * 管理员获取一个学生
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getOneStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sno = req.getParameter("sno");
		Student stu = adminService.findOneStu(sno);
		if(stu != null) {
			req.setAttribute("stu", stu);
			req.getRequestDispatcher("/files/studentUpdate.jsp").forward(req, resp);
		}else {
			
		}
		
	}
	
	/**
	 * 管理员注册学生
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void registerStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
			resp.sendRedirect(req.getContextPath()+"/servlet/AdminServlet?method=getAllStu");
		}else {
			req.setAttribute("msg", "注册失败");
			req.getRequestDispatcher("/files/studentRegister.jsp").forward(req, resp);
		}
		
	}
	
	/**
	 * 管理员注册管理员
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void registerAdmin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
	
	/**
	 * 管理员获取所有学生
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getAllStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
