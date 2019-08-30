package com.rgzn.dao;

import java.util.List;

import com.rgzn.entity.Course;

public interface CourseDao {
	//添加一门课程
	public int insertOneCourse(Course cou);
	//查询所有课程和任课老师
	public List<Course> selectAllCourseAndTeacher();
	//查询所有课程
	public List<Course> selectAllCou();
	//查询该老师所担任的课程
	public List<Course> selectCouByTno(int tno);
	
}
