package com.rgzn.service.impl;

import com.rgzn.dao.TeacherDao;
import com.rgzn.dao.impl.TeacherDaoImpl;
import com.rgzn.entity.Teacher;
import com.rgzn.service.TeacherService;

public class TeacherServiceImpl implements TeacherService{
	TeacherDao teacherDao = new TeacherDaoImpl();
	@Override
	public Teacher findByNameAndPWd(String name, String pwd) {
		return teacherDao.selectByNameAndPwd(name, pwd);
	}

}
