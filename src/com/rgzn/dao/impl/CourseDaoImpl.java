package com.rgzn.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rgzn.dao.CourseDao;
import com.rgzn.entity.Course;
import com.rgzn.entity.Teacher;
import com.rgzn.utils.DBUtil;

public class CourseDaoImpl implements CourseDao{

	@Override
	public int insertOneCourse(Course cou) {
		String sql = "insert into t_course(cname, credit, periodstart, periodend) values(?, ?, ?, ?)";
		Object[] params = {cou.getCname(), cou.getCredit(), cou.getPeriodStart(), cou.getPeriodEnd()};
		
		int flag = DBUtil.executeUpdate(sql, params);
		
		DBUtil.closeAll();
		
		return flag;
	}

	@Override
	public List<Course> selectAllCourseAndTeacher() {
		String sql = "select * from t_course cou left join t_tc tc on "
				+ "tc.cno = cou.cno left join t_teacher tea on tea.tno = tc.tno";
		Object[] params = {};
		ResultSet rs = DBUtil.executeQuery(sql, params);
		
		List list = new ArrayList<Course>();
		try {
			while(rs.next()) {
				int cno = Integer.parseInt(rs.getString(1));
				String cname = rs.getString(2);
				int credit = Integer.parseInt(rs.getString(3));
				Date startDate = rs.getDate(4);
				Date endDate = rs.getDate(5);
				
				
				int tno = rs.getInt("tno");
				String tname = rs.getString("tname");
				String tpwd = rs.getString("tpwd");
				String tphone = rs.getString("tphone");
				Date hireDate = rs.getDate("hiredate");
				String remark = rs.getString("remark");
				
				Teacher teacher = new Teacher(tno, tname, tpwd, tphone, hireDate, remark);
				
				Course cou = new Course(cno, cname, credit, startDate, endDate, teacher);
				
				list.add(cou);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll();
		}
		
		
		return list;
	}

	@Override
	public List<Course> selectAllCou() {
		String sql = "select * from t_course";
		Object[] params = {};
		ResultSet rs = DBUtil.executeQuery(sql, params);
		List list = new ArrayList<Course>();
		
		try {
			while(rs.next()) {
				int cno = rs.getInt("cno");
				String cname = rs.getString("cname");
				int credit = rs.getInt("credit");
				Date periodStart = rs.getDate("periodstart");
				Date periodEnd = rs.getDate("periodend");
				Course course = new Course(cno, cname, credit, periodStart, periodEnd);
				list.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll();
		}
		
		return list;
	}

	@Override
	public List<Course> selectCouByTno(int tno) {
		String sql = "select * from t_course cou join t_tc tc on tc.cno=cou.cno"
				+ " join t_teacher tea on tea.tno=tc.tno where tc.tno=?";
		Object[] params = {tno};
		ResultSet rs = DBUtil.executeQuery(sql, params);
		List list = new ArrayList<Course>();
		try {
			while(rs.next()) {
				int cno = rs.getInt("cno");
				String cname = rs.getString("cname");
				int credit = rs.getInt("credit");
				Date periodStart = rs.getDate("periodstart");
				Date periodEnd = rs.getDate("periodend");
				Course course = new Course(cno, cname, credit, periodStart, periodEnd);
				list.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll();
		}
		
		return list;
	}

}
