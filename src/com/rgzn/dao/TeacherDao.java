package com.rgzn.dao;

import java.util.List;

import com.rgzn.entity.Teacher;

public interface TeacherDao {
	//查询所有老师
	public List<Teacher> selectAllTea();
	//根据姓名和密码查询所单个老师
	public Teacher selectByNameAndPwd(String name, String pwd);
	//插入一条数据
	public int insertOneTeacher(Teacher tea);
	//删除一条数据
	public int delOneTea(int tno);
	//根据编号查询老师
	public Teacher selectTeaByTno(int tno);
	//修改老师
	public int updateTea(Teacher tea);
}
