package com.rgzn.service.impl;

import java.util.List;

import com.rgzn.dao.CourseDao;
import com.rgzn.dao.TeacherDao;
import com.rgzn.dao.TscDao;
import com.rgzn.dao.impl.CourseDaoImpl;
import com.rgzn.dao.impl.TeacherDaoImpl;
import com.rgzn.dao.impl.TscDaoImpl;
import com.rgzn.entity.Course;
import com.rgzn.entity.SCC;
import com.rgzn.entity.Teacher;
import com.rgzn.service.TeacherService;

public class TeacherServiceImpl implements TeacherService{
	TeacherDao teacherDao = new TeacherDaoImpl();
	TscDao tscDao = new TscDaoImpl();
	CourseDao couDao = new CourseDaoImpl();
	
	@Override
	public Teacher findByNameAndPWd(String name, String pwd) {
		return teacherDao.selectByNameAndPwd(name, pwd);
	}
	@Override
	public List<SCC> findAllStu(int tno) {
		return tscDao.selectAllStu(tno);
	}
	@Override
	public int setScore(int score, int sno, int cno, int tno) {
		return tscDao.updateScore(score, sno, cno, tno);
	}
	@Override
	public List<Course> getCouByTno(int tno) {
		return couDao.selectCouByTno(tno);
	}

}
