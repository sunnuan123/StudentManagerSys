package com.rgzn.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rgzn.dao.StudentDao;
import com.rgzn.entity.Student;
import com.rgzn.utils.DBUtil;

public class StudentDaoImpl implements StudentDao {
	/**
	 * 插入一条数据
	 */
	@Override
	public int insertOne(Student stu) {
		String sql = "insert into t_student(pwd, sname, phone, gender, birth, classno, remark)"
				+ " values(?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {stu.getPwd(), stu.getName(), stu.getPhone(), stu.getGender(), 
				stu.getBirthday(), stu.getClassno(), stu.getRemark()};
		
		int flag = DBUtil.executeUpdate(sql, params);
		
		DBUtil.closeAll();
		
		return flag;
	}

	/**
	 * 查询所有的学生
	 */
	@Override
	public List<Student> selectAll() {

		List<Student> stuList = new ArrayList<Student>();
		String sql = "select * from t_student";
		Object[] params = {};
		
		
		ResultSet rs = DBUtil.executeQuery(sql, params);
		try {
			while(rs.next()) {
				String sno = Integer.toString(rs.getInt(1));
				String pwd = rs.getString(2);
				String name = rs.getString(3);
				String phone = rs.getString(4);
				String gender = rs.getString(5);
				Date birthday = rs.getDate(6);
				int classno = rs.getInt(7);
				String remark = rs.getString(8);
				Student stu = new Student(sno, name, pwd, phone, gender, birthday, classno, remark);
				stuList.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll();
		}
		
		return stuList;
	}

	/**
	 * 查询单个学生
	 */
	@Override
	public Student selectOne(String sno) {
		
		String sql = "select * from t_student where sno = ?";
		Object[] params = {sno};
		
		ResultSet rs = DBUtil.executeQuery(sql, params);
		Student stu = null;
		try {
			while(rs.next()) {
				String pwd = rs.getString(2);
				String name = rs.getString(3);
				String phone = rs.getString(4);
				String gender = rs.getString(5);
				Date birthday = rs.getDate(6);
				int classno = rs.getInt(7);
				String remark = rs.getString(8);
				
				stu = new Student(sno, name, pwd, phone, gender, birthday, classno, remark);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll();
		}
		
		
		return stu;
	}
	
	/**
	 * 修改单个学生
	 */
	@Override
	public int updateStu(Student stu) {
		String sql = "update t_student set sname=?, pwd=?, phone=?, gender=?, "
				+ "birth=?, classno=?, remark=? where sno=?";

		Object[] params = {stu.getName(),stu.getPwd(),stu.getPhone(),stu.getGender(),
				stu.getBirthday(),stu.getClassno(),stu.getRemark(),stu.getSno()};
		
		int flag = DBUtil.executeUpdate(sql, params);
		return flag;
	}

	@Override
	public int delStu(String sno) {
		
		String sql = "delete from t_student where sno = ?";
		Object[] params = {sno};
		int flag = DBUtil.executeUpdate(sql, params);
		
		DBUtil.closeAll();
		return flag;
	}

}
