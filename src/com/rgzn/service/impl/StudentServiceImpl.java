package com.rgzn.service.impl;

import com.rgzn.dao.StudentDao;
import com.rgzn.dao.impl.StudentDaoImpl;
import com.rgzn.entity.Student;
import com.rgzn.service.StudentService;

public class StudentServiceImpl implements StudentService {
	
	StudentDao StudentDao = new StudentDaoImpl();
	@Override
	public Student findByNameAndPwd(String name, String pwd) {
		return StudentDao.selectByNameAndPwd(name, pwd);
	}

}
