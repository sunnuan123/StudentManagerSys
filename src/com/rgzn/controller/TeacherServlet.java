package com.rgzn.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rgzn.entity.SCC;
import com.rgzn.entity.Teacher;
import com.rgzn.service.TeacherService;
import com.rgzn.service.impl.TeacherServiceImpl;

@WebServlet("/servlet/teacherServlet")
public class TeacherServlet extends BaseServlet{
	
	TeacherService teacherService = new TeacherServiceImpl();
	
	/**
	 * 得到课程学生
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getAllSCC(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Teacher tea = (Teacher)req.getSession().getAttribute("user");
		int tno = tea.getTno();
		List<SCC> allSCC = teacherService.findAllStu(tno);
		req.setAttribute("allSCC", allSCC);
		req.getRequestDispatcher("/files/mark.jsp").forward(req, resp);
		
	}
	/**
	 * 评分
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	public void setScore(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Teacher tea = (Teacher)req.getSession().getAttribute("user");
		int tno = tea.getTno();
		int sno = Integer.parseInt(req.getParameter("sno"));
		int cno = Integer.parseInt((req.getParameter("cno")));
		int score = Integer.parseInt(req.getParameter("score"));

		int flag = teacherService.setScore(score, sno, cno, tno);
		if(flag>0) {
			
			resp.sendRedirect(req.getContextPath()+"/servlet/teacherServlet?method=getAllSCC");
		}
		
		
		
	}
	
	
	
}
