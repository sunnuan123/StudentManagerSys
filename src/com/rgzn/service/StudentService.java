package com.rgzn.service;

import java.util.List;

import com.rgzn.entity.Course;
import com.rgzn.entity.Student;

public interface StudentService {
	//根据名字和密码查询学生
	public Student findByNameAndPwd(String name, String pwd);
	//查询所有的课程和对应的老师
	public List<Course> findCouAndTea();
	//提交选中的课程
	public int addTsc(int sno, int cno, int tno);
	//查看已选择的课程
	public List<Course> getSelectedCour(int sno);
	//取消已选的课程
	public int cancelCou(int sno, int tno, int cno);
}
