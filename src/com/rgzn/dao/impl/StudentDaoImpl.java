package com.rgzn.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rgzn.dao.StudentDao;
import com.rgzn.entity.Student;
import com.rgzn.utils.DBUtil;
import com.rgzn.entity.Class;

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

		
		String sql = "select * from t_student stu left join t_class cls on stu.classno = cls.classno";
		Object[] params = {};
		
		List<Student> stuList = new ArrayList<Student>();
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
				
				int clsno = Integer.parseInt(rs.getString(9));
				String cname = rs.getString(10);
				String cteacher = rs.getString(11);
				String classroom = rs.getString(12);
				
				
				Class cls = new Class(clsno, cname, cteacher, classroom);
				
				Student stu = new Student(sno, name, pwd, phone, gender, birthday, classno, remark, cls);
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
	
	/**
	 * 删除学生
	 */
	@Override
	public int delStu(String sno) {
		
		String sql = "delete from t_student where sno = ?";
		Object[] params = {sno};
		int flag = DBUtil.executeUpdate(sql, params);
		
		DBUtil.closeAll();
		return flag;
	}
	
	/**
	 * 根据班级和姓名查询学生
	 */
	@Override
	public List<Student> selectByNameAndCls(String sname, int cls) {
		String sql = "select * from t_student stu left join t_class cls on stu.classno = cls.classno where 1=1";
		if(null != sname && !"".equals(sname)) {
			sql += " and stu.sname like '%"+sname+"%'";
		}
		if(cls>0) {
			sql += " and stu.classno = "+cls;
		}
		
		Object[] params = {};
		
		List<Student> stuList = new ArrayList<Student>();
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
				int clsno = Integer.parseInt(rs.getString(9));
				String cname = rs.getString(10);
				String cteacher = rs.getString(11);
				String classroom = rs.getString(12);
				
				
				Class clas = new Class(clsno, cname, cteacher, classroom);
				
				Student stu = new Student(sno, name, pwd, phone, gender, birthday, classno, remark, clas);
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
	 * 通过名字和密码查询单个学生
	 */
	@Override
	public Student selectByNameAndPwd(String name, String pwd) {
		String sql = "select * from t_student where sname=? and pwd=?";
		Object[] params = {name, pwd};
		
		ResultSet rs = DBUtil.executeQuery(sql, params);
		Student stu = null;
		try {
			while(rs.next()) {
				String sno = String.valueOf(rs.getInt(1));
				String pwd1 = rs.getString(2);
				String name1 = rs.getString(3);
				String phone = rs.getString(4);
				String gender = rs.getString(5);
				Date birthday = rs.getDate(6);
				int classno = rs.getInt(7);
				String remark = rs.getString(8);
				
				stu = new Student(sno, name1, pwd1, phone, gender, birthday, classno, remark);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll();
		}
		
		
		
		return stu;
	}

}
