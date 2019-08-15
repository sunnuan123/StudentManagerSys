package com.rgzn.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;

import com.rgzn.entity.Admin;
import com.rgzn.entity.Class;
import com.rgzn.entity.Course;
import com.rgzn.entity.Student;
import com.rgzn.service.AdminService;
import com.rgzn.service.impl.AdminServiceImpl;

@WebServlet("/servlet/AdminServlet")
public class AdminServlet extends BaseServlet {

	AdminService adminService = new AdminServiceImpl();

	/*
	 * @Override public void service(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException {
	 * 
	 * req.setCharacterEncoding("utf-8");
	 * 
	 * String method = req.getParameter("method");
	 * if("registerAdmin".equals(method)) { registerAdmin(req, resp); }else
	 * if("getAllStu".equals(method)) { getAllStu(req,resp); }else
	 * if("registerStu".equals(method)) { registerStu(req, resp); }else
	 * if("getOneStu".equals(method)) { getOneStu(req, resp); }else
	 * if("modStu".equals(method)) { modStu(req,resp); }else
	 * if("moveStu".equals(method)) { moveStu(req, resp); }
	 * 
	 * }
	 */
	
	//管理员查询所有的课程和任课老师
	public void getAllCouAndTea(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Course> allCou = adminService.findAllCourseAndTeacher();
		req.setAttribute("allCou", allCou);
		
		req.getRequestDispatcher("/files/courseList.jsp").forward(req, resp);
	}
	
	//管理员添加一门课程
	public void addOneCourse(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cname = req.getParameter("cname");
		int credit = Integer.parseInt(req.getParameter("credit"));
		Date startDate = Date.valueOf(req.getParameter("startDate"));
		Date endDate = Date.valueOf(req.getParameter("endDate"));
		Course cou = new Course(cname, credit, startDate, endDate);
		int flag = adminService.addOneCourse(cou);
		if(flag > 0) {
			resp.sendRedirect(req.getContextPath()+"/servlet/getAllCouAndTea");
		}
		
	}
	
	public void getAllClass(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List list = adminService.findAllClass();
		req.setAttribute("allClass", list);
		req.getRequestDispatcher("/files/studentRegister.jsp").forward(req, resp);
		
	}
	
	
	public void getStuByNameAndCls(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		int classno = Integer.parseInt(req.getParameter("classno"));
		
		List<Student> list = adminService.findStuByNameAndCla(name, classno);
		List<Class> allClass = adminService.findAllClass();
		req.setAttribute("allStu", list);
		req.setAttribute("sname", name);
		req.setAttribute("classno", classno);
		req.setAttribute("allClass", allClass);
		req.getRequestDispatcher("/files/studentList.jsp").forward(req, resp);

	}

	/**
	 * 管理员删除学生
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void moveStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sno = req.getParameter("sno");

		int flag = adminService.delOneStu(sno);
		if (flag > 0) {
			resp.sendRedirect(req.getContextPath() + "/servlet/AllStudent");
		}
	}

	/**
	 * 管理员修改学生信息
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void modStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
		if (flag > 0) {
			resp.sendRedirect(req.getContextPath() + "/servlet/AdminServlet?method=getAllStu");
		}

	}

	/**
	 * 管理员获取一个学生
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getOneStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sno = req.getParameter("sno");
		Student stu = adminService.findOneStu(sno);
		List<Class> allClass = adminService.findAllClass();
		
		if (stu != null) {
			req.setAttribute("allClass", allClass);
			req.setAttribute("stu", stu);
			req.getRequestDispatcher("/files/studentUpdate.jsp").forward(req, resp);
		} else {

		}

	}

	/**
	 * 管理员注册学生
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void registerStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
			resp.sendRedirect(req.getContextPath() + "/servlet/AdminServlet?method=getAllStu");
		} else {
			req.setAttribute("msg", "注册失败");
			req.getRequestDispatcher("/files/studentRegister.jsp").forward(req, resp);
		}

	}

	/**
	 * 管理员注册管理员
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void registerAdmin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
			resp.sendRedirect(req.getContextPath() + "/files/right.html");
		} else {
			req.setAttribute("msg", "注册失败");
			req.getRequestDispatcher(req.getContextPath() + "/files/adminRegister.jsp");
		}

	}

	/**
	 * 管理员获取所有学生
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getAllStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		List<Student> allStu = adminService.findAllStu();
		List<Class> allClass = adminService.findAllClass();
		if (allStu != null) {
			req.setAttribute("allClass", allClass);
			req.setAttribute("allStu", allStu);
			req.getRequestDispatcher("/files/studentList.jsp").forward(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + "/files/error.jpg");
		}

	}

}
