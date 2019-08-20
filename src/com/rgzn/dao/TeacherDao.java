package com.rgzn.dao;

import java.util.List;

import com.rgzn.entity.Teacher;

public interface TeacherDao {
	//查询所有老师
	public List<Teacher> selectAllTea();
	//根据姓名和密码查询所单个老师
	public Teacher selectByNameAndPwd(String name, String pwd);
}
