package com.rgzn.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rgzn.entity.Course;
import com.rgzn.entity.Student;
import com.rgzn.service.StudentService;
import com.rgzn.service.impl.StudentServiceImpl;

@WebServlet("/servlet/StudentServlet")
public class StudentServlet extends BaseServlet{
	
	StudentService stuService = new StudentServiceImpl();
	
	
	/**
	 * 学生取消选课
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void cancelCou(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Student stu = (Student)req.getSession().getAttribute("user");
		int sno = Integer.parseInt(stu.getSno());
		int tno = Integer.parseInt(req.getParameter("tno"));
		int cno = Integer.parseInt(req.getParameter("cno"));
		
		int flag = stuService.cancelCou(sno, tno, cno);
		if(flag>0) {
			resp.sendRedirect(req.getContextPath()+"/servlet/StudentServlet?method=getSelectedCou");
		}
		
		
	}
	
	/**
	 * 学生查看已选择课程
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getSelectedCou(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Student stu = (Student)req.getSession().getAttribute("user");
		int sno = Integer.parseInt(stu.getSno());
		List<Course> selectedCourList = stuService.getSelectedCour(sno);
		req.setAttribute("couList", selectedCourList);
		req.getRequestDispatcher("/files/courseSelectedList.jsp").forward(req, resp);
		
		
	}
	
	/**
	 * 学生增加一门选课
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addTsc(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Student stu = (Student)req.getSession().getAttribute("user");
		int sno = Integer.parseInt(stu.getSno());
		
		String[] str = req.getParameterValues("delid");
		for (String s : str) {
			String[] ct = s.split("#");
			int cno = Integer.parseInt(ct[0]);
			int tno = Integer.parseInt(ct[1]);
			int flag = stuService.addTsc(sno, cno, tno);
			
			if (flag == 0) {
				req.setAttribute("msg", "你已经选择该课程"+cno);
				req.getRequestDispatcher("/servlet/StudentServlet?method=getCouAndTea").forward(req, resp)	;
				return ;
			}
			
		}
		resp.sendRedirect(req.getContextPath()+"/servlet/StudentServlet?method=getSelectedCou");
		
	}
	
	
	/**
	 * 学生选课老师和课程
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getCouAndTea(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Course> allCou = stuService.findCouAndTea();
		req.setAttribute("allCou", allCou);
		req.getRequestDispatcher("/files/courseSelectList.jsp").forward(req, resp);
	}
	
}
