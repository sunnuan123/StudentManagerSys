package com.rgzn.service.impl;

import java.util.List;

import com.rgzn.dao.AdminDao;
import com.rgzn.dao.StudentDao;
import com.rgzn.dao.impl.AdminDaoImpl;
import com.rgzn.dao.impl.StudentDaoImpl;
import com.rgzn.entity.Admin;
import com.rgzn.entity.Student;
import com.rgzn.service.AdminService;

public class AdminServiceImpl implements AdminService {
	
	private AdminDao adminDao = new AdminDaoImpl();
	private StudentDao studentDao  =new StudentDaoImpl();
	
	@Override
	public Admin login(String name, String pwd) {

		return adminDao.selectOne(name, pwd);
	}
	@Override
	public int AdminRegister(Admin admin) {
		return adminDao.insert(admin);
	}
	
	@Override
	public int addStudent(Student stu) {
		
		return studentDao.insertOne(stu);
	}
	@Override
	public List<Student> findAllStu() {
		return studentDao.selectAll();
	}
	@Override
	public Student findOneStu(String sno) {
		return studentDao.selectOne(sno);
	}
	@Override
	public int modStu(Student stu) {
		return studentDao.updateStu(stu);
	}
	@Override
	public int delOneStu(String sno) {
		return studentDao.delStu(sno);
	}

}
