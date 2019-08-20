package com.rgzn.service;

import com.rgzn.entity.Student;

public interface StudentService {
	//根据名字和密码查询学生
	public Student findByNameAndPwd(String name, String pwd);
	
}
