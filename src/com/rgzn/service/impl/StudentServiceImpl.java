package com.rgzn.service.impl;

import java.util.List;

import com.rgzn.dao.StudentDao;
import com.rgzn.dao.TeaAndCouDao;
import com.rgzn.dao.TscDao;
import com.rgzn.dao.impl.StudentDaoImpl;
import com.rgzn.dao.impl.TeaAndCouDaoImpl;
import com.rgzn.dao.impl.TscDaoImpl;
import com.rgzn.entity.Course;
import com.rgzn.entity.Student;
import com.rgzn.service.StudentService;

public class StudentServiceImpl implements StudentService {
	
	StudentDao studentDao = new StudentDaoImpl();
	TeaAndCouDao tad = new TeaAndCouDaoImpl();
	TscDao tscDao = new TscDaoImpl();
	
	@Override
	public Student findByNameAndPwd(String name, String pwd) {
		return studentDao.selectByNameAndPwd(name, pwd);
	}
	@Override
	public List<Course> findCouAndTea(int sno) {
		// TODO Auto-generated method stub
		return tad.selectTeaAndCou(sno);
	}
	@Override
	public int addTsc(int sno, int cno, int tno) {
		// TODO Auto-generated method stub
		return tscDao.insertTsc(sno, tno, cno);
	}
	@Override
	public List<Course> getSelectedCour(int sno) {
		return tscDao.selectAllBySno(sno);
	}
	@Override
	public int cancelCou(int sno, int tno, int cno) {
		return tscDao.delOne(sno, tno, cno);
	}

}
