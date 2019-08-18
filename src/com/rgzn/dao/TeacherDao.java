package com.rgzn.dao;

import java.util.List;

import com.rgzn.entity.Teacher;

public interface TeacherDao {
	//查询所有老师
	public List<Teacher> selectAllTea();
}
