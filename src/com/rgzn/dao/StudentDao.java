package com.rgzn.dao;

import java.util.List;

import com.rgzn.entity.Student;

public interface StudentDao {
	//插入一条数据
	public int insertOne(Student student);
	//查询所有的学生
	public List<Student> selectAll();
	//查询单个学生
	public Student selectOne(String sno);
	//更新学生信息
	public int updateStu(Student stu);
	//删除学生
	public int delStu(String sno);
	//根据班级和姓名查询查询
	public List<Student> selectByNameAndCls(String name, int cls);
	//根据姓名和密码查询学生
	public Student selectByNameAndPwd(String name, String pwd);
	
}
