package com.rgzn.service.impl;

import java.util.List;

import com.rgzn.dao.AdminDao;
import com.rgzn.dao.ClassDao;
import com.rgzn.dao.CourseDao;
import com.rgzn.dao.StudentDao;
import com.rgzn.dao.TeaAndCouDao;
import com.rgzn.dao.TeacherDao;
import com.rgzn.dao.impl.AdminDaoImpl;
import com.rgzn.dao.impl.ClassDaoImpl;
import com.rgzn.dao.impl.CourseDaoImpl;
import com.rgzn.dao.impl.StudentDaoImpl;
import com.rgzn.dao.impl.TeaAndCouDaoImpl;
import com.rgzn.dao.impl.TeacherDaoImpl;
import com.rgzn.entity.Admin;
import com.rgzn.entity.Class;
import com.rgzn.entity.Course;
import com.rgzn.entity.Student;
import com.rgzn.entity.TeaAndCou;
import com.rgzn.entity.Teacher;
import com.rgzn.service.AdminService;

public class AdminServiceImpl implements AdminService {
	
	private AdminDao adminDao = new AdminDaoImpl();
	private StudentDao studentDao  =new StudentDaoImpl();
	private ClassDao classDao = new ClassDaoImpl();
	private CourseDao courseDao = new CourseDaoImpl();
	private TeacherDao teacherDao = new TeacherDaoImpl();
	private TeaAndCouDao teaAndCouDao = new TeaAndCouDaoImpl();
	@Override
	public Admin login(String name, String pwd) {

		return adminDao.selectOne(name, pwd);
	}
	@Override
	public int AdminRegister(Admin admin) {
		return adminDao.insert(admin);
	}
	
	@Override
	public int addStudent(Student stu) {
		
		return studentDao.insertOne(stu);
	}
	@Override
	public List<Student> findAllStu() {
		return studentDao.selectAll();
	}
	@Override
	public Student findOneStu(String sno) {
		return studentDao.selectOne(sno);
	}
	@Override
	public int modStu(Student stu) {
		return studentDao.updateStu(stu);
	}
	@Override
	public int delOneStu(String sno) {
		return studentDao.delStu(sno);
	}
	@Override
	public List<Student> findStuByNameAndCla(String name, int cls) {
		return studentDao.selectByNameAndCls(name, cls);
	}
	@Override
	public List<Class> findAllClass() {
		return classDao.selectAllClass();
	}
	@Override
	public int addOneCourse(Course cou) {
		return courseDao.insertOneCourse(cou);
	}
	@Override
	public List<Course> findAllCourseAndTeacher() {
		return courseDao.selectAllCourseAndTeacher();
	}
	@Override
	public List<Course> findAllCou() {
		return courseDao.selectAllCou();
	}
	@Override
	public List<Teacher> findAllTea() {
		return teacherDao.selectAllTea();
	}
	@Override
	public int addCouToTea(TeaAndCou tac) {
		return teaAndCouDao.insertTeaAndCou(tac);
	}
	@Override
	public int delTc(int tno, int cno) {
		return teaAndCouDao.delOneTc(tno, cno);
	}

}
