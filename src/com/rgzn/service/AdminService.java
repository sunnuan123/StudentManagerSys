package com.rgzn.service;

import java.util.List;

import com.rgzn.entity.Admin;
import com.rgzn.entity.Class;
import com.rgzn.entity.Course;
import com.rgzn.entity.Student;
import com.rgzn.entity.TeaAndCou;
import com.rgzn.entity.Teacher;
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
	//管理员按名字和班级查询
	public List<Student> findStuByNameAndCla(String name, int cls);
	//管理员查询所有班级
	public List<Class> findAllClass();
	//管理员添加课程
	public int addOneCourse(Course cou);
	//管理员查询所有课程课和老师
	public List<Course> findAllCourseAndTeacher();
	//管理员查询所有课程
	public List<Course> findAllCou();
	//管理员查询所有老师
	public List<Teacher> findAllTea();
	//管理员指定课程给老师
	public int addCouToTea(TeaAndCou tac);
	//管理员取消老师分配的课程
	public int delTc(int tno, int cno);
	//管理员插入一条老师数据
	public int addOneTea(Teacher tea);
	//删除一位老师
	public int delOneTea(int tno);
	//根据编号查询一位老师
	public Teacher findTeaByTno(int tno);
	//修改老师信息
	public int modTea(Teacher tea);
}
