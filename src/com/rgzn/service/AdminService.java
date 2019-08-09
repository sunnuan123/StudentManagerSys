package com.rgzn.service;

import java.util.List;

import com.rgzn.entity.Admin;
import com.rgzn.entity.Student;

public interface AdminService {
	//登录
	public Admin login(String name, String pwd);
	//注册
	public int AdminRegister(Admin admin);
	//管理员插入单个学生
	public int addStudent(Student stu);
	//管理员查询所有的学生
	public List<Student> findAllStu();
	//管理员查询单个学生
	public Student findOneStu(String sno);
	//管理员修改单个学生
	public int modStu(Student stu);
	//管理员删除单个学生
	public int delOneStu(String sno);
	
}
