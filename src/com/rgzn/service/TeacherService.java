package com.rgzn.service;

import com.rgzn.entity.Teacher;

public interface TeacherService {
	//根据名字和密码查询
	public Teacher findByNameAndPWd(String name, String pwd);
	
}
